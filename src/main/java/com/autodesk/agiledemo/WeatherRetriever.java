package com.autodesk.agiledemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherRetriever {

	private static final String WEATHER_YAHOOAPIS_URL = "http://weather.yahooapis.com/forecastrss?p=";

	public InputStream get(String zipcode) {
		InputStream inputStream = null;
		try {
			inputStream = getWeatherConnection(zipcode).getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return inputStream;
	}

	private URLConnection getWeatherConnection(String zipcode) throws IOException, MalformedURLException {
		return new URL(WEATHER_YAHOOAPIS_URL + zipcode).openConnection();
	}

}
