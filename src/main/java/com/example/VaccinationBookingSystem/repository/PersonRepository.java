package com.example.VaccinationBookingSystem.repository;


import com.example.VaccinationBookingSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Patient,Integer> {




    Patient findByEmailId(String oldemail);

//    List<Person> findByAgeAndName(int age, String name);

     @Query(value = "Select * from person where age > :age",nativeQuery = true)
    List<Patient> getPersonGreaterThan(int age);


     @Query(value ="select * from person where is_dose1taken = true and is_dose2taken=false", nativeQuery = true)
    List<Patient> getAllFemalesWhoHaveTakendose1NotDose2();

    @Query(value ="select * from person where is_dose1taken = true and is_dose2taken = true", nativeQuery = true)
    List<Patient> getPepleFullyVaccinated();


    @Query(value ="select * from person where is_dose1taken = false and is_dose2taken = false", nativeQuery = true)
    List<Patient> getAllPeopleNotTakenSingleDose();


    @Query(value ="select * from person where is_dose1taken = true and is_dose2taken=false and age>:age", nativeQuery = true)
    List<Patient> getAllFemaleAgeGreaterThanandTakenDose1(int age);



    @Query(value ="select * from person where is_dose1taken = true and is_dose2taken=true and age>:age", nativeQuery = true)
    List<Patient> getAllMaleAgeGreaterThanNoDose(int age);
}
