package ConsoleGreeting.Greetting;

import java.time.LocalTime;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App{
	private static final Logger log = LogManager.getLogger();
	private static final String RESOURCEFILE = "messages";
	private static ResourceBundle resource;
	private static final LocalTime sixAm = LocalTime.of(6,0);
	private static final LocalTime nineAm = LocalTime.of(9,0);
	private static final LocalTime sevenPm = LocalTime.of(19,0);
	private static final LocalTime elevenPm = LocalTime.of(23,0);

    public static void main( String[] args )
    {
    	LocalTime time = LocalTime.now();
    	log.info("Current time is " + time);
    	System.out.println(greet(time));
    }
    
    
    public static String greet(LocalTime time){
    	isTimeValid(time);
    	return checkTime(time);
    }
    
    public static String checkTime(LocalTime time){
    	String timeOfDay = "";
    	
    	try{
    		if(time.isAfter(sixAm)&&time.isBefore(nineAm)||(time.equals(LocalTime.of(6,0)))||(time.equals(LocalTime.of(9,0)))){
    			timeOfDay=getMessage("morning");
    			logMethodActivity(timeOfDay);
    			return timeOfDay;
    		}else if(time.isAfter(nineAm)&&time.isBefore(sevenPm)||time.equals(LocalTime.of(19,0))){
    			timeOfDay= getMessage("day");
    			logMethodActivity(timeOfDay);
    			return timeOfDay;
    		}else if(time.isAfter(sevenPm)&&time.isBefore(elevenPm)||time.equals(LocalTime.of(23,0))){
    			timeOfDay = getMessage("evening");
    			logMethodActivity(timeOfDay);
    			return timeOfDay;
    		}else{
    			timeOfDay = getMessage("night");
    			logMethodActivity(timeOfDay);
    			return timeOfDay;
    		}
    	}catch(NullPointerException e){
    		log.error("Exception occured " + e.getMessage());
    	   	return null;
    	}
    }
    
    public static ResourceBundle getResource(){
		try{
    		resource = ResourceBundle.getBundle(RESOURCEFILE);
    		return resource;
    	}catch(MissingResourceException e){
    		e.getMessage();
    	   	log.error("Exception occured " + e.getMessage());
    	   	return null;
    	}
	}
    
    public static String isTimeValid(LocalTime time){
    	if(time==null){
    		log.warn("Invalid argument for greet(). Return null");
    		String notValid = getResource().getString("null");
    		return notValid;
    	}
		return null;
    }
    
    public static String getMessage(String message){
    	return getResource().getString(message);
    }
    
    public static void logMethodActivity(String parameter){
		log.info("Invocation of method displayed " + parameter);
    }
}
