package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.Base;
import PomPage.HomePage;
import PomPage.ProductPricePage;

public class UserCanGetLowerPriceProduct extends Base {
	ProductPricePage pp;
	@BeforeMethod
	public void setup() {
		getDriver();
	  pp=new ProductPricePage(driver);
	}
	

	@Test(priority=1)
	public void ProductAddTest() {
		pp.searcFiled();
//		pp.getLowPrice();
		pp.getLowsetPrice();
		Assert.assertNotEquals(pp.getLowsetPrice(), "");
    
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}

}
