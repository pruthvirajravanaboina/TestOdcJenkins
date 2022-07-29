package com.odc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*  It is a service class that provides the services to add a statement ,
 * remove statements, update statements , view statements.
 * 
 */


import com.odc.model.Payment;
import com.odc.service.IPaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {


	
	@Autowired
	public IPaymentService  paymentService;
	
	
	
	
	/*  *Method                : addPayment
	 * Description             : To add the payment details to the data base.
	 * @RequestBody            : I maps the HttpRequest body to a transfer or domain object,
	 *                           enabling automatic deserialization of the inbound HttpRequest body onto a java Object.
	 * payment                 : payment details to be added to data base.
	 * return                  :payment
	 * 
	 */
	@PostMapping("/add")
	public Payment addPayments(@RequestBody Payment payment) {
		 
		return paymentService.addPayment(payment);
	}
	
	
	
	/*  *Method                : deletePayment
	 * Description             : To delete the payment details to the data base.
	 * @RequestBody            : I maps the HttpRequest body to a transfer or domain object,
	 *                           enabling automatic deserialization of the inbound HttpRequest body onto a java Object.
	 * payment                 : payment details to be deleted from data base.
	 * return                  :payment
	 * 
	 */
	
	
	@DeleteMapping("/delete/{id}")
    public Payment removePayment(@PathVariable long id) { 
        
    	return paymentService.removePayment(id);
    	
    }
	
	
	/*  *Method                : getPaymentDetails
	 * Description             : To fetch the payment details from the data base.
	 * @RequestBody            : I maps the HttpRequest body to a transfer or domain object,
	 *                           enabling automatic deserialization of the inbound HttpRequest body onto a java Object.
	 * payment                 : payment details to be added to data base.
	 * return                  :payment
	 * 
	 */
    
    @GetMapping("/view/{id}")
    public  Payment  getPaymentDetails(@PathVariable long id) {

          return paymentService.getPaymentDetails(id);
    }
    
	/*  *Method                : getAllPayment
	 * Description             : To fetchAll  payment details from the data base.
	 * @RequestBody            : I maps the HttpRequest body to a transfer or domain object,
	 *                           enabling automatic deserialization of the inbound HttpRequest body onto a java Object.
	 * payment                 : payment details to be added to data base.
	 * return                  :payment
	 * 
	 */
    
    @GetMapping("/all")
    public List<Payment> getAllPayment(){

    	return paymentService.getAllPaymentDetails();
    	
    }
    
    
	/*  *Method                : updatePayment
	 * Description             : To update the payment details to the data base.
	 * @RequestBody            : I maps the HttpRequest body to a transfer or domain object,
	 *                           enabling automatic deserialization of the inbound HttpRequest body onto a java Object.
	 * payment                 : payment details to be updated to data base.
	 * return                  :payment
	 * 
	 */
    @PutMapping("/update")
	public Payment updatePayment( @RequestBody Payment payment) {

     Payment payment1 = paymentService.updatePayment( payment);
     return payment1;
	}
    
    
    
    
    
    
}
