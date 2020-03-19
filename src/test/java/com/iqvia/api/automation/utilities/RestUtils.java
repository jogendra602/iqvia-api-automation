package com.iqvia.api.automation.utilities;

public class RestUtils {

	public static String replace(String source, String find, String replaceWith) {
		return source.replace(find, replaceWith);
	}

	public static String setURL(String baseUri, String endPoint) {
		return baseUri + endPoint;
	}

	public String getCurrenciesOfSelectedCapital(String url, String capitalName) {

		return url;
	}
}
