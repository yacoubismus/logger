package de.recommind.log.business;

public class LoggerBuilder {
	private String fileName;
	private java.sql.Date dateField;
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

	public java.sql.Date getDateField() {
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

	public LoggerBuilder setDateField(java.sql.Date dateField) {
		this.dateField = dateField;
		return this;
	}

	public Integer getLogThreadId() {
		return logThreadId;
	}

	public void setLogThreadId(Integer logThreadId) {
		this.logThreadId = logThreadId;
	}

}
