package listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;
//@WebListener("application context listener")
public class Loggers implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String log4jConfigFile = context.getInitParameter("log4j.properties");
		 String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
		 PropertyConfigurator.configure(fullPath);
		 System.out.println("log4j initiated in loggerclass");
	}
	}


