package com.cba.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cba.entity.Customer;

/**
 * Repository to perform all customer related operations
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	/**
	 * This method is to check if the customer record exists for the given customer
	 * number
	 * 
	 * @param customerNbr - Unique customer number to check if the record exists
	 * @return Boolean - True if the record exists else return false.
	 */
	boolean existsCustomerBycustomerNbr(String customerNbr);

	/**
	 * Fetches all the customer records for the given customer number.Eventually
	 * this should contain only one record
	 * 
	 * @param customerNbr - Unique customer number to fetch the customer record
	 * @return List of Customer Entity
	 */
	List<Customer> findBycustomerNbr(String customerNbr);
	
	/**
	 * fetch all the customer records 
	 */
	List<Customer> findAll();

}
