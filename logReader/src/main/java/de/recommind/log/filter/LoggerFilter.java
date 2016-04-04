package de.recommind.log.filter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import de.recommind.log.business.LoggerBuilder;
import de.recommind.log.converter.DateAndTimeConveter;
import de.recommind.log.converter.IDateAndTimeConveter;

public class LoggerFilter {
	List<LoggerBuilder> loggers;
	
	public LoggerFilter(List<LoggerBuilder> loggers) {
		this.loggers = loggers;
	}
	
	public List<LoggerBuilder> filterLoggerList(String category , String value, String afterOrBefore){
		return this.loggers.stream()
				.filter(createFilterConcept(category,value,afterOrBefore)).collect(Collectors.toList());
				
	}
	
	public Predicate<? super LoggerBuilder> createFilterConcept(String category, String value, String afterOrBefore) {

		Predicate<? super LoggerBuilder> predicate = p -> {
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
		if(logger.getDateField()!= null) {
			IDateAndTimeConveter converter = new DateAndTimeConveter();
			return logger.getDateField().before(converter.convertDate(dateAsString));
		}
		return false;
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
