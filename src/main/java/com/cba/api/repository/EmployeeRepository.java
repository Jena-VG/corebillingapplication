package com.cba.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cba.entity.Employee;

/**
 * Repository to perform all employee related operations
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	/**
	 * This method is to check if the employee record exists for the given employee
	 * number
	 * 
	 * @param empNbr - Unique employee number to check if the record exists
	 * @return Boolean - True if the record exists else return false.
	 */
	boolean existsEmployeeByempNbr(String empNbr);

	/**
	 * Fetches all the employee records for the given employee number.Eventually
	 * this should contain only one record
	 * 
	 * @param empNbr - Unique employee number to fetch the employee record
	 * @return List of employee Entity
	 */
	List<Employee> findByempNbr(String empNbr);

}