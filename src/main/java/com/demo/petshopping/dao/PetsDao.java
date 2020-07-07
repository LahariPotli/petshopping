package com.demo.petshopping.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.petshopping.model.Pets;



public interface PetsDao extends CrudRepository<Pets ,Integer> {

}
