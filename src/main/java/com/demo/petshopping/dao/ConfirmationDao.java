package com.demo.petshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.demo.petshopping.model.Confirmation;

/**
 * @author lahari_Reddy
 *
 */
public interface ConfirmationDao extends CrudRepository<Confirmation ,Integer> {

	/**
	 * @param userId
	 * @return find all by userid
	 */
	Optional<List<Confirmation>> findAllByUserId(Integer userId);

	/**
	 * @param petId
	 * @param userId
	 * @return find by petid and userid
	 */
	Optional<Confirmation> findByPetIdAndUserId(int petId, Integer userId);
	

}
