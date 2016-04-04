package de.recommind.log.business;

public class LoggerBuilder {
	private String fileName;
	private java.sql.Timestamp dateField;
	private String logIdentifierClass;
	private String logLevel;
	private String logMessage;
	private Integer logThreadId;
	
	public String getLogMessage() {
		return logMessage;
	}

	public String getFileName() {
		return fileName;
	}

	public java.sql.Timestamp getDateField() {
		return dateField;
	}


	public String getLogLevel() {
		return logLevel;
	}

	public String getLogIdentifierClass() {
		return logIdentifierClass;
	}

	public LoggerBuilder() {

	}

	public LoggerBuilder setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	public LoggerBuilder setLogLevel(String logLevel) {
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

	public LoggerBuilder setDateField(java.sql.Timestamp dateField) {
		this.dateField = dateField;
		return this;
	}

	public Integer getLogThreadId() {
		return logThreadId;
	}

	public LoggerBuilder setLogThreadId(Integer logThreadId) {
		this.logThreadId = logThreadId;
                return this;
	}

}
