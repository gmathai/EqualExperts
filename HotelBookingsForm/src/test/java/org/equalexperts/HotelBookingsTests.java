package org.equalexperts;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.equalexperts.pages.HotelBookingsPage;
import org.equalexperts.utils.BrowserFactory;
import org.equalexperts.utils.GetConfigPropertiesData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author Georgy
 *
 */
public class HotelBookingsTests {
    WebDriver driver;

    GetConfigPropertiesData configPropertiesData = new GetConfigPropertiesData();
    GetConfigPropertiesData configPropertiesDataNew = new GetConfigPropertiesData();

    public HotelBookingsTests() {

    }

    @Before
    public void openTheBrowser() {
        String os, url="";

        // Getting the data from Config Property file
        configPropertiesDataNew = configPropertiesData.getConfigData();
        url = configPropertiesDataNew.getUrl();
        // Starting chrome browser using browser factory concept
        os=configPropertiesDataNew.getOs();
        if(os.equalsIgnoreCase("Mac")){
            driver = BrowserFactory.startBrowser(url, "chromedriver_Mac");
        }
        else if (os.equalsIgnoreCase("Windows")){
            driver = BrowserFactory.startBrowser(url, "chromedriver_Win.exe");
        }
    }

    @Test
    public void createBooking() throws Exception {
        String fName="", sName="", price="",deposit="",checkinDate="",checkoutDate="";
        fName = configPropertiesDataNew.getfName();
        sName = configPropertiesDataNew.getsName();
        price = configPropertiesDataNew.getPrice();
        deposit = configPropertiesDataNew.getDeposit();
        checkinDate = configPropertiesDataNew.getCheckinDate();
        checkoutDate = configPropertiesDataNew.getCheckoutDate();

        // Instantiate HotelBookings Page class
        HotelBookingsPage hotelBookingsPage = PageFactory.initElements(driver, HotelBookingsPage.class);
        // Asserts in HotelBookings Page
        assertTrue(hotelBookingsPage.getPageTitle().contains("Hotel booking form"));
        // Performing actions on elements in HotelBookings Page
        hotelBookingsPage.fillBookingDetails(fName, sName, price, deposit, checkinDate, checkoutDate);

        // Save Bookings
        hotelBookingsPage.saveBookings();

        // Sleep to handle dynamic display of a bookings data to page
        Thread.sleep(5000);

        // Asserting the presence of Saved bookings data in the page
        assertTrue(driver.getPageSource().contains(fName));
    }

    @Test
    public void deletingBooking() throws Exception {
        String sName="";
        sName = configPropertiesDataNew.getsName();

        Thread.sleep(5000);
        List<WebElement> element=driver.findElements(By.tagName("p"));
        int row = 0;
        for(int i=0;i<element.size();i++){
            if(element.get(i).getText().equalsIgnoreCase(sName)){
                row=(i+5)/6;
                break;
            }
        }
        // Instantiate HotelBookings Page class
        HotelBookingsPage hotelBookingsPage = PageFactory.initElements(driver, HotelBookingsPage.class);
        // Delete Bookings
        hotelBookingsPage.deleteBookings(driver.findElement(By.xpath("//div[@id='bookings']/div["+(row+1)+"]")).getAttribute("id")/*deleteButtonId*/);

        // Sleep to handle dynamic display of a bookings data to page
        Thread.sleep(5000);
        // Asserting the deletion of bookings data from the page
        assertFalse(driver.getPageSource().contains(sName));
    }

    @After
    public void closeTheBrowser() {
        driver.close();
        driver.quit();
    }

}
