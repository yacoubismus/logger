package de.recommind.log.filter;

import java.util.List;
import java.util.function.Predicate;

import de.recommind.log.business.LoggerBuilder;
import de.recommind.log.converter.DateAndTimeConveter;
import de.recommind.log.converter.IDateAndTimeConveter;

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
				return filterByDateAfter(p,value);
				
            case "logLevel":
            	filterByLoggerLevel(p,value);
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
	
	public boolean filterByDateAfter(LoggerBuilder logger, String dateAsString){
		IDateAndTimeConveter converter = new DateAndTimeConveter();
		return logger.getDateField().after(converter.convertDate(dateAsString));
	}
	
	public boolean filterByDateBefore(LoggerBuilder logger, String dateAsString){
		IDateAndTimeConveter converter = new DateAndTimeConveter();
		return logger.getDateField().before(converter.convertDate(dateAsString));
	}
	
	public boolean filterByLoggerLevel(LoggerBuilder logger,String logLevel){
		return logger.getLogLevel().equals(logLevel);	
		
	}

}
