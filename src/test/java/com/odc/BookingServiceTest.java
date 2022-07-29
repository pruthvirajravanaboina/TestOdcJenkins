package com.odc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.odc.model.Booking;
import com.odc.repository.IBookingRepository;
import com.odc.service.IBookingService;

@SpringBootTest
class BookingServiceTest {
	@Autowired
	IBookingService bookingService;

	@Autowired
	IBookingRepository bookingRepo;

	public Booking bookingData() {
		Booking b1 = new Booking();
		b1.setServiceType("DryCleaning");
		b1.setBookingId(101L);
		b1.setBookingDate(LocalDate.now());
		b1.setBookingTime(LocalTime.now());
		return b1;

	}

	public Booking bookingData2() {
		Booking b2 = new Booking();
		b2.setServiceType("Dry");
		b2.setBookingId(102L);
		b2.setBookingDate(LocalDate.now());
		b2.setBookingTime(LocalTime.now());
		return b2;

	}

	@Test
	void testAddBooking() {
		Booking booking = bookingData();
		bookingRepo.save(booking);
		assertThat(booking.equals(bookingService.addBooking(booking)));
	}

	@Test
	void testRemoveBooking() {
		Booking booking = bookingData();
		bookingRepo.save(booking);
		bookingRepo.findById(101L);
		Booking b = bookingService.removeBooking(101L);
		assertFalse(booking.equals(b));
	}

	@Test
	void testUpdateBooking() {
		Booking booking = bookingData();
		bookingRepo.save(booking);
		bookingRepo.findById(101L);
		booking.setServiceType("Dry");
		Booking b1 = bookingService.getBooking(101L);
		bookingRepo.save(booking);
		assertThat(b1.equals(bookingService.updateBooking(booking)));
	}

	@Test
	void testGetAllBookings() {
		Booking booking = bookingData();
		Booking booking1 = bookingData2();
		List<Booking> list = new ArrayList<Booking>();
		list.add(booking);
		list.add(booking1);
		bookingRepo.save(booking);
		bookingRepo.save(booking1);
		List<Booking> b = bookingService.getAllBookings();
		assertThat(list.equals(b));
	}

}
