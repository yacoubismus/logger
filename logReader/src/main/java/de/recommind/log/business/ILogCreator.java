package de.recommind.log.business;

import de.recommind.log.model.Logger;

public interface ILogCreator {
	public Logger createLogger(LoggerBuilder builder);


}
