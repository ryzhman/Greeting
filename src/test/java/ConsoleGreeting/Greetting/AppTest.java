package ConsoleGreeting.Greetting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalTime;
import java.util.ResourceBundle;

import org.junit.BeforeClass;
import org.junit.Test;


public class AppTest{
	private static LocalTime morningTestTime;
	private static LocalTime dayTestTime;
	private static LocalTime eveningTestTime;
	private static LocalTime nightTestTime;
	private static LocalTime incorrectTime1;
	private final static String RESOURCEFILE = "messages";
	private static ResourceBundle resource;

	@BeforeClass
    public static void init(){
		morningTestTime = LocalTime.of(9, 00);
		dayTestTime = LocalTime.of(19, 00);
		eveningTestTime = LocalTime.of(23, 00);
		nightTestTime = LocalTime.of(1, 00);
		resource = ResourceBundle.getBundle(RESOURCEFILE);
	}
	
	@Test
	public void testCheckTime()
    {
    	assertEquals(App.checkTime(morningTestTime), resource.getString("morning"));
    	assertEquals(App.checkTime(dayTestTime), resource.getString("day"));
    	assertEquals(App.checkTime(eveningTestTime), resource.getString("evening"));
    	assertEquals(App.checkTime(nightTestTime), resource.getString("night"));
    }
	
	@Test
	public void testIsTimeValid(){
		assertEquals(App.isTimeValid(incorrectTime1), resource.getString("null"));
	}
	
	@Test
	public void testGetResource(){
		assertNotNull(App.getResource());
	}
}
