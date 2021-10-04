package com.tut;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Address {

	@Id                                                  //treat int as primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //works as auto increment
	@Column(name = "No_Street")                          //col name changed to NO_Street
	private int streetNo;
	
	@Column(length = 50, name = "StreetName")            // we can use multiple parameters
	private String streetName;
	
	@Column(length = 50, name = "City")
	private String city;
	
	@Transient                                          //it will not create column
	private double x;                                   //having  @Transient  
	
	@Temporal(TemporalType.DATE)                        // it will show only date not time
	private Date addedDate;
	
	@Lob                                               // will tell hibernate that it is 
	private byte[] image;                              // large object & setting image

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int streetNo, String streetName, String city, double x, Date addedDate, byte[] image) {
		super();
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.city = city;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", streetName=" + streetName + ", city=" + city + ", x=" + x
				+ ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
	}
	

}
