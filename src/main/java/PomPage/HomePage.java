package PomPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.Base;
import Utility.utilClass;



public class HomePage extends utilClass{
 public static	WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement SearcBox;
 
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement SearcBtn;

	@FindBy(xpath="(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]")
	WebElement ListOfProdct;
	
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement AddCart;
	
	
	@FindBy(xpath="//button[text()='✕']")
	WebElement cancle;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void searcFiled() {
		waitTillElementPresent(driver,SearcBox);
		SearcBox.sendKeys("apple mobile");
		
		SearcBtn.click();
	}
	public void addProductToCart() {
		waitTillElementPresent(driver,ListOfProdct);
		 for(int i=1;i<=3;i++) {
		
			  driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])["+ i +"]")).click();
			 
	      }
	      
	     Set<String> address= driver.getWindowHandles();
	     
	     List<String> addressList=new ArrayList<>(address);
	     
	     for(int i=0;i<4;i++) {
	    	 driver.switchTo().window(addressList.get(i));
	    	 
	    	
	    	 if(i !=0) {
	    	 driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	    	 //System.out.println(driver.getTitle());
	    	 }
	}
		
	}
}
