package com.example.VaccinationBookingSystem.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String appointmentId;
    @CreationTimestamp
    Date appointmentDate;

    int doseNo;


    @ManyToOne
    @JoinColumn
    Patient person;


    @ManyToOne
    @JoinColumn
    Doctor doctor;

}