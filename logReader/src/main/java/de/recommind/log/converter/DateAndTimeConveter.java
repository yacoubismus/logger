package de.recommind.log.converter;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateAndTimeConveter implements IDateAndTimeConveter {
//http://www.java-examples.com/java-string-java.sql.date-example

	@Override
	public Timestamp convertDate(String dateAsString) {
            try {
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
              java.util.Date date = sdf.parse(dateAsString);
              return new java.sql.Timestamp(date.getTime());
            } catch (Exception ex){
                return null;
            }
        
	}

}
