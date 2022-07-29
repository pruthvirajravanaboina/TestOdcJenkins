package com.odc.service;

import java.time.LocalDate;
import java.util.List;

import com.odc.model.Booking;

public interface IBookingService {
	public Booking addBooking(Booking booking);

	public Booking removeBooking(long bookingId);

	public Booking updateBooking(Booking booking);

	public Booking getBooking(long bookingId);

	public List<Booking> getAllBookings();

	public List<Booking> getBookingsByDate(LocalDate localDate);

	public List<Booking> getBookingsByCustomer(String customerId);
}
