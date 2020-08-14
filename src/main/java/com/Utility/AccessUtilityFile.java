package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*This class is used for accessing data from a common object repository which will be used to store objects which are common to all 
 * 
 */
public class AccessUtilityFile {
	public static Properties p;
	public static FileInputStream fis;
	public static String value;
	
/*This method will fetch the value for the key passed from the Object Repository which is made of .property extension
 * @Param:It accepts argument as String file-path where the file is stored
 * @param:It accepts argument as key for which we want to get the value which we have stored in the Object repository 
 */
	public static String getProperty(String key) {

		try {
			fis = new FileInputStream(
					"C:\\Eclipse-WorkSpace\\eclipse-workspace\\com.ijmeet\\src\\main\\resources\\ObjectRepository.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		value = p.getProperty(key);
		return value;

	}
	/*This is an additional method for accessing any .property file 
	 * @Param:It accepts argument as String file-path where the file is stored
	 * @param:It accepts argument as key for which we want to get the value which we have stored in the Object repository 
	 */
	public static String getProperty(String key, String filepath) {

		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		value = p.getProperty(key);
		return value;

	}

}