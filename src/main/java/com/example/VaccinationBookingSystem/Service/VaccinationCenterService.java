package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.DTO.RequestDto.CenterReqDto;
import com.example.VaccinationBookingSystem.DTO.ResponseDto.CenterResDto;
import com.example.VaccinationBookingSystem.model.VaccinationCenter;
import com.example.VaccinationBookingSystem.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

   @Autowired
   VaccinationCenterRepository vaccinationCenterRepository;
    public CenterResDto addVaccinationcnCenter(CenterReqDto centerReqDto) {

           // dto - entity
          VaccinationCenter center = new VaccinationCenter();

          center.setCenterName(centerReqDto.getCenterName());
          center.setCenterType(centerReqDto.getCenterType());
          center.setAddress(centerReqDto.getAddress());


          // saving entity to the database
          VaccinationCenter savedcenter = vaccinationCenterRepository.save(center);


          // entity - dto

         CenterResDto  centerResDto = new CenterResDto();

         centerResDto.setCenterName(savedcenter.getCenterName());
         centerResDto.setCenterType(savedcenter.getCenterType());
         centerResDto.setAddress(savedcenter.getAddress());


         return centerResDto;






    }
}
