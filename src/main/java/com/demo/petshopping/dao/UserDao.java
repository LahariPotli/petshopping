package com.demo.petshopping.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.petshopping.model.User;

@Repository
public interface UserDao extends CrudRepository<User ,Integer> {
	/**
	 * @param UserName
	 * @param password
	 * @return find by username and password
	 */
	Optional<User> findByUserNameAndPassword(String userName, String password);
	/**
	 * @param userId
	 * @return find by userid
	 */
	Optional<User> findByUserId(Integer userId);

}
