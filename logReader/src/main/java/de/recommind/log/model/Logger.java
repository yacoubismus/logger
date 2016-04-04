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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "LOG_DATE")
	private java.sql.Timestamp dateField;

	@Column(name = "LOG_LEVEL")
	private String logLevel;

	@Column(name = "LOG_MESSAGE")
	private String logMessage;

	@Column(name = "LOG_IDENTIFIER_CLASS")
	private String logIdentifierClass;

	// thread_id

	@Column(name = "LOG_THREAD_ID")
	private Integer logThreadId;

	public Logger() {
		super();
	}

	public java.sql.Timestamp getDateField() {
		return dateField;
	}

	public void setDateField(java.sql.Timestamp dateField) {
		this.dateField = dateField;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
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

	public Integer getLogThreadId() {
		return logThreadId;
	}

	public void setLogThreadId(Integer logThreadId) {
		this.logThreadId = logThreadId;
	}

}
