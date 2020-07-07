package com.demo.petshopping.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.petshopping.dto.ConfirmationListResponseDto;
import com.demo.petshopping.dto.PurchaseListDto;
import com.demo.petshopping.service.ConfirmationService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class ConfirmationControllerTest {
	
	
		@Mock
	    ConfirmationService confirmationService;

		MockMvc mockMvc;
	    ObjectMapper objectMapper;

	    @InjectMocks
	    ConfirmationController confirmationController;

	    ConfirmationListResponseDto confirmationListResponseDto;
	    
	   
	    @BeforeEach
	    public void setUp() {
	        objectMapper = new ObjectMapper();
	        mockMvc = MockMvcBuilders.standaloneSetup(confirmationController).build();
	        
	        
	    }
	    @Test
	    public void getPetsByUserId() throws Exception {
	    	PurchaseListDto purchaseDto=new PurchaseListDto();
	    	purchaseDto.setPrice(5000);
	    	purchaseDto.setPetName("pug");
	    	List<PurchaseListDto> purchaseListDto=new ArrayList<>();
	    	 ConfirmationListResponseDto confirmationListResponseDto=new ConfirmationListResponseDto();
	    	 purchaseListDto.add(purchaseDto);
	    	 confirmationListResponseDto.setMessage("Please find the pet details");
	    	 confirmationListResponseDto.setStatusCode(200);
	    	 confirmationListResponseDto.setPurchaseListDto(purchaseListDto);
			
	    	 
	 		when(confirmationService.getPetsByUserId(1)).thenReturn(confirmationListResponseDto);

	 		mockMvc.perform(get("/users/{userId}/confirmation",1).contentType(MediaType.APPLICATION_JSON_VALUE)
	 				.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
	 				.andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
	 		verify(confirmationService).getPetsByUserId(1);
	 	}
	 
}