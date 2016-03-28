package de.recommind.log.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Logger
 *
 */
@Entity

public class Logger implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "LOG_DATE")
	private java.sql.Date dateField;
	
	@Column(name = "LOG_TIME")
	private java.sql.Time timeField;
	
	@Column(name = "LOG_LEVEL")
	private Integer logLevel;
	
	@Column(name = "LOG_MESSAGE")
	private String logMessage;
	
	@Column(name = "LOG_IDENTIFIER_CLASS")
	private String logIdentifierClass;
	

	public java.sql.Date getDateField() {
		return dateField;
	}


	public void setDateField(java.sql.Date dateField) {
		this.dateField = dateField;
	}


	public java.sql.Time getTimeField() {
		return timeField;
	}


	public void setTimeField(java.sql.Time timeField) {
		this.timeField = timeField;
	}


	public Integer getLogLevel() {
		return logLevel;
	}


	public void setLogLevel(Integer logLevel) {
		this.logLevel = logLevel;
	}


	public String getLogMessage() {
		return logMessage;
	}


	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}


	public String getLogIdentifierClass() {
		return logIdentifierClass;
	}


	public void setLogIdentifierClass(String logIdentifierClass) {
		this.logIdentifierClass = logIdentifierClass;
	}


	public Logger() {
		super();
	}
   
}

