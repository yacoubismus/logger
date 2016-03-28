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

import de.recommind.log.model.Logger;

public class LoggerReader {
	Integer date = 1;
	Integer time = 2;
	Integer logLevel = 3;
	Integer logMessage = 4;
	Integer threadNumber = 5;
	Integer logClass = 6;
	LoggerBuilder builder;
	List<Logger> loggers = new ArrayList<Logger>();
	final String REG_EX = "\\s*(\\d{4}-\\d{2}-\\d{2}) \\s*(\\d{2}:\\d{2}:\\d{2},\\d{1,3})\\s*\\[(\\w+)\\] \\s*(.*)\\s*<([0-9]+)>\\s*(.*)";

	public void loggerReaderByLine(String fileName,
			Consumer<? super String> action) {

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			//stream.map(s -> );
			// stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Logger createLoggerFromStringLine(String logLine){
		
		Pattern pattern = Pattern.compile(REG_EX);
		Matcher matcher = pattern.matcher(logLine);
		if(matcher.find()){
			matcher.group(date);
			matcher.group(time);
			matcher.group(logLevel);
			matcher.group(logMessage);
			matcher.group(threadNumber);
			matcher.group(logClass);
			
			
		}
		return null;
	}

}
