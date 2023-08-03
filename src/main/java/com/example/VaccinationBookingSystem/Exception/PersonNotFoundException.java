package com.example.VaccinationBookingSystem.Exception;

    public class PersonNotFoundException extends RuntimeException {
        public PersonNotFoundException(String invalidPerson) {

            super(invalidPerson);

        }
    }

