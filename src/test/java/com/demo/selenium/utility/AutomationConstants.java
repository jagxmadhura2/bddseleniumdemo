package com.demo.selenium.utility;


	public interface AutomationConstants {

		public static final String CONFIG_PATH = "./src/test/resources/Config_Files/";
		public static final String CONFIG_FILE = "config.properties";
		public static final String CONFIG_FILE_TPE = "config.properties";
		

		public static final String DRIVER_PATH = "./Drivers/";
		public static final String CHROME_FILE = "chromedriver";

		public static final String GECKO_FILE = "geckodriver.exe";
		public static final String IE_FILE = "IEDriverServer.exe";

		public static final String INPUT_PATH = "./src/test/resources/User_Input/inputs.xlsx";
		
		public static final String CHROME_KEY = "webdriver.chrome.driver";;
		public static final String GECKO_KEY = "webdriver.gecko.driver";

		public static final String IE_KEY = "webdriver.ie.driver";

		public static final String CONFIG_PATH1 = "./src/test/resources/ConfigFiles/config2.properties";
		public static String UNIQUE = "Auto_"
				+ Property_Lib.getPropertyValue(CONFIG_PATH1, "Count");
		public static final long IMPLICIT = Integer.parseInt(Property_Lib
				.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "IMPLICIT"));
		public static final int EXPLICIT = Integer.parseInt(Property_Lib
				.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "EXPLICIT"));
		public static final int MAX_EXPLICIT = Integer.parseInt(Property_Lib
				.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "MAXEXPLICIT"));

		public static final int FLUENTWAIT = Integer.parseInt(Property_Lib
				.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "FLUENTWAIT"));
		
		public static final int POLLINGWAIT = Integer.parseInt(Property_Lib
				.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "POLLINGWAIT"));
		
		public static final String UPLOAD_FILE_LOCATION = "\\src\\test\\resources\\Upload_Files";
		

	

}
