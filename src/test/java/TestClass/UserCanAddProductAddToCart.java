package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.Base;
import PomPage.HomePage;

public class UserCanAddProductAddToCart extends Base {

	HomePage hp;
		public UserCanAddProductAddToCart() {
			super();
		}
		
		@BeforeMethod
		public void setup() {
			getDriver();
		  hp=new HomePage(driver);
		}
		
	
		@Test(priority=1)
		public void ProductAddTest() {
			hp.searcFiled();
			hp.addProductToCart();
			
        
		}
		@AfterMethod
		public void tearDown() {
		driver.quit();
		}
	}
	
	


