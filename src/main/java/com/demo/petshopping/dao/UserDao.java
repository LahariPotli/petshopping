package com.demo.petshopping.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.petshopping.model.User;


public interface UserDao extends CrudRepository<User ,Integer> {

}
