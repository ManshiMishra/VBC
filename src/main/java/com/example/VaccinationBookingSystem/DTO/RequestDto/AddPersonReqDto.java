package com.example.VaccinationBookingSystem.DTO.RequestDto;


import com.example.VaccinationBookingSystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonReqDto {


    String name;

    int age;

    String emailId;

    Gender gender;

}
