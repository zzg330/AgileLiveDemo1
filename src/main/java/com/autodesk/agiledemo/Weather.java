package com.autodesk.agiledemo;

public class Weather { 
	private String city;
	private String region;
	private String country;
	private double temperature;
	private String condition;
	private String humidity;
	private String windSpeed;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() { 
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	} 
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWearingAdvice() {
		if (this.temperature>=80d || this.temperature<=59d)
			return "No Advice";
		if (this.condition.equals("Raining") && this.temperature>=70d)
			return "Umbrella, T-shirt";
		if (this.condition.equals("Raining"))
			return "Raincoat";
		if (this.temperature>=70d)
			return "T-shirt";
		return "Shirts"; 
	}
	
}