/**
 * 
 */
package org.equalexperts.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Georgy
 *
 */
public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver startBrowser(String url, String chromedriverPath) {
		System.setProperty("webdriver.chrome.driver", chromedriverPath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(url);

		return driver;

	}

}
