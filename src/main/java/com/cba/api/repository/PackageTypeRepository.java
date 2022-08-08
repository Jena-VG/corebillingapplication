package com.cba.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cba.entity.PackageType;
/**
 * Repository to perform all package type related operations
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */


public interface PackageTypeRepository extends JpaRepository<PackageType, Integer> {

	/**
	 * This method is used to fetch all the packag details by the given code
	 * 
	 * @param pkgCode - The package code that is used to identify the record
	 * @return - List of Package code records that matches the package code
	 */
	List<PackageType> findBypkgCode(String pkgCode);

}
