package utility;

import org.testng.log4testng.Logger;

public class Loggers {
	public static Logger log=Logger.getLogger(Loggers.class);
	
	public static void startTestCase() {
		log.info("Test Started");
		
	}
	
	public static void endTestCase() {
		log.info("Test Ended");
		
	}
}
