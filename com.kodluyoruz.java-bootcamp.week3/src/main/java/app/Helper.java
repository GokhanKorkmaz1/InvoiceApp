package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {
	
	public static class DateHelper{
		
		public static String DateFormatter(LocalDateTime localDateTime) {
			DateTimeFormatter customFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	return localDateTime.format(customFormater);
		}
	}

}
