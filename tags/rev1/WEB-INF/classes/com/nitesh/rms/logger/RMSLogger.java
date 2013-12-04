package com.nitesh.rms.logger;

import java.io.File;
import java.util.Hashtable;

import org.apache.log4j.Logger;


public class RMSLogger extends Logger {
	
	private static Hashtable loggerTable = new Hashtable(4);
	private static String sLogFileName = null;
	
	private RMSLogger(String name) {
		super(name);
		 java.net.URL fileURL = Thread.currentThread().getContextClassLoader().getResource("log4j.properties");
         String sFileName = fileURL.getFile();
         sLogFileName = sFileName;
	
	}

	public final static RMSLogger getRMSLogger(String sCategory)
	   {
	       try
	       {
	           // Check if Instance is already present for the Category
	           if( loggerTable.contains(sCategory) )
	               return (RMSLogger) loggerTable.get(sCategory) ;
	           else
	           {                              
	        	        
	        	   // Create a new custom logger for this category
	               RMSLogger customLogger = new RMSLogger(sCategory);
	                
	                // Configure the Custom Logger
	                configureLogger (sCategory, customLogger);
	                
	                // Add the custom logger to Table.
	                loggerTable.put(sCategory, customLogger) ;

	                return (RMSLogger) customLogger;
	           }
	       }
	       catch(Exception exp)
	       {
	           System.out.println("Exception thrown while fetching Logger instance");
	           exp.printStackTrace ();
	       }
	       
	       return null;
	           
	   }
	   
	 	private static void configureLogger(String sCategory, RMSLogger customLogger) throws Exception
	   {
	       // Get the Logger instance for this Category. Needed to fetch the Appender and other settings.
	        org.apache.log4j.Logger logger =  org.apache.log4j.Logger.getLogger (sCategory);              
	                
	        // Set the repository of custom logger to the original logger
	        customLogger.repository = logger.getLoggerRepository ();
	        
	        // Get the Appender from the Orignal logger and set it to custom logger
	        org.apache.log4j.Appender appender = logger.getAppender (sCategory);
	        customLogger.removeAllAppenders ();
	        customLogger.addAppender (appender);
	        
	        // Set the Additivity and level from original logger
	        customLogger.setAdditivity (logger.getAdditivity ());        
	        customLogger.setLevel (logger.getLevel ());    
	      
	   }
}
