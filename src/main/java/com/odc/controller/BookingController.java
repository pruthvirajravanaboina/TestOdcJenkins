package com.odc.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.model.Booking;
import com.odc.service.IBookingService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController // used to create RESTful web services using Spring MVC(model-view-controller :-
				// which is a framework used to build web applications.
@RequestMapping("/bookings") // maps HTTP requests to handler methods of MVC and REST controllers
public class BookingController {

	@Autowired // which enables to inject the object dependency implicitly
	private IBookingService bookingService;

	@PostMapping("/add") // handle the HTTP POST requests
	public Booking addBooking(@RequestBody Booking booking) {
		Booking booking1 = null;
		booking1 = this.bookingService.addBooking(booking);
		return booking1;
	}

	@GetMapping("/all") // handle the HTTP GET requests matched with given URI(Uniform Resource
						// Identifier) expression
	public List<Booking> getAllBookings() {
		List<Booking> bookings = this.bookingService.getAllBookings();
		return bookings;
	}

	@GetMapping("/view/{bookingId}")
	public Booking getBooking(@PathVariable long bookingId) {
		Booking booking1 = this.bookingService.getBooking(bookingId);
		return booking1;
	}

	@DeleteMapping("/delete/{bookingId}") // handle the HTTP DELETE requests
	public Booking removeBooking(@PathVariable long bookingId) {
		Booking booking1 = this.bookingService.removeBooking(bookingId);
		return booking1;
	}

	@PutMapping("/update") // handle the HTTP PUT requests
	public Booking updateBooking(@RequestBody Booking booking) {
		Booking booking1 = this.bookingService.updateBooking(booking);
		return booking1;
	}

	@GetMapping("/getbydate/{localDate}")
	public List<Booking> getBookingsByDate(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate localDate) {
		List<Booking> booking1 = this.bookingService.getBookingsByDate(localDate);
		return booking1;
	}

	@GetMapping("/getbycustomer/{customerId}")
	public List<Booking> getBookingsByCustomer(@PathVariable String customerId) {
		List<Booking> booking1 = this.bookingService.getBookingsByCustomer(customerId);
		return booking1;
	}

}
