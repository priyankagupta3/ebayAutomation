package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;


public class PropertiesReader {

	private final static Properties configPropeties = new Properties();
	

	private PropertiesReader() {

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("data.properties");
			try {
			configPropeties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class CreateInstance {
		private static final PropertiesReader INSTANCE = new PropertiesReader();
	}

	public static PropertiesReader getInstance() {

		return CreateInstance.INSTANCE;
	}

	public static String getProperty(String key) {

		return configPropeties.getProperty(key);
	}

	public  static Set<String> getAllPropertyNames() {

		return configPropeties.stringPropertyNames();
	}

	public static boolean containsKey(String key) {

		return configPropeties.containsKey(key);
	}
}
