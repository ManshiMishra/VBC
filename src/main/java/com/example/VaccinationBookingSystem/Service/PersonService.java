package com.example.VaccinationBookingSystem.Service;


import com.example.VaccinationBookingSystem.DTO.RequestDto.AddPersonReqDto;
import com.example.VaccinationBookingSystem.DTO.ResponseDto.AddPersonResDto;
import com.example.VaccinationBookingSystem.Enum.Gender;
import com.example.VaccinationBookingSystem.Exception.EmptyListException;
import com.example.VaccinationBookingSystem.Exception.PersonNotFoundException;
import com.example.VaccinationBookingSystem.model.Patient;
import com.example.VaccinationBookingSystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {


    @Autowired
    PersonRepository personRepository;


    public AddPersonResDto addPerson(AddPersonReqDto addPersonReqDto) {


        // convert req dto to entitiy

        Patient person = new Patient();

        person.setName(addPersonReqDto.getName());
        person.setEmailId(addPersonReqDto.getEmailId());
        person.setGender(addPersonReqDto.getGender());
        person.setAge(addPersonReqDto.getAge());
        person.setIsDose1Taken(false);
        person.setIsDose2Taken(false);
        person.setCertificate(null);


        Patient savedPerson = personRepository.save(person);

        AddPersonResDto addPersonResDto = new AddPersonResDto();
        addPersonResDto.setMessage("Congrats! you have been registered");
        addPersonResDto.setName(savedPerson.getName());
        return addPersonResDto;

    }

    public String updateEmailid(String oldemail, String newmail) {


        Patient person  = personRepository.findByEmailId(oldemail);

         if(person == null) {
             throw new PersonNotFoundException("Sorry!,This peson is not exists");
         }

          person.setEmailId(newmail);

         personRepository.save(person);


         return "Congratulations! email has been updated";

    }

    public List<String> getAllPersonAgeGreaterThan(int age) {


          List<Patient> personList  = personRepository.getPersonGreaterThan(age);

          if(personList.size()==0){
              throw new EmptyListException("The List is Empty");
          }

           List<String> list = new ArrayList<>();

           for(Patient person: personList){

                 if(person.getAge()>age){

                       list.add(person.getName());

                 }
           }

            return list;
    }

    public List<String> getAllFemalesWhoHaveTakendose1NotDose2() {


        List<Patient> personList = personRepository.getAllFemalesWhoHaveTakendose1NotDose2();

        if (personList.size()==0) throw new EmptyListException("List is empty");

        List<String> femalelist = new ArrayList<>();

         for(Patient person : personList){

                if(person.getGender()== Gender.FEMALE){
                    femalelist.add(person.getName());
                }
         }

         return  femalelist;
    }

    public List<String> getPeopleFullyVaccinated() {


        List<Patient> personList = personRepository.getPepleFullyVaccinated();

        if(personList.size()==0){
             throw new EmptyListException("List is empty");
        }

        List<String> list = new ArrayList<>();

          for(Patient person : personList){

               list.add(person.getName());

          }

          return list;
    }

    public List<String> getAllPeopleNotTakenSingleDose() {



           List<Patient> personList = personRepository.getAllPeopleNotTakenSingleDose();

           List<String> list = new ArrayList<>();

        for(Patient person : personList){

            list.add(person.getName());
        }

        return list;


    }

    public List<String> getAllFemaleAgeGreaterThanandTakenDose1(int age) {


          List<Patient> personList = personRepository.getAllFemaleAgeGreaterThanandTakenDose1(age);


        if (personList.size()==0) throw new EmptyListException("List is empty");

        List<String> femalelist = new ArrayList<>();

        for(Patient person : personList){

            if(person.getGender()== Gender.FEMALE){
                femalelist.add(person.getName());
            }
        }

        return  femalelist;

    }

    public List<String> getAllMaleAgeGreaterThanNoDose(int age) {


        List<Patient> personList = personRepository.getAllMaleAgeGreaterThanNoDose(age);

        if (personList.size()==0) throw new EmptyListException("List is empty");

        List<String> malelist = new ArrayList<>();

        for(Patient person : personList){

            if(person.getGender()== Gender.MALE){
                malelist.add(person.getName());
            }
        }

        return  malelist;


    }
}



