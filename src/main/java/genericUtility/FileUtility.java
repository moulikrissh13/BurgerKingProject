package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String readDataFromPropertyFiles(String key) throws IOException {
		
		FileInputStream file = new FileInputStream("./commonData.properties");
		
		Properties prop = new Properties();
		
		prop.load(file);
		
		String data = prop.getProperty(key);
		
		return data;
	}
}
