package de.recommind.log.business;

import de.recommind.log.model.Logger;

public class LoggerCreator implements ILogCreator {

	Integer date = 1;
	Integer time = 2;
	Integer logLevel = 3;
	Integer logMessage = 4;
	Integer threadNumber = 5;
	Integer logClass = 6;
	public LoggerCreator() {
		
	}

	@Override
	public Logger createLogger(LoggerBuilder builder) {
		Logger logger = new Logger();
		logger.setDateField(builder.getDateField());
		logger.setLogIdentifierClass(builder.getLogIdentifierClass());
		logger.setLogLevel(builder.getLogLevel());
		logger.setLogMessage(builder.getLogMessage());
		return logger;
	}

}
