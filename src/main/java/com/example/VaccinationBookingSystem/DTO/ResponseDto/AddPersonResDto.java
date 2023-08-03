package com.example.VaccinationBookingSystem.DTO.ResponseDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonResDto {


     String name;

     String message;



}
