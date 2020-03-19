package com.iqvia.api.automation.base;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.iqvia.api.automation.datareader.PropUtil;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	public static RequestSpecification httpRequest;
	public static Response response;
	public String baseUrl;
	public String countryUrl;
	public PropUtil propUtil;
	public String stub;

	@BeforeClass
	public void setup() {
		PropertyConfigurator.configure("log4j.properties");
		propUtil = new PropUtil();
		countryUrl = propUtil.prop.getProperty("LISTOFCOUNTRY");
		baseUrl = propUtil.prop.getProperty("BASEURL");
		stub = propUtil.prop.getProperty("URLSTUB");

	}

}
