package PomPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.utilClass;

public class ProductPricePage extends utilClass{
	
	
	public static WebDriver driver;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement SearcBox;
 
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement SearcBtn;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	private List<WebElement> productPriceElementList;
	
	
	public ProductPricePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void searcFiled() {
		waitTillElementPresent(driver,SearcBox);
		SearcBox.sendKeys("apple 12");
		
		SearcBtn.click();
	}
//	public void getLowPrice() {
//		
//		for(int i=0;i<productPriceElementList.size();i++) {
//			Map<WebElement,Integer> map=new HashMap<WebElement,Integer>();
//			if(productPriceElementList.get(i).getText() !="") {
//				map.put(productPriceElementList.get(i),(Integer.parseInt( productPriceElementList.get(i).getText().replace(",",""))));
//			}
//		}
//	
//				List<Entry<WebElement,Integer>> le =new ArrayList<Map.Entry<WebElement,Integer>>(Map.entrySet());
//		
//		}
	public int getLowsetPrice() {
		List<Integer> productPriceList = new ArrayList<>();
		for(WebElement k : productPriceElementList) {
			productPriceList.add(Integer.parseInt(k.getText().replace("₹", "").replace(",", "")));	
		}
		Collections.sort(productPriceList);
		return productPriceList.get(0);
	}
	}



