package com.odc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.odc.model.Booking;

@Repository // is a specialization of the @Component annotation which indicates that an
			// annotated class is a “Repository”, which can be used as a mechanism for
			// encapsulating storage, retrieval, and search behavior which emulates a
			// collection of objects.
public interface IBookingRepository extends JpaRepository<Booking, Long> {
	@Query(value = "SELECT booking FROM Booking booking WHERE booking.customerDetails.userId=:customerId") // declares
																											// finder
																											// queries
																											// directly
																											// on
																											// repository
																											// methods
	List<Booking> getBookingsByCustomer(@Param(value = "customerId") String customerId);

	@Query(value = "SELECT booking FROM Booking booking WHERE booking.bookingDate=:localDate")
	List<Booking> getBookingsByDate(@Param(value = "localDate") LocalDate localDate); // used to bind a web request
																						// parameter to a method
																						// parameter.
}
