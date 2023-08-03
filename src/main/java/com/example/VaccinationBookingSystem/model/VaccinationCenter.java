package com.example.VaccinationBookingSystem.model;


import com.example.VaccinationBookingSystem.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VaccinationCenter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String centerName;

    @Enumerated(value = EnumType.STRING)
    CenterType centerType;

   String address;



   @OneToMany(mappedBy = "vaccinationCenter",cascade = CascadeType.ALL)
   List<Doctor> doctorList = new ArrayList<>();



}
