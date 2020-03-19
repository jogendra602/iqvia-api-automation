package com.iqvia.api.automation.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.iqvia.api.automation.base.TestBase;
import com.iqvia.api.automation.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class CountriesAPITest extends TestBase {
	String capital;
	public static Logger logger = Logger.getLogger("get all countries");

	@BeforeClass
	void getAllCountries() throws InterruptedException {
		logger.info("get all countries");
		RestAssured.baseURI = countryUrl;
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "");
	}

	@Test(priority = 1, enabled = true)
	void checkStatusCode() {
		logger.info("verify status code");
		int statusCode = response.getStatusCode();
		logger.info("Status Code :" + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 2, enabled = true)
	public void setCityFromJsonResponse() {
		logger.info("set capital name for next request");
		JsonPath jsonPathEvaluator = response.jsonPath();
		String jsonAsArrayList = jsonPathEvaluator.get("capital[0]");
		capital = jsonAsArrayList;
	}

	@Test(priority = 3, enabled = true)
	void verifySelectedCapitalInfo() {
		logger.info("getting selected capital information");
		String uri = RestUtils.replace(baseUrl, stub, capital);
		RestAssured.baseURI = uri;
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "");
		String responseBody = response.getBody().asString();
		logger.info("selected capital information " + responseBody);
		Assert.assertTrue(responseBody != null); // negative user case
	}

	@Test(priority = 4, enabled = true)
	void verifyStatusLine() {
		logger.info(" checking status line");
		String statusLine = response.getStatusLine(); // Getting Status Line code AFN
		Assert.assertEquals(statusLine, "HTTP/1.1 200 ");
	}

	@Test()
	void verifyCountryCode() {
		logger.info("verify country code ");
		JsonPath jsonPathEvaluator = response.jsonPath();
		String code = jsonPathEvaluator.get("alpha3Code[0]");
		Assert.assertEquals(code, "AFG");
	}

	@AfterClass
	public void afterClass() {
		logger.info("test executed successfully");
	}

}
