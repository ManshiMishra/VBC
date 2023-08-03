package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.DTO.RequestDto.BookDose1ReqDto;
import com.example.VaccinationBookingSystem.Enum.DoseType;
import com.example.VaccinationBookingSystem.Exception.Dose1AlreadyTaken;
import com.example.VaccinationBookingSystem.Exception.PersonNotFoundException;
import com.example.VaccinationBookingSystem.model.Dose;
import com.example.VaccinationBookingSystem.model.Patient;
import com.example.VaccinationBookingSystem.repository.DoseRepository;
import com.example.VaccinationBookingSystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PersonRepository personRepository;

//    public Dose addDose1(int personId, DoseType doseType) {
//
//
//        Optional<Person> Optionalperson = personRepository.findById(personId);
//
//        // check if person exists or not
//
//        if(!Optionalperson.isPresent()){
//
//             throw new PersonNotfoundException("Invalid Person");
//        }
//
//        Person person = Optionalperson.get();
//
//         // check the person istakendose1 or not
//
//        if(person.getIsDose1Taken()){
//
//            throw new Dose1AlreadyTaken("Person already taken dose1");
//        }
//
//        // create a dose
//
//        Dose dose = new Dose();
//
//        dose.setDoseId(String.valueOf(UUID.randomUUID()));
//
//        dose.setDoseType(doseType);
//
//        dose.setPerson(person);
//
//        person.setIsDose1Taken(true);
//
//        person.getDoseTaken().add(dose);
//
//        Person savedPerson = personRepository.save(person);
//
//         return dose;
//
//
//    }


    public Dose addDose1(BookDose1ReqDto bookDose1ReqDto) {


        Optional<Patient> Optionalperson = personRepository.findById(bookDose1ReqDto.getPersonId());

        // check if person exists or not

        if(!Optionalperson.isPresent()){

            throw new PersonNotFoundException("Invalid Person");
        }

        Patient person = Optionalperson.get();

        // check the person istakendose1 or not

        if(person.getIsDose1Taken()){

            throw new Dose1AlreadyTaken("Person already taken dose1");
        }

        // create a dose

        Dose dose = new Dose();

        dose.setDoseId(String.valueOf(UUID.randomUUID()));

        dose.setDoseType(bookDose1ReqDto.getDoseType());

        dose.setPerson(person);

        person.setIsDose1Taken(true);

        person.getDoseTaken().add(dose);

        Patient savedPerson = personRepository.save(person);

        return savedPerson.getDoseTaken().get(0);


    }
}
