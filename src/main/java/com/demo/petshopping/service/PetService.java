package com.demo.petshopping.service;



import com.demo.petshopping.dto.PetListResponseDto;


public interface PetService {
	/**this method is used to get pets by petname
	 * @param petName
	 * @return get pets by petname
	 */
	public PetListResponseDto getPetsByPetName(String petName);

}
