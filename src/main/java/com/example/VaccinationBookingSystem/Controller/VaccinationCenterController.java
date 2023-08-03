package com.example.VaccinationBookingSystem.Controller;


import com.example.VaccinationBookingSystem.DTO.RequestDto.CenterReqDto;
import com.example.VaccinationBookingSystem.DTO.ResponseDto.CenterResDto;
import com.example.VaccinationBookingSystem.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/center")
public class VaccinationCenterController {


    @Autowired
    VaccinationCenterService vaccinationCenterService;

// adding vaccination center

    @PostMapping("/add=Vcenter")
    public ResponseEntity addVaccinationCenter(@RequestBody CenterReqDto centerReqDto){

        try {
            CenterResDto center = vaccinationCenterService.addVaccinationcnCenter(centerReqDto);


            return new ResponseEntity(center,HttpStatus.ACCEPTED);
        }

        catch (Exception e){

            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }




    }
}
