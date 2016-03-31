package de.recommind.log.converter;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateAndTimeConveter implements IDateAndTimeConveter {
//http://www.java-examples.com/java-string-java.sql.date-example

	@Override
	public Date convertDate(String dateAsString) {
            try {
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
              java.util.Date date = sdf.parse(dateAsString);
              return new Date(date.getTime()); 
            } catch (Exception ex){
                return null;
            }
        
	}

}
