package com.ijmeet;

import java.lang.reflect.Method;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Utility.Keyword;

public class HomepageTest {
	WebDriver driver; 
	public HomepageTest() {
		PageFactory.initElements(driver, this);
		
	}
	
	@Test
	public static void TC01() {
		//To get all the methods of the Keyword class
		Keyword k = new Keyword(); 
		Class c=k.getClass();
		Method[] m=c.getDeclaredMethods();
		int i=m.length;
		System.out.println("Total Number of Methods are "+ i);
		for (Method m1:m) {
			System.out.println(m1);
		
		}
		
		
		
	}

}
