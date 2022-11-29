package services;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Eg {
	static Logger logger = Logger.getLogger(Eg.class.getName());

	public static void main(String[] args) {
		try {
			SimpleLayout layout = new SimpleLayout();
			ConsoleAppender appender = new ConsoleAppender(layout);
			logger.addAppender(appender);
			logger.setLevel(Level.DEBUG);
			logger.info("Logging::log4jsetup is ready");
		}

		catch (Exception e) {
			e.printStackTrace();
			logger.fatal("Logging::problem while setting up log4j");
		}
	}
}
