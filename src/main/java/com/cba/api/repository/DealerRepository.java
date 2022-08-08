package com.cba.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cba.entity.Dealer;

/**
 * Repository to perform all dealer related operations
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

@Repository
public interface DealerRepository extends CrudRepository<Dealer, Long> {

	
	/**
	 * This method is to check if the dealer record exists for the given dealer
	 * number
	 * 
	 * @param dealerNbr - Unique dealer number to check if the record exists
	 * @return Boolean - True if the record exists else return false.
	 */
	boolean existsDealerBydealerNbr(String dealerNbr);
	
	List<Dealer> findBydealerNbr(String dealerNbr);
	
}