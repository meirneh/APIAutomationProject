package webuiNetace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Firsttests {
	@Test
	public void firstTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// sleep for 3 seconds
				sleep(3000);

				// maximize browser window
				driver.manage().window().maximize();

//				open test page
				String url = "http://172.18.11.10:7070/login";
				driver.get(url);
				System.out.println("Page is opened.");
				
				// sleep for 2 seconds
				sleep(3000);
				
				//click on the keylock button
				driver.findElement(By.cssSelector(".KeycloakButton__keycloak__NhoKX")).click();
				//fill username field
				driver.findElement(By.cssSelector("#username")).sendKeys("admin");
				//fill password
				driver.findElement(By.cssSelector("#password")).sendKeys("Netace2021!");
				//click login
				driver.findElement(By.cssSelector("#kc-login")).click();
				//sleep for 3 seconds
				sleep(3000);
				//inventory
				//driver.findElement(By.cssSelector(".HeaderBar__gHeaderMid__nByzY :nth-child(3) > div > a > div")).click();
				driver.findElement(By.cssSelector("[data-testid='inventoryRedirectTab']")).click();
				sleep(5000);
				//Network Elements
				driver.findElement(By.cssSelector("[data-testid='networksRedirectTab']")).click();
				//add device by click on + button
				sleep(6000);
				driver.findElement(By.cssSelector("[data-testid='networkAddRedirectTab']")).click();
				//Click on the Network Element Type
				driver.findElement(By.cssSelector("[data-testid='networkElementTypeRedirectTab']")).click();
				//Choose the NetConf Device by click on him
				sleep(4000);
				List<WebElement > list = driver.findElements(By.cssSelector(".Input__dropdownList___OJKN .Input__item___Ofdu"));
				sleep(4000);
				for (WebElement el : list) {
					System.out.println(el.getText());
					
					if (el.getText().equalsIgnoreCase("Snmp Device")) {
						el.click();
						break;
					}
					
				}
				
				//fill Username
				//sleep(5000);
				//driver.findElement(By.cssSelector("[data-testid='netconfUsernameRedirectTab']")).sendKeys("admin");
				//fill Password
				//sleep(2000);
				//driver.findElement(By.cssSelector("[data-testid='netconfPasswordRedirectTab']")).sendKeys("admin");
				//fill ip address
				//driver.findElement(By.cssSelector("[data-testid='netconfIpRedirectTab']")).click();
				sleep(1000);
				driver.findElement(By.cssSelector(".LeftBlock__mainContent__NvnFn > div:nth-child(2) input")).sendKeys("172.16.180.98");
				//driver.findElement(By.cssSelector("[data-testid='netconfIpFieldRedirectTab']")).sendKeys("172.20.20.101");
				//sleep(2000);
				//Click Add
				driver.findElement(By.cssSelector("[data-testid='addBtnRedirectTab']")).click();
		//driver.quit();		
		
	}
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
