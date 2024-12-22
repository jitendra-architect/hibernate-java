package org.example.entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="student_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

	@Column(length = 50, name = "STREET", nullable = false)
	private String street;

	@Column(length = 100, name = "CITY")
	private String city;

	@Column(name = "is_Open")
	private boolean isOpen;

	@Column(name="added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;

	@Transient
	private double lat;

	@Lob
	private byte[] image;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean open) {
		isOpen = open;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Address() {}
	public Address(int addressId, String street, String city, boolean isOpen, Date addedDate, double lat, byte[] image) {
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.addedDate = addedDate;
		this.lat = lat;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address{" +
				"addressId=" + addressId +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", isOpen=" + isOpen +
				", addedDate=" + addedDate +
				", lat=" + lat +
				", image=" + Arrays.toString(image) +
				'}';
	}
}
