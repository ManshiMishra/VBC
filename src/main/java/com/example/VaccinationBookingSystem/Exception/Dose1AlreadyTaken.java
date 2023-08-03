package com.example.VaccinationBookingSystem.Exception;

    public class Dose1AlreadyTaken extends RuntimeException {
        public Dose1AlreadyTaken(String personAlreadyTakenDose1) {

            super(personAlreadyTakenDose1);
        }
    }
