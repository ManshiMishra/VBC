package com.example.VaccinationBookingSystem.Service;


import com.example.VaccinationBookingSystem.model.Doctor;
import com.example.VaccinationBookingSystem.DTO.RequestDto.DoctorReqDto;
import com.example.VaccinationBookingSystem.DTO.ResponseDto.CenterResDto;
import com.example.VaccinationBookingSystem.DTO.ResponseDto.DoctorResDto;
import com.example.VaccinationBookingSystem.Exception.CenterNotFoundException;
import com.example.VaccinationBookingSystem.model.Doctor;
import com.example.VaccinationBookingSystem.model.VaccinationCenter;
import com.example.VaccinationBookingSystem.repository.DoctorRepository;
import com.example.VaccinationBookingSystem.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

      @Autowired

      DoctorRepository doctorRepository;

      @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public DoctorResDto addDoctor(DoctorReqDto doctorReqDto) {


        Optional<VaccinationCenter> center = vaccinationCenterRepository.findById(doctorReqDto.getCenterId());


          if(center.isEmpty()){

              throw  new CenterNotFoundException("Sorry, Invalid centerId");
          }

          VaccinationCenter center1 = center.get();


          // create a new doctor entity

         Doctor doctor = new Doctor();

         doctor.setName(doctorReqDto.getName());
         doctor.setAge(doctorReqDto.getAge());
         doctor.setGender(doctorReqDto.getGender());
         doctor.setEmailId(doctorReqDto.getEmailId());
         doctor.setVaccinationCenter(center1);

         center1.getDoctorList().add(doctor);


        // save the center into centerdb;

         VaccinationCenter savedCenter = vaccinationCenterRepository.save(center1);


          List<Doctor> list = savedCenter.getDoctorList();

          Doctor latestDoctor = list.get(list.size()-1);

        CenterResDto centerResDto = new CenterResDto();

        centerResDto.setCenterType(savedCenter.getCenterType());
        centerResDto.setAddress(savedCenter.getAddress());
        centerResDto.setCenterName(savedCenter.getCenterName());
        centerResDto.setCenterType(savedCenter.getCenterType());


        DoctorResDto doctorResDto = new DoctorResDto();
        doctorResDto.setName(latestDoctor.getName());
        doctorResDto.setMessage("congrats! you registered to the center "+savedCenter.getCenterName());

        doctorResDto.setCenterResDto(centerResDto);

        return  doctorResDto;

    }

    public List<String> getAllDoctors(int age) {


          List<Doctor> doctorList = doctorRepository.getByAgeGreaterThan(age);

          List<String> ans = new ArrayList<>();

          for(Doctor doctor: doctorList){

                 ans.add(doctor.getName());
          }

            return ans;

    }
}
