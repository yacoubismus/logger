package de.recommind.log.filter;

import java.util.List;
import java.util.function.Predicate;

import de.recommind.log.business.LoggerBuilder;

public class LoggerFilter {
	List<LoggerBuilder> loggers;
	
	public LoggerFilter(List<LoggerBuilder> loggers) {
		this.loggers = loggers;
	}
	
	public List<LoggerBuilder> filterLoggerList(String category , String value){
		this.loggers.stream().filter(p -> p.getLogLevel().equals(value));
		return null;
	}
	
	public Predicate<? extends LoggerBuilder> createFilterConcept(String category, String value) {
		Predicate<? extends LoggerBuilder> predicate = p -> {
			switch (category) {
			case "date":
				new DateAndTimeConveter().;
				return p.getDateField()> 
				break;
            case "logLevel":
				break;
            case "time":
	        break; 
            case "someText":
				break;

			default:
				break;
			}
			return false;
			
		};
		return predicate;
	}

}
