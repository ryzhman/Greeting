package ConsoleGreeting.Greetting;

import java.time.LocalTime;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	private static final Logger log = LogManager.getLogger();

    public static void main( String[] args )
    {
    	LocalTime time = LocalTime.now();
    	log.info("Current time is " + time);
    	System.out.println(greet(time));
    }
    
    public static String greet(LocalTime time){
    	if(time==null){
    		log.warn("Invalid argument for greet(). Return null");
    		return "Unsupported type";
    	}

    	final String RESOURCEFILE = "messages";
		String timeOfDay = "";
    	ResourceBundle resource = null;
    	try{
    		resource = ResourceBundle.getBundle(RESOURCEFILE);
    	}catch(MissingResourceException e){
    		e.getMessage();
    	   	log.error("Exception occured " + e.getMessage());
    	}
    	
    	try{
    		if((time.getHour()>6)&&(time.getHour()<9)){
    			timeOfDay=resource.getString("morning");
        		log.info("Invocation of method displayed " + timeOfDay);
    			return timeOfDay;
    		}else if(time.getHour()>9&&(time.getHour()<19)){
    			timeOfDay= resource.getString("day");
        		log.info("Invocation of method displayed " + timeOfDay);
    			return timeOfDay;
    		}else if((time.getHour()>19)&&(time.getHour()<23)){
    			timeOfDay = resource.getString("evening");
        		log.info("Invocation of method displayed " + timeOfDay);
    			return timeOfDay;
    		}else{
    			timeOfDay = resource.getString("night");
        		log.info("Invocation of method displayed " + timeOfDay);
    			return timeOfDay;
    		}
    	}catch(MissingResourceException e){
    	   	log.error("Exception occured " + e.getMessage());
    	   	return null;
    	}
    }
}
