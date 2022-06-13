import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.util.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Tests {
	
	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws Exception {
		bitfinexApp();
	}

	
	public static void bitfinexApp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium:deviceName", "Mi A2");
		cap.setCapability("udid", "4b7c2e6");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appium:noreset", "true");
		
		cap.setCapability("appium:app", "C:\\Users\\sneha\\OneDrive\\Desktop\\AndroidSDK\\platform-tools\\prod.apk");
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, cap);
		
		System.out.println("Bitfinex App started");
		
		Thread.sleep(3000);
		
		//select Pro
		MobileElement selectPro = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]"));
		selectPro.click();
		
		Thread.sleep(3000);
		
		//click on sign in
		MobileElement signin = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]"));
		signin.click();
		
		Thread.sleep(3000);
		
		//log in with api key
		MobileElement apiKey = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView"));
		apiKey.click();
		
		Thread.sleep(3000);
		
		//Allow bitfinex to take pictures
		MobileElement popup_allow = (MobileElement) driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
		popup_allow.click();
		
		Thread.sleep(3000);
		
		//click on Add key
		MobileElement click_addKey = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"input\"]"));
		
		Thread.sleep(3000);
		
		click_addKey.click();
		
		Thread.sleep(3000);
		
		//Enter public key
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Login-Public-Key-Input\"]")).sendKeys("64JkMAuWR6YgVQ6gDonUmbeuiGbvSmVSjBuKhMOYzhW");
		
		Thread.sleep(3000);
		
		//Enter Secret key
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Login-Secret-Key-Input\"]")).sendKeys("r2TkMWWC0i18SpA1XzorlvoYLnNdZXKTOzoY1pEythe");
		
		Thread.sleep(3000);
		
		//click on login button
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login-Button\"]")).click();
	
		Thread.sleep(3000);
		
		//Create pin
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"create_pin_input_0\"]")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"create_pin_input_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"create_pin_input_2\"]")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\'create_pin_input_3\']")).sendKeys("1");
		
		Thread.sleep(3000);
		
		//Confirm Pin
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"create_pin_input_0\"]")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"create_pin_input_1\"]")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"create_pin_input_2\"]")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\'create_pin_input_3\']")).sendKeys("1");
		
		Thread.sleep(3000);
		
		//Search for ETH/USD
		MobileElement searchText = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Tickers-Search-Input\"]"));
		searchText.sendKeys("ETH/USD");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='tickers_table_tETHUSD']/android.widget.TextView[1]")).click();
	
		Thread.sleep(5000);
		
		Boolean flag = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='securities_or_santiment_data']/android.view.ViewGroup")).isDisplayed();
		
		System.out.println(flag);
		
		Assert.isTrue(flag, "true");
		
	}
}
