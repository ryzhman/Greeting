package ConsoleGreeting.Greetting;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.ResourceBundle;

import org.junit.BeforeClass;
import org.junit.Test;

import ConsoleGreeting.Greetting.App;


public class AppTest{
    
	private static LocalTime morningTestTime;
	private static LocalTime dayTestTime;
	private static LocalTime eveningTestTime;
	private static LocalTime nightTestTime;
	private final static String RESOURCEFILE = "messages";
	private static ResourceBundle resource;


	@BeforeClass
    public static void init(){
		morningTestTime = LocalTime.of(7, 00);
		dayTestTime = LocalTime.of(14, 00);
		eveningTestTime = LocalTime.of(20, 00);
		nightTestTime = LocalTime.of(1, 00);
		resource = ResourceBundle.getBundle(RESOURCEFILE);
	}

	@Test
	public void testGreeting()
    {
    	assertEquals(App.greet(morningTestTime), resource.getString("morning"));
    	assertEquals(App.greet(dayTestTime), resource.getString("day"));
    	assertEquals(App.greet(eveningTestTime), resource.getString("evening"));
    	assertEquals(App.greet(nightTestTime), resource.getString("night"));
    	
    }
}
