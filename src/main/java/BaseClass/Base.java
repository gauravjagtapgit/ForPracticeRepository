package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static Properties prop;
	public static WebDriver driver;

	public Base() {

		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\gauav\\"
					+ "AmezonNewOne\\src\\main\\resources\\config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		String brower = prop.getProperty("browser");
		if (driver == null) {

			if (brower.equals("chrome")) {

				WebDriverManager.chromedriver().setup();

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--disable notifications");
				DesiredCapabilities cp = new DesiredCapabilities();
				cp.setCapability(ChromeOptions.CAPABILITY, options);
				options.merge(cp);
				driver = new ChromeDriver(options);
			} else if (brower.equals("firefox")) {

				WebDriverManager.firefoxdriver().setup();

				driver = new FirefoxDriver();
			}

			driver.get(prop.getProperty("url"));

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

		return driver;
	}

	public static void unloadDriver() {
		
		driver = null;
	}
	public void github() {
		System.out.println("add extra in branch2");
	}

}
