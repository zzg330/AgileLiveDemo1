package com.autodesk.agiledemo;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestWeatherRetriever {

	@Test
	public void result_should_include_city_info() throws DocumentException, IOException {
		WeatherRetriever retriever = new WeatherRetriever();
		InputStream inputStream = retriever.get("70112");
		
		SAXReader xmlReader = new SAXReader();
		Document doc = xmlReader.read(inputStream);
		
		assertTrue(doc.selectSingleNode("/rss/channel/title").hasContent());
	}
}
