/**
 * 
 */
package org.equalexperts.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Georgy
 *
 */
public class GetConfigPropertiesData {
	private String os, url, fName, sName, price, deposit, checkinDate, checkoutDate;

	public GetConfigPropertiesData() {
	}

	public GetConfigPropertiesData(String os, String url, String fName, String sName, String price, String deposit, String checkinDate, String checkoutDate) {
		super();
		this.os = os;
		this.url = url;
		this.fName = fName;
		this.sName = sName;
		this.price = price;
		this.deposit = deposit;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public GetConfigPropertiesData getConfigData(){
		GetConfigPropertiesData configPropertiesData = new GetConfigPropertiesData();
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
			configPropertiesData.setUrl(prop.getProperty("url"));
			configPropertiesData.setOs(prop.getProperty("os"));
			configPropertiesData.setfName(prop.getProperty("firstName"));
			configPropertiesData.setsName(prop.getProperty("surname"));
			configPropertiesData.setPrice(prop.getProperty("price"));
			configPropertiesData.setDeposit(prop.getProperty("deposit"));
			configPropertiesData.setCheckinDate(prop.getProperty("checkinDate"));
			configPropertiesData.setCheckoutDate(prop.getProperty("checkoutDate"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return configPropertiesData;
		
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
