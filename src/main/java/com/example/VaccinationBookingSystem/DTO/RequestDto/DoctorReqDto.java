package com.example.VaccinationBookingSystem.DTO.RequestDto;

import com.example.VaccinationBookingSystem.Enum.Gender;

import com.example.VaccinationBookingSystem.model.VaccinationCenter;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorReqDto {


    String name;

    int age;


    String emailId;


    Gender gender;

    int centerId;


}
