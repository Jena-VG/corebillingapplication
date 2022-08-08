package com.cba.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cba.entity.Subscription;

/**
 * Repository to perform all subscription related operations
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
	/**
	 * Fetches all the subscription records for the given certificate number.
	 * 
	 * @param certificateNbr - Unique number to identify the subscription renewal
	 *                       details
	 * @return List of subscription entity
	 */
	List<Subscription> findBycertificateNbr(String certificateNbr);
	
	List<Subscription> findAllByVinNbr(String vinNbr);
	
	
	@Query(value = "select max(right(subscription_nbr,4)) from ccs_subscriptions where source = 'Mobile App'"
			+ " and subscription_nbr like CONCAT('%', ?1,'%')", nativeQuery = true)
	public  String  findNextNbr(String subscriptionNbr);

}