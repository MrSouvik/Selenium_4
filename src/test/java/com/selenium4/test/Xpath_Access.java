package com.selenium4.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Access {
	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/group");
//----------------------------------------------------------------------------------------------------		
		/*
		 * <tagname>[fast()/last()]
		 * Locating Parent element(parent)
		 * -------------------------------
		 * Syntax - 
		 * 1) <knownXpath>/parent::*
		 * 2) <KnownXpath>/parent::elementName
		 * 3) <knownXpath>/..
		 */
		
		//1)
		//driver.findElement(By.xpath("//input[@type='submit']/parent::*")).click();
		
		//2)
		//driver.findElement(By.xpath("//input[@type='submit']/parent::div")).click();
		
		//3)
		//driver.findElement(By.xpath("//input[@type='submit']/..")).click();
//-------------------------------------------------------------------------------------------------------		
		/*
		 * Locating Child element(child)
		 * -----------------------------
		 * Syntax-
		 * 1) <xpathOfContextElement>/child::elementName>
		 * 2) <xpathOfContextElement>child::*
		 * 3) <xpathOfContextElement>/<elementName>
		 */
		
		/*
		//1)
		String text1 = driver.findElement(By.xpath("//div[@class='f14 floatL']/child::span[1]")).getText();
		System.out.println(text1);
		
		//2)
		String text2 =driver.findElement(By.xpath("//div[@class='f14 floatL']/child::*[1]")).getText();
		System.out.println(text2);
		
		//3)
		String text3 = driver.findElement(By.xpath("//div[@class='f14 floatL']/span[1]")).getText();
		System.out.println(text3);
		*/
//---------------------------------------------------------------------------------------------------		
		//
	    //	Locating grand children
		//	-----------------------
		//	Syntax-
		//	1) <xpathOfContextElement>/*/<elementName>
		//	2) <xpathOfContextElement>/child/<elementName>
		
		
		
		//1)
		//driver.findElement(By.xpath("//div[@style='width:50%;font-size:14px;float:left;']/*/a[text()='Weekly']")).click();
		
		//2)
		
		//driver.findElement(By.xpath("//div[@style='width:50%;font-size:14px;float:left;']/div/a[text()='Monthly']")).click();
		
//--------------------------------------------------------------------------------------------------------------		
		/*
		 * 	Locating grand parent(ancestor)
		 *  ---------------------
		 *  Syntax-
		 *  1) <xpathOfContextElement>/ancestor::<elementName>
		 *  2) <xpathOfContextElement>/ancestor::*
		 * 
		 */
		//1)
		//boolean ispresent1 = driver.findElement(By.xpath("//input[@type='submit']/ancestor::div[1]")).isDisplayed();
		//System.out.println(ispresent1);
		//2)
		//boolean ispresent = driver.findElement(By.xpath("//input[@type='submit']/ancestor::*[1]")).isDisplayed();
		//System.out.println(ispresent);
		
//----------------------------------------------------------------------------------------------------------
		/*
		 *  Locating grand children(desendant)
		 *  ------------------------------------
		 *  Syntax-
		 *  1) <xpathOfContextElement>/descendant::<elementName>
		 *  2) <xpathOfContextElement>/descendant::*
		 */
		//1)
		//driver.findElement(By.xpath("//div[@class='floatL bold']/descendant::a")).click();
		
		//2)
		//driver.findElement(By.xpath("//div[@style='width:50%;font-size:14px;float:left;']/descendant::*[text()='Monthly']")).click();
//----------------------------------------------------------------------------------------------------------------
		
		/*
		 *  Locating following element
		 *  --------------------------
		 *  Syntax-
		 *  1) <xpathOfContextElement>/following::<elementName>
		 *  2) <xpathOfContextElement>/following::*
		 */
		/*
		//1)
		int totalEle1 = driver.findElements(By.xpath("//a[contains(text(),'Hind. Motor')]/following::tr")).size();
		System.out.println("No of following ele tr - "+totalEle1);
		
		//2)
		
		int totalEle = driver.findElements(By.xpath("//a[contains(text(),'Hind. Motor')]/following::*")).size();
		System.out.println("No of following ele - "+totalEle);
		*/
//-----------------------------------------------------------------------------------------------------------
		/*
		 *  Locating preceding element
		 *  --------------------------
		 *  Syntax-
		 *  1) <xpathOfContextElement>/preceding::<elementName>
		 *  2) <xpathOfContextElement>/preceding::*
		 */
		/*
		//1)
		int totalEle1 = driver.findElements(By.xpath("//a[contains(text(),'Hind. Motor')]/preceding::tr")).size();
		System.out.println("No of preceding ele tr - "+totalEle1);
				
		//2)
				
		int totalEle = driver.findElements(By.xpath("//a[contains(text(),'Hind. Motor')]/preceding::*")).size();
		System.out.println("No of preceding ele - "+totalEle);
		*/
//---------------------------------------------------------------------------------------------------------
		/*
		 *  Locating following-sibling element
		 *  ----------------------------------
		 *  Syntax-
		 *   1) <xpathOfContextElement>/following-sibling::<elementName>
		 *   2) <xpathOfContextElement>/following-sibling::*
		 */
		/* 
		//1)
		int noOffollowingSibling = driver.findElements(By.xpath("//a[contains(text(),'Hind. Motor')]/ancestor::tr/following-sibling::tr")).size();
		System.out.println("No of Following sibling ele - "+noOffollowingSibling);
		
		//2)
		int noOffollowingSibling1 = driver.findElements(By.xpath("//a[contains(text(),'Hind. Motor')]/ancestor::tr/following-sibling::*")).size();
		System.out.println("No of Following sibling ele - "+noOffollowingSibling1);
		*/
//---------------------------------------------------------------------------------------------------------------------
		/*
		 *  Locating preceding-sibling element
		 *  ----------------------------------
		 *  Syntax-
		 *   1) <xpathOfContextElement>/preceding-sibling::<elementName>
		 *   2) <xpathOfContextElement>/preceding-sibling::*
		 */
		/*
		//1)
		int noOfprecedingSibling = driver.findElements(By.xpath("//a[contains(text(),'Hind. Motor')]/ancestor::tr/preceding-sibling::tr")).size();
		System.out.println("No of preceding sibling ele - "+noOfprecedingSibling);
		
		//2)
		int noOfprecedingSibling1 = driver.findElements(By.xpath("//a[contains(text(),'Hind. Motor')]/ancestor::tr/preceding-sibling::*")).size();
		System.out.println("No of preceding sibling ele - "+noOfprecedingSibling1);
	*/
//--------------------------------------------------------------------------------------------------------------------------------------------------
		 driver.quit();
	}
	
}
