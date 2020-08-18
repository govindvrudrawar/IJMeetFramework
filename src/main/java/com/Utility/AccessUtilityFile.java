package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
	
	/*
	 * This method is used to access the data from .xlsx file.
	 * 
	 * @Param: It accepts the argument as a String file-path where excel file is
	 * stored.
	 * 
	 * @param:It accepts argument as key for which want to get the value/data to
	 * be fetch which we have stored in the excel file.
	 * 
	 * ***Note: Recommended to use testNG annotation @DataProvider to fetch the data
	 * from excel file.
	 * 
	 * @DataProvider(name="ReadDataFromExcel")
	 */

	public Object[][] readExcelFile() throws IOException {
		Object[][] obj = null;
		try {
			// Here, provide appropriate excel file path from where fetch the data
			FileInputStream fis = new FileInputStream("src\\main\\resources\\ReadExcelData.xlsx");
			XSSFWorkbook getBook = new XSSFWorkbook(fis);

			// Here, provide the sheet-Name where actual data is to be read
			XSSFSheet sheet = getBook.getSheet("Sheet1");
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			obj = new Object[rows][cols - 1];
			for (int i = 1; i <= rows; i++) {
				Row row = sheet.getRow(i);
				int Columns = row.getLastCellNum();
				for (int j = 1; j < Columns; j++) {
					Cell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BLANK:
						obj[i - 1][j - 1] = "";
						break;
					case Cell.CELL_TYPE_STRING:
						obj[i - 1][j - 1] = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						obj[i - 1][j - 1] = cell.getBooleanCellValue();
						break;
					case Cell.CELL_TYPE_ERROR:
						obj[i - 1][j - 1] = "e+error";
						break;
					case Cell.CELL_TYPE_NUMERIC:
						obj[i - 1][j - 1] = cell.getStringCellValue();
						break;
					default:
						System.out.println("error");
						break;
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	/*
	 * This method is used to read JSON file.
	 * 
	 * expected JSON object/data stored in @param object {@code JSONObject}
	 * convert that object to {@code JSONArray} with @param jArray
	 * and get that array element.
	 */

	//public static JSONArray topics;
	public static String readJSONfile(String topicname) {
		
		JSONParser parser = new JSONParser();
		try {
			Object unitObj = parser.parse(new FileReader("src\\main\\resources\\ReadJSONData.json"));
			JSONObject jObject = (JSONObject) unitObj;
			JSONArray jArray = (JSONArray) jObject.get(topicname);
			System.out.println(jArray);
			for (int i = 0; i < jArray.size(); i++) {
				System.out.println(jArray.get(i));
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicname;
	}


	/*
	 * This is a method regarding reading CSV file.
	 * @param It accepts parameter as String path
	 * @author chirde Sampada
	 * @throws FileNotFoundException 
	 */
	public void csvFileReader(String path) throws FileNotFoundException {
		Scanner sc=new Scanner(new File(path));
		sc.useDelimiter(","); //sets delimiter pattern
		while(sc.hasNext())
		{
			System.out.println(sc.next());
		}
		sc.close();
	}
	
	
	
	
	
}












