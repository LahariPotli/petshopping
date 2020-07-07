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

import com.demo.petshopping.dto.PetListResponseDto;
import com.demo.petshopping.dto.PetResponseDto;
import com.demo.petshopping.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

	@Mock
    PetService petsService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    PetController petController;

    PetListResponseDto petListResponseDto;
    
   
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
        
        
    }
    @Test
	public void getPetsByPetName() throws Exception {
    	PetResponseDto petResponseDto=new PetResponseDto();
    	petResponseDto.setPetId(1);
    	petResponseDto.setPetName("pug");
    	petResponseDto.setPrice(5000);
    	petResponseDto.setPetColour("Black");
    	List<PetResponseDto> petResponseDtoList=new ArrayList<>();
    	 PetListResponseDto petListResponseDto=new PetListResponseDto();
    	 petResponseDtoList.add(petResponseDto);
    	 petListResponseDto.setMessage("list of pets");
    	 petListResponseDto.setStatusCode(200);
    	 petListResponseDto.setReponselistDto(petResponseDtoList);
		
    	 
 		when(petsService.getPetsByPetName("husky")).thenReturn(petListResponseDto);

 		mockMvc.perform(get("/pets").contentType(MediaType.APPLICATION_JSON_VALUE)
 				.param("petName", "husky")
 				.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
 				.andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
 		verify(petsService).getPetsByPetName("husky");
 	}
 
	}
