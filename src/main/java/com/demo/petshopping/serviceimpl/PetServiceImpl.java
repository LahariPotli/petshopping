
package com.demo.petshopping.serviceimpl;

 




 

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.petshopping.dao.PetsDao;
import com.demo.petshopping.dto.PetListResponseDto;
import com.demo.petshopping.dto.PetResponseDto;
import com.demo.petshopping.exception.PetNotFoundException;
import com.demo.petshopping.model.Pets;
import com.demo.petshopping.service.PetService;
/**
 * @author lahari_Reddy
 *
 */
@Service
public class PetServiceImpl implements PetService {
	static Log logger = LogFactory.getLog(PetServiceImpl.class);
	
    @Autowired
    PetsDao petDao;

 

    /**
     *{@Inherit Doc}
     */
    @Override
    public PetListResponseDto getPetsByPetName(String petName) {
    	logger.info("inside get pets by petname in petserviceimpl");
    	PetListResponseDto petListResponseDto=new PetListResponseDto();
        
            Optional<List<Pets>> petsOptional =petDao.findByPetName(petName);
            if (!petsOptional.isPresent())
            {
                throw new PetNotFoundException("pet is not found with the requested pet name");
            }
            List<PetResponseDto> petResponseDto = petsOptional.get().stream()
					.map(pets -> getPetResponseDto(pets)).collect(Collectors.toList());
            petListResponseDto.setReponselistDto(petResponseDto);
            petListResponseDto.setMessage("please find your list of pets");
            petListResponseDto.setStatusCode(200);
			return petListResponseDto;
        }
        private PetResponseDto getPetResponseDto(Pets pets)
        {
            PetResponseDto petResponseDto = new PetResponseDto();
            BeanUtils.copyProperties(pets, petResponseDto);
            
           
            return petResponseDto;
        }
    }
 