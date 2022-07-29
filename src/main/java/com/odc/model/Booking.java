package com.odc.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // An entity is a lightweight persistence domain object. Typically, an entity
		// represents a table in a relational database, and each entity instance
		// corresponds to a row in that table
public class Booking {
	@Id // specifies the primary key of an entity
	private long bookingId;
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	private String serviceType;
	@OneToOne // states that each element of one set, say Set (A) is mapped with a unique
				// element of another set, say Set(B)
	private Customer customerDetails;

	public Booking() { // An empty constructor is needed to create a new instance via reflection by
						// your persistence framework
		super();
	}

	public Booking(long bookingId, LocalDate bookingDate, LocalTime bookingTime, String serviceType,
			Customer customerDetails) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.serviceType = serviceType;
		this.customerDetails = customerDetails;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@JsonIgnore // used to ignore the logical property used in serialization and deserialization
	public Customer getCustomerDetails() {
		return customerDetails;
	}

	//@JsonIgnore // can be used at setter, getter or field
	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime
				+ ", serviceType=" + serviceType + ", customerDetails=" + customerDetails + "]";
	}

}
