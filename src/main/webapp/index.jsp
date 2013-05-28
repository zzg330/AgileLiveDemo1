<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.autodesk.agiledemo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather</title>
</head>

<body>
	<%
		String zipCode = request.getParameter("zip");
		Weather weather = null;
		if (zipCode != null && !zipCode.isEmpty()){
			weather = new WeatherParser().parse(new WeatherRetriever().get(zipCode));
		}
 	%>
	<form>
		zip-code: <input type="text" name="zip" /> <input type="submit"
			value="submit" id="submit"/>
	</form>

	<hr>
	
	<%if (weather != null) {%>
	<ul>
		<li><span id="city">City: </span><span id="city-value"><%= weather.getCity()%></span></li>
        <li><span id="region">Region: </span><span id="region-value"><%= weather.getRegion()%></span></li>
        <li><span id="country">Country: </span><span id="country-value"><%= weather.getCountry()%></span></li>
        <li><span id="temperature">Temperature: </span><span id="temperature-value"><%= weather.getTemperature()%></span></li>
        <li><span id="condition">Condition: </span><span id="condition-value"><%= weather.getCondition()%></span></li>
        <li><span id="humidity">Humidity: </span><span id="humidity-value"><%= weather.getHumidity()%></span></li>
        <li><span id="wind-speed">Wind Speed: </span><span id="wind-speed-value"><%= weather.getWindSpeed()%></span></li>
        <li><span id="wearing-advice">Wearing Advice: </span><span id="wearing-advice-value"><%= weather.getWearingAdvice()%></span></li>
	</ul>
	<%} %>
</body>

</html>