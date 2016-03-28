package de.recommind.log.business;

public class LoggerBuilder {
	String fileName;
	java.sql.Date dateField;
	java.sql.Time timeField;
	Integer logLevel;
	String logMessage;
	public String getLogMessage() {
		return logMessage;
	}

	public String getFileName() {
		return fileName;
	}

	public java.sql.Date getDateField() {
		return dateField;
	}

	public java.sql.Time getTimeField() {
		return timeField;
	}

	public Integer getLogLevel() {
		return logLevel;
	}

	public String getLogIdentifierClass() {
		return logIdentifierClass;
	}

	
	String logIdentifierClass;

	public LoggerBuilder() {

	}

	public LoggerBuilder setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	public LoggerBuilder setTimeField(java.sql.Time timeField) {
		this.timeField = timeField;
		return this;
	}

	public LoggerBuilder setLogLevel(Integer logLevel) {
		this.logLevel = logLevel;
		return this;
	}

	public LoggerBuilder setLogMessage(String logMessage) {
		this.logMessage = logMessage;
		return this;
	}

	public LoggerBuilder setLogIdentifierClass(String logIdentifierClass) {
		this.logIdentifierClass = logIdentifierClass;
		return this;
	}

	public LoggerBuilder setDateField(java.sql.Date dateField) {
		this.dateField = dateField;
		return this;
	}

}
