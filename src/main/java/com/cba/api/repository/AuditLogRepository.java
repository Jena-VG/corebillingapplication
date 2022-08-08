package com.cba.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cba.entity.AuditLog;

/**
 * Repository to perform all user related operations
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

@Repository
public interface AuditLogRepository extends CrudRepository<AuditLog, Long> {

	

}