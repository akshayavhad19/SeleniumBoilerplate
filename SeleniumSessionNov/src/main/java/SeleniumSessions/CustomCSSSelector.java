package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSSSelector {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");


		//css- locator approach
		//id - #id
		//class - .class

		//#input-firstname - id
		By.cssSelector("#input-firstname");

		//.form-control -class

		// #id.class --> #input-firstname.form-control
		// tagName#idValue
		// .class#id --> .form-control#input-firstname
		// tagname.classValue

		//if we have multiple classes then
			//.c1.c2.c3....cn
			//.form-control.input-lg

		//#idValue.c1.c2.c3
		//c1.c2.c3.#idvALUE

		// other attributes : name, type, any other
		//  tagName[attr='value'] --> css
		//  //tagName[@attr='value'] -->xpath

		//   input[name='email']
		By.cssSelector("input[name='email']");

		//multiple attribute
			// tagN[attr1='value'][attr2='value'] 
	
			//   tagN[attr1='value']#input-firstname
			//   input#input-firstname[attr1='value']

		driver.findElement(By.className("form-control input-lg")).sendKeys("sele");
		//InvalidSelectorException: compound class names not permitted

		//In xpath compound classes are permitted

			//driver.findElement(By.xpath("//input[@@@id,'username']")).sendKeys("Hello");
			//InvalidSelectorException

		//text() in css -- NOT available

		//contains() in css
			//  tagName[attr*='value']
			//  input[placeholder*='E-mail']  full value=E-mail address

		//starts-with()
			// tagName[attr^='value']
			//  input[placeholder^='E-mail']  full value=E-mail address

		// ends-with()
			//  input[placeholder$='Address']  full value=E-mail Address

		// Parent to child
			//select[@id='Form_getForm_Country']/option  -->xpath
			//  select[id='Form_getForm_Country']>option  -->css	direct child element: Parent > child
	
			//  div#content > input  --> 0 direct
			//  div#content  input  --> 11 direct + indirect

		//child to parent: Not Allowed
			//child to ancestor: Not Allowed
			//child to preceding-sibling: Not Allowed

		// sibling in css:
			//  lable[attr='value']+input  --> Immediate siblings
			//  lable[attr='value']~input  --> all following -siblings

		//comma in css: use case to check all mandatory things are available or not
			//  input#input-email,input#password,button#login
			//int reqElem=driver.findElements(By.cssSelector("input#input-email,input#password,button#login")).size();
			//if(reqElem==4) {
			//	System.out.println("pass");
			//}
		
		//not in css: exclude
			//  div[class='form-group']>input:not(#input-password)
			//  div[class='form-group']>input:not(input[type='password'])
			//  div[class='form-group']>input:not(input[type='password'], #input-email)
		
		//indexing in css :
			//  select[id='Form_getForm_Country']>option:nth-of-type(5) ---> out of 233 it will select 5th option
			//	select[id='Form_getForm_Country']>option:nth-child(5)	---> out of 233 it will select 5th option
			//  select[id='Form_getForm_Country']>option:nth-of-type(n) ---> for all
			//  select[id='Form_getForm_Country']>option:first-child
			//  select[id='Form_getForm_Country'] option:first-child
			//  select[id='Form_getForm_Country']>option:last-child
			//  select[id='Form_getForm_Country'] option:last-child
			//  select[id='Form_getForm_Country']>option:nth-last-child(2) --> second last
			//  select[id='Form_getForm_Country']>option:nth-child(odd)  --> all odd
			//  select[id='Form_getForm_Country']>option:nth-child(even)  --> all even
			//  select[id='Form_getForm_Country']>option:nth-child(n+4)  --> all onwards 4
			//  select[id='Form_getForm_Country']>option:nth-child(4n)  --> all in the mutiple of 4
		
		//even odd in xpath:
			//(//select[@id='Form_getForm_Country']/option)[position() mod 2=0] --> even
			//(//select[@id='Form_getForm_Country']/option)[position() mod 2=1] --> odd



		
		
	}
}
