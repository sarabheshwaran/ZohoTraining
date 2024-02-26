package training.task8.helper;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import training.exceptions.CustomException;
import training.utilities.HelperUtils;

public class DateHelper {
	
	public final String formatString = "dd MMMM yyyy - HH:mm:ss";
	
	public String formatted(ZonedDateTime time) throws CustomException {
		
		HelperUtils.nullCheck(time);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formatString);
		
		return time.format(format);
		
	}
	
	public ZonedDateTime getDateTime() {
		
		return ZonedDateTime.now();
		
	}
	
	public ZonedDateTime getDateTime(String input) throws CustomException {
		
		HelperUtils.nullCheck(input);
		
		ZoneId zoneId = ZoneId.of(input);
		
		return ZonedDateTime.now(zoneId);
		
	}
	
	public Duration difference(Temporal dateTime_1, Temporal dateTime_2) {
		
		System.out.println(dateTime_1+" "+dateTime_2);
		System.out.println(Duration.between(dateTime_1, dateTime_2));
		return Duration.between(dateTime_1, dateTime_2);
		
	}
	
	public String formatDuration(Duration duration) {
		
		return duration.toHours() + " : " + duration.toMinutes() %60 +" : " + duration.toSeconds() %3600 +" : "+ duration.toMillis()%3600000;
		
	} 
	
	 public ZonedDateTime dateTimeFromMillis (long millis) {
	        Instant instant = Instant.ofEpochMilli(millis);
	        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
	    }
	 
	 public ArrayList<String> getZoneIds() {
		 
//		 return ZoneId.getAvailableZoneIds();
		 return new ArrayList(ZoneId.getAvailableZoneIds());
		 
	 }


}
