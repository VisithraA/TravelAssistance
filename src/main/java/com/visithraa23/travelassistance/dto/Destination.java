package com.visithraa23.travelassistance.dto;

public class Destination {
	private String placeName;
	private String Location;
	private String image;
	private int noOfDays;
	private String budget;
	private String hotelRating;

	public Destination(String placeName, String location, String image, int noOfDays, String budget,
			String hotelRating) {
		super();
		this.placeName = placeName;
		Location = location;
		this.image = image;
		this.noOfDays = noOfDays;
		this.budget = budget;
		this.hotelRating = hotelRating;
	}

	public Destination() {
	}

	public Destination(String string, String string2, String string3, String string4, int int1, String string5) {
		// TODO Auto-generated constructor stub
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(String hotelRating) {
		this.hotelRating = hotelRating;
	}

	@Override
	public String toString() {
		return "Destination [placeName=" + placeName + ", Location=" + Location + ", image=" + image + ", noOfDays="
				+ noOfDays + ", budget=" + budget + ", hotelRating=" + hotelRating + "]";
	}

	
}
