/**
 * 
 */
package org.equalexperts.pages;

//import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Georgy
 *
 */
public class HotelBookingsPage {
	WebDriver driver;

	// Page Factory declaration of elements of the page
	@FindBy
		(how= How.ID, using="firstname")
	@CacheLookup
    WebElement firstnameInput;

	@FindBy
			(how= How.ID, using="lastname")
	@CacheLookup
    WebElement surnameInput;

	@FindBy
			(how= How.ID, using="totalprice")
	@CacheLookup
    WebElement priceInput;

	@FindBy
			(how= How.XPATH, using="//select[@id='depositpaid']")
	@CacheLookup
    WebElement depositPaidInput;

	@FindBy
			(how= How.ID, using="checkin")
	@CacheLookup
    WebElement checkinInput;

	@FindBy
			(how= How.ID, using="ui-datepicker-div")
	@CacheLookup
    WebElement datePicker;

	@FindBy
			(how= How.ID, using="checkout")
	@CacheLookup
    WebElement checkoutInput;

	@FindBy
			(how= How.XPATH, using="//input[@value=' Save ']")
	@CacheLookup
    WebElement save;

	@FindBy
			(how= How.XPATH, using="//input[@value=' Save ']")
	@CacheLookup
    WebElement delete;

	// This is a constructor, as every page need a base driver to find web elements
	public HotelBookingsPage(WebDriver driver) {
		this.driver = driver;
	}
	

	// Fill in booking details
	public void fillBookingDetails(String fname, String sname, String price, String depositPaid, String checkinDate, String checkoutDate) throws InterruptedException {

		// Filling Firstname, Surname and Price
		firstnameInput.sendKeys(fname);
		surnameInput.sendKeys(sname);
		priceInput.sendKeys(price);

		// Selecting Deposit Dropdown
		Select depositDropdown = new Select(depositPaidInput);
		depositDropdown.selectByVisibleText(depositPaid);

		checkinInput.sendKeys(checkinDate);
		checkoutInput.sendKeys(checkoutDate);
	}

	//	Getting page title
	public String getPageTitle(){
		String temp=driver.getTitle();
		return temp;
	}

	// Save Bookings
	public void saveBookings(){
		save.click();
	}

	//	Delete Bookings
	public void deleteBookings(String divId){
		String deleteButtonxpath = "//div[@id='bookings']//input[@onclick='deleteBooking("+divId+")']";
		WebElement deleteButton = driver.findElement(By.xpath(deleteButtonxpath));
		deleteButton.click();
	}
}
