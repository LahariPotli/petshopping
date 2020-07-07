package com.demo.petshopping.servicetest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.petshopping.dao.PetsDao;
import com.demo.petshopping.dto.PetListResponseDto;
import com.demo.petshopping.dto.PetResponseDto;
import com.demo.petshopping.exception.PetNotFoundException;
import com.demo.petshopping.model.Pets;
import com.demo.petshopping.service.PetService;
import com.demo.petshopping.serviceimpl.PetServiceImpl;


@ExtendWith(MockitoExtension.class)
public class PetServiceImplTest {
	
		@Mock
		PetsDao petsDao;

		@InjectMocks
		PetServiceImpl petsServiceImpl;

		Pets pets =new Pets();

		PetListResponseDto petListResponseDto;

		@Mock
		PetService petsService;

		@BeforeEach
		public void setUp() {
			pets=new Pets();
		}

		@Test
		public void getPetsByPetName() {
			
			List<Pets> petsList = new ArrayList<>();
			PetResponseDto responseDto = new PetResponseDto();
			
			responseDto.setPetId(1);
			responseDto.setPetName("pug");
			responseDto.setPrice(5000);
			
			
			when(petsDao.findByPetName("husky")).thenReturn(Optional.ofNullable(petsList));
			
			petsServiceImpl.getPetsByPetName("husky");
			
			verify(petsDao).findByPetName("husky");
		
		}
		@Test
		public void getPetsByPetName1() {
			
			List<Pets> petsList = new ArrayList<>();
			PetResponseDto responseDto = new PetResponseDto();
			
			responseDto.setPetId(1);
			responseDto.setPetName("pug");
			responseDto.setPrice(5000);
			responseDto.setPetColour("black");
			
			
			when(petsDao.findByPetName("pug")).thenReturn(Optional.of(petsList));
			
			petsServiceImpl.getPetsByPetName("pug");
			
			verify(petsDao).findByPetName("pug");
		
		}
		@Test
		public void getPetsByPetName2() throws PetNotFoundException{
			
			PetResponseDto responseDto = new PetResponseDto();
			
			responseDto.setPetId(1);
			responseDto.setPetName("pug");
			responseDto.setPrice(5000);
			PetNotFoundException exception = assertThrows(PetNotFoundException.class, () -> {
		        petsServiceImpl.getPetsByPetName("pug");
		    });
			 String expectedMessage = "pet is not found with the requested pet name";
			    String actualMessage = exception.getMessage();
			    assertTrue(actualMessage.contains(expectedMessage));
		}
		
}
