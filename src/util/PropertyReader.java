package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String getProperty(String propertyName) {
		Properties property = new Properties();

		try {
			property.load(new FileInputStream(new File("proporties/selenium.properties").getCanonicalPath()));
		} catch (FileNotFoundException e) {
			System.err.println("The file selenium.properties was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO problem when trying to read the selenium.properties file!");
			e.printStackTrace();
		}
		return property.getProperty(propertyName);
	}
}
