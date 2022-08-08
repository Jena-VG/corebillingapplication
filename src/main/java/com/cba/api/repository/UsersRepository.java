package com.cba.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cba.entity.Users;

/**
 * Repository to perform all user related operations
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

	List<Users> findByuserType(String string);

	List<Users> findByClientIdAndClientSecretKey(String clientId, String clientKey);

	Users findByLogin(String string);

	Users findByEmailAndToken(String email, String token);
}