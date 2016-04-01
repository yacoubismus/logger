package de.recommind.log.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import de.recommind.log.converter.DateAndTimeConveter;
import de.recommind.log.model.Logger;

import java.util.Collection;
import java.util.stream.Collectors;

public class LoggerReader {
	Integer dateTime = 1;
	Integer logLevel = 2;
	Integer logMessage = 3;
	Integer threadNumber = 4;
	Integer logClass = 5;
	
	LoggerBuilder builder;
	List<Logger> loggers = new ArrayList<Logger>();
	final String REG_EX = "\\s*(\\d{4}-\\d{2}-\\d{2} \\s*\\d{2}:\\d{2}:\\d{2}),\\d{1,3}\\s*\\[(\\w+)\\] \\s*(.*)\\s*<([0-9]+)>\\s*(.*)";
	//\s*(\d{4}-\d{2}-\d{2} \s*\d{2}:\d{2}:\d{2}),\d{1,3}\s*\[(\w+)\] \s*(.*)\s*<([0-9]+)>\s*(.*)
	@SuppressWarnings("unchecked")
	public List<LoggerBuilder> loggerReaderByLine(String fileName) {
		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			return (List<LoggerBuilder>) stream.map(createLambdaFunction())
                                .collect(Collectors.toList());	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LoggerBuilder createLoggerFromStringLine(String logLine){
		LoggerBuilder builder = new LoggerBuilder();
		Pattern pattern = Pattern.compile(REG_EX);
		Matcher matcher = pattern.matcher(logLine);
		if(matcher.find()){
			builder
                        .setDateField(new DateAndTimeConveter().convertDate(matcher.group(dateTime)))
			.setLogLevel(matcher.group(logLevel))
			.setLogMessage(matcher.group(logMessage))
			.setLogThreadId(Integer.valueOf(matcher.group(threadNumber)))
            .setLogIdentifierClass(matcher.group(logClass));
			
                        return builder;
        //(matcher.group(logClass));
			
			
		}
		return builder;
	}
        
        @SuppressWarnings("rawtypes")
		public java.util.function.Function createLambdaFunction(){
            java.util.function.Function<? super String, LoggerBuilder> function =
                        s -> { 
                            return createLoggerFromStringLine(s);                           
                        };
            return function;
        }
        
       

}
