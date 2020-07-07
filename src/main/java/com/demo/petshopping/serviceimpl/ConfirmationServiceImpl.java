package com.demo.petshopping.serviceimpl;

import java.time.LocalDate;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.petshopping.dao.ConfirmationDao;
import com.demo.petshopping.dao.PetsDao;
import com.demo.petshopping.dao.UserDao;
import com.demo.petshopping.dto.BookingResponseDto;
import com.demo.petshopping.dto.ConfirmationListResponseDto;
import com.demo.petshopping.dto.OrderRequestDto;
import com.demo.petshopping.dto.PurchaseListDto;

import com.demo.petshopping.exception.InvalidPetIdException;
import com.demo.petshopping.exception.InvalidUserIdException;
import com.demo.petshopping.exception.UserIdNotFoundException;
import com.demo.petshopping.model.Confirmation;
import com.demo.petshopping.model.Pets;
import com.demo.petshopping.model.User;
import com.demo.petshopping.service.ConfirmationService;

/**
 * @author lAHARI_Reddy
 *
 */
@Service
public class ConfirmationServiceImpl implements ConfirmationService {
	static Log logger = LogFactory.getLog(ConfirmationServiceImpl.class);
	@Autowired
	ConfirmationDao confirmationDao;
	@Autowired
	PetsDao petsDao;
	@Autowired
	UserDao userDao;

	/**
	 *{@inherit doc}
	 */
	@Override
	public ConfirmationListResponseDto getPetsByUserId(Integer userId) {
		logger.info("inside get pets by userid confirmationserviceimpl");
		ConfirmationListResponseDto confirmationListResponseDto = new ConfirmationListResponseDto();

		Optional<List<Confirmation>> confirmations = confirmationDao.findAllByUserId(userId);
		if (!confirmations.isPresent()) {
			throw new InvalidUserIdException("no pets are purchased by this userId.");
		}

		List<PurchaseListDto> purchaseListDto = confirmations.get().stream()
				.map(confirmation -> getPurchaseListDto(confirmation)).collect(Collectors.toList());
		confirmationListResponseDto.setPurchaseListDto(purchaseListDto);
		confirmationListResponseDto.setMessage("Please find the pet details");
		confirmationListResponseDto.setStatusCode(200);
		return confirmationListResponseDto;
	}

	private PurchaseListDto getPurchaseListDto(Confirmation confirmation) {

		PurchaseListDto purchaseListDto = new PurchaseListDto();

		Optional<Pets> pets = petsDao.findById(confirmation.getPetId());
		if (!pets.isPresent())
			return null;
		purchaseListDto.setPetName(pets.get().getPetName());
		purchaseListDto.setPrice(pets.get().getPrice());

		BeanUtils.copyProperties(confirmation, purchaseListDto);
		return purchaseListDto;
	}
	/**
	 *{@inherit doc}
	 */
	@Override
	public BookingResponseDto buyPet(OrderRequestDto orderRequestDto, Integer userId) {
		logger.info("inside buyPet confirmationserviceimpl");

		Confirmation confirmation = new Confirmation();

		Optional<User> user1 = userDao.findByUserId(userId);

		if (!user1.isPresent()) {
			throw new UserIdNotFoundException("User with this user Id is not found ");
		}
		Optional<Pets> pet1 = petsDao.findByPetId(orderRequestDto.getPetId());
		if (!pet1.isPresent()) {
			throw new InvalidPetIdException("pet with this pet Id is not found ");
		}

		confirmation.setDate(LocalDate.now());
		confirmation.setPetId(orderRequestDto.getPetId());
		confirmation.setUserId(userId);
		confirmationDao.save(confirmation);

		BookingResponseDto bookingResponseDto = new BookingResponseDto();
		Optional<Pets> pets = petsDao.findById(confirmation.getPetId());
		bookingResponseDto.setPetName(pets.get().getPetName());
		bookingResponseDto.setPrice(pets.get().getPrice());
		bookingResponseDto.setStatusCode(200);
		bookingResponseDto.setMessage("please find youor details");
		BeanUtils.copyProperties(confirmation, bookingResponseDto);
		return bookingResponseDto;

	}

}
