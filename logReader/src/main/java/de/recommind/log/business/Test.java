package de.recommind.log.business;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.recommind.log.filter.LoggerFilter;

public class Test {
	public static void main(String[] args) {	
	//final String REG_EX ="\\s*(\\d{4}-\\d{2}-\\d{2}) \\s*(\\d{2}:\\d{2}:\\d{2},\\d{1,3})\\s*\\[(\\w+)\\] \\s*(.*)\\s*<([0-9]+)>\\s*(.*)";
		final String REG_EX = "\\s*(\\d{4}-\\d{2}-\\d{2} \\s*\\d{2}:\\d{2}:\\d{2}),\\d{1,3}\\s*\\[(\\w+)\\] \\s*(.*)\\s*<([0-9]+)>\\s*(.*)";
	String s ="2012-08-02 14:47:28,831 [I4] Sheduling default-report-creation-thread  <131> TOMCATSERVER.DEFAULT.DefaultReportCreator";
	regexCheck(REG_EX, s);
	LoggerReader reader = new LoggerReader();
	List<LoggerBuilder> loggers = reader.loggerReaderByLine("src\\main\\resources\\dochold.log");
	LoggerBuilder log = loggers.get(0);
	Timestamp date = log.getDateField();
	LoggerFilter filter = new LoggerFilter(loggers);
	List<LoggerBuilder> filteredList = filter.filterLoggerList("date", "2012-08-02 15:14:16", "before");
	
	
	}

	public static void regexCheck(String REG_EX, String s){
		Pattern p = Pattern.compile(REG_EX);
		Matcher matcher = p.matcher(s);
		if(matcher.find()){
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
			System.out.println(matcher.group(4));
			System.out.println(matcher.group(5));
			
		}
	}
}
