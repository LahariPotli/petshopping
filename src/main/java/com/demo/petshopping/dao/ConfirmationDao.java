package com.demo.petshopping.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.petshopping.model.Confirmation;

public interface ConfirmationDao extends CrudRepository<Confirmation ,Integer> {

}
