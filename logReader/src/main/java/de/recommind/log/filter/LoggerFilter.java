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
	
	public Predicate<? extends LoggerBuilder> createFilterConcept(String category, String value, String afterOrBefore) {

		Predicate<? extends LoggerBuilder> predicate = p -> {
			switch (category) {
			case "date":
				if(afterOrBefore.equals("after"))
				return filterByDateAfter(p,value);
				else
					return filterByDateBefore(p, value);
				
            case "logLevel":
            	filterByLoggerLevel(p,value);
				break;
            case "someText":
            	filterByText(p, value);
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
	
	public boolean filterByText(LoggerBuilder logger, String someText){
		return logger.getDateField().toString().contains(someText)||
				logger.getLogIdentifierClass().contains(someText)||
				logger.getLogLevel().contains(someText)||
				logger.getLogMessage().contains(someText)||
				logger.getLogThreadId().toString().contains(someText);
	}

}
