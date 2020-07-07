package com.demo.petshopping.service;

import com.demo.petshopping.dto.BookingResponseDto;
import com.demo.petshopping.dto.ConfirmationListResponseDto;
import com.demo.petshopping.dto.OrderRequestDto;

/**
 * @author Harsha_Reddy
 *
 */
public interface ConfirmationService {

	/**this method is usded to buy a pet and store in db
	 * @param orderRequestDto
	 * @param userId
	 * @return details after buying apet
	 */
	BookingResponseDto buyPet(OrderRequestDto orderRequestDto, Integer userId);

	/**this  method is used to get pets by userid
	 * @param userId
	 * @return pets by userid
	 */
	ConfirmationListResponseDto getPetsByUserId(Integer userId);
}
