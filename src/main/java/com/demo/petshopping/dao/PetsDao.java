package com.demo.petshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.petshopping.model.Pets;

@Repository
public interface PetsDao extends CrudRepository<Pets, Integer> {

	/**
	 * @param petId
	 * @return find by petid
	 */
	Optional<Pets> findByPetId(Integer petId);

	/**
	 * @param petName
	 * @return find by petname
	 */
	Optional<List<Pets>> findByPetName(String petName);

	/**
	 * @param petName
	 * @return get pet be petname from db
	 */
	@Query(value = "select * from pets p where p.pet_name like %:petName%", nativeQuery = true)
	Optional<List<Pets>> getPetBypetName(@Param("petName") String petName);

}
