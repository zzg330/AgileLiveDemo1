package com.autodesk.agiledemo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class WeatherParser {

	private static final String YAHOO_WEATHER_NAMESPACE = "http://xml.weather.yahoo.com/ns/rss/1.0";

	public Weather parse(InputStream inputStream) {
		
		Document doc;
		try {
			doc = createXmlReader().read( inputStream );
		} catch (DocumentException e) {
			e.printStackTrace();
			return new Weather();
		}

		return createWeatherFromXml(doc);
	}

	private Weather createWeatherFromXml(Document doc) {
		Weather weather = new Weather();
		
		weather.setCity( doc.valueOf("/rss/channel/y:location/@city") );
		weather.setRegion( doc.valueOf("/rss/channel/y:location/@region"));
		weather.setCountry( doc.valueOf("/rss/channel/y:location/@country") );
		weather.setCondition( doc.valueOf("/rss/channel/item/y:condition/@text") );
		weather.setTemperature( Float.parseFloat(doc.valueOf("/rss/channel/item/y:condition/@temp")));
		weather.setWindSpeed( doc.valueOf("/rss/channel/y:wind/@speed") );
		weather.setHumidity( doc.valueOf("/rss/channel/y:atmosphere/@humidity") );
		
		return weather;
	}

	private SAXReader createXmlReader() {
		Map<String, String> uris = new HashMap<String, String>();
		uris.put("y", YAHOO_WEATHER_NAMESPACE);

		DocumentFactory factory = new DocumentFactory();
		factory.setXPathNamespaceURIs(uris);

		SAXReader xmlReader = new SAXReader();
		xmlReader.setDocumentFactory(factory);
		return xmlReader;
	}
}