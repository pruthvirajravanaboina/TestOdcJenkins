package com.odc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.exception.CreationException;
import com.odc.exception.DeletionException;
import com.odc.exception.EmptyListException;
import com.odc.exception.EntityNotFoundException;
import com.odc.exception.UpdationException;
import com.odc.model.Booking;
import com.odc.repository.IBookingRepository;

@Service // used with classes that provide some business functionalities
public class BookingServiceImpl implements IBookingService {
	@Autowired
	private IBookingRepository bookingRepository;

	@Override
	public Booking addBooking(Booking booking) {
		try {
			Booking booking1 = bookingRepository.save(booking);
			return booking1;
		} catch (Exception e) {
			throw new CreationException("Failed to Create Booking.");
		}
	}

	@Override
	public Booking removeBooking(long bookingId) {
		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId); // It provides a clear and explicit
																					// way to convey the message that
																					// there may not be a value, without
																					// using null.
		Booking booking = null;
		if (optionalBooking.isPresent()) {
			booking = optionalBooking.get();
			bookingRepository.deleteById(bookingId);
			return booking;
		} else {
			throw new DeletionException("Booking With Id " + bookingId + " does Not Exist.");
		}
	}

	@Override
	public Booking updateBooking(Booking booking) {
		Optional<Booking> optionalBooking = null;
		Booking booking1 = null;
		optionalBooking = bookingRepository.findById(booking.getBookingId());
		if (optionalBooking.isPresent()) {
			booking1 = bookingRepository.save(booking);
			return booking1;
		} else {
			throw new UpdationException("Booking With Id " + booking.getBookingId() + "is Not Found.");
		}
	}

	@Override
	public Booking getBooking(long bookingId) {
		Booking booking1 = null;

		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		if (optionalBooking.isPresent()) {
			booking1 = optionalBooking.get();
			return booking1;
		} else {
			throw new EntityNotFoundException("Booking With Id " + bookingId + " does Not Exist.");
		}
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> allBookings = new ArrayList<Booking>();
		allBookings = bookingRepository.findAll();
		if (!allBookings.isEmpty()) {
			return allBookings;
		} else {
			throw new EmptyListException("No Bookings Found.");
		}
	}

	@Override
	public List<Booking> getBookingsByDate(LocalDate localDate) {
		List<Booking> bookings = new ArrayList<Booking>();

		bookings = bookingRepository.getBookingsByDate(localDate);
		if (!bookings.isEmpty()) {
			return bookings;
		} else {
			throw new EmptyListException("No Bookings Found.");
		}
	}

	@Override
	public List<Booking> getBookingsByCustomer(String customerId) {
		List<Booking> bookings = new ArrayList<Booking>();

		bookings = bookingRepository.getBookingsByCustomer(customerId);
		if (!bookings.isEmpty()) {
			return bookings;
		} else {
			throw new EmptyListException("No Bookings Found.");
		}
	}

}
