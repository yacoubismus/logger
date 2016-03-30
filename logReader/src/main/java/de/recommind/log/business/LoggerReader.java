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
	public void loggerReaderByLine(String fileName,
			Consumer<? super String> action) {

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.map(s -> );
			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LoggerBuilder createLoggerFromStringLine(String logLine){
		LoggerBuilder builder = new LoggerBuilder();
		Pattern pattern = Pattern.compile(REG_EX);
		Matcher matcher = pattern.matcher(logLine);
		if(matcher.find()){
			builder.setDateField(new DateAndTimeConveter().convertDate(matcher.group(dateTime)));
			builder.setLogLevel(matcher.group(logLevel));
			builder.setLogMessage(matcher.group(logMessage));
			builder.setLogThreadId(Integer.valueOf(matcher.group(threadNumber)));
			builder.setLogIdentifierClass(matcher.group(logClass));
			
			
		}
		return null;
	}

}