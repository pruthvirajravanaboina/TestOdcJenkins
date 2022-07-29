package com.odc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.odc.model.Payment;

/*
 * PaymentRepository is a interface which extends to JPA repository.
 * This class belong to DAO layer.It is used to perform CRUD operations 
 * with our entity by JPA repositories for automatic implementation.
 * 
 * 
 */
@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Long>  {

}
