package com.odc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.exception.CreationException;
import com.odc.exception.DeletionException;
import com.odc.exception.EntityNotFoundException;
import com.odc.exception.UpdationException;
import com.odc.model.Payment;
import com.odc.repository.IPaymentRepository;
@Service
public class PaymentServiceImpl implements IPaymentService{

		  @Autowired
	      IPaymentRepository paymentRepository;

	/* *Method       : addPayment
	 *  Description  : to add the payment details
	 * payment        :Payment's reference variable
	 * 
	 * return payment: add payment data else throw the Exception
	 * throw exception: It is raised when we cant create payment 
	 */

		  @Override
		  public Payment addPayment( Payment payment) {
			  
			 // return  paymentRepository.save(payment);
			  
			   try{
			   Payment payment2 = paymentRepository.save(payment);
			   return payment2;
			   }
			   catch(Exception e)
			   {
			   throw  new CreationException("Failed creaction");
			   }
		    }

	/* *Method       : removePayment
	 *  Description  : to delete the payment details
	 * payment        :Payment's reference variable
	 * 
	 * return payment: add payment data else throw the Exception
	 * throw exception: It is raised when we cant create payment 
	 */
		  
		    public Payment removePayment(long id)  { 
		        
		    	
		    	Optional<Payment> optionalPayment = paymentRepository.findById(id);
		    	Payment payment3 = null;
		    	
		    	if(optionalPayment.isPresent()) {
		    		
		    		payment3 = optionalPayment.get();

			        paymentRepository.deleteById(id);
			        return payment3 ;
		    	 }
		    
			        else {
			        	throw new DeletionException("payment with id "+ id +" cant be found");
			        }
		    	
		        }
		    	

	/* *Method       : updataPayment
	 *  Description  : to updata the payment details
	 * payment        :Payment's reference variable
	 * 
	 * return payment: update payment data else throw the Exception
	 * throw exception: It is raised when we cant create payment 
	 */
			public Payment updatePayment(  Payment payment) {

			 
			  Payment pay = paymentRepository.findById(payment.getPaymentId()).orElseThrow(()->
			  new UpdationException(" payment cant be updated"));
			  
			  pay.setPaymentId(payment.getPaymentId());
	          pay.setType(payment.getType());
	          pay.setStatus(payment.getStatus());
			  return paymentRepository.save(pay);
				  
			/*
				Optional<Payment> pay = paymentRepository.findById(payment.getPaymentId());
				Payment payment4 = null;
				    if(pay.isPresent()) {
				      
			  payment.setPaymentId(payment.getPaymentId());
	          payment.setType(payment.getType());
	          payment.setStatus(payment.getStatus());
			  return paymentRepository.save(pay);
			  }
			  else{
			  throw new EntityUpdationException(" payment cant be updated");
			  }
				  */
				  
			}  
			  
			 	  

	/* *Method       : getPayment particular data
	 *  Description  : to fetch the payment details
	 * payment        :Payment's reference variable
	 * 
	 * return payment: fetch payment data else throw the Exception
	 * throw exception: It is raised when we cant create payment 
	 */
		 
		    public  Payment  getPaymentDetails(long id)   {
			  
			 // return paymentRepository.findById(id).orElse(null)
		    	Optional<Payment> optionalPayment = paymentRepository.findById(id);
		    	    Payment  payment  = null;
		    	if(optionalPayment.isPresent()) {
		    		payment = optionalPayment.get();
		    		return payment;
		          }
		    	else {
		    		throw new EntityNotFoundException("payment cant not Found");
		    	}
		    	
		       }  

	/* *Method       : getAllPayment
	 *  Description  : to fetch all  payment details
	 * payment        :Payment's reference variable
	 * 
	 * return payment: get payment data else throw the Exception
	 * throw exception: It is raised when we cant create payment 
	 */
		  
		      public List<Payment> getAllPaymentDetails() {
		    	
			  
			 // return paymentRepository.findAll();
			  List<Payment> allPayments = new ArrayList<>();
			    allPayments =  paymentRepository.findAll();
			    if(!(allPayments.isEmpty())){
			    	
			    	return allPayments;
			    	}
			    else{
			    	throw new EntityNotFoundException("payment Not Found");
			    	
			        }
			  
		      }
		  
		  
	}  
