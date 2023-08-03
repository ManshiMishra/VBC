package com.example.VaccinationBookingSystem.Controller;


import com.example.VaccinationBookingSystem.DTO.RequestDto.AppointmentReqDto;
import com.example.VaccinationBookingSystem.DTO.ResponseDto.AppointmentResponseDto;
import com.example.VaccinationBookingSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/appointment")

public class AppointmentController {


    @Autowired
    AppointmentService appointmentService;


    @PostMapping("/Book_appointment")
    public ResponseEntity  bookAppointment(@RequestBody  AppointmentReqDto appointmentReqDto){

        try{
            AppointmentResponseDto appointmentResponseDto = appointmentService.bookAppointment(appointmentReqDto);

            return new  ResponseEntity(appointmentResponseDto, HttpStatus.ACCEPTED);
        }
        catch (Exception e){

            return  new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
