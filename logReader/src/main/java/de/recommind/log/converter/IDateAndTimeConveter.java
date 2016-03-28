package de.recommind.log.converter;

public interface IDateAndTimeConveter  {
	public java.sql.Time convertTime(String timeAsString);
	public java.sql.Date convertDate(String dateAsString);
	 

}
