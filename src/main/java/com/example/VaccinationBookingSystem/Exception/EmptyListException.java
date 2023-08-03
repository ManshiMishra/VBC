package com.example.VaccinationBookingSystem.Exception;

    public class EmptyListException extends RuntimeException {
        public EmptyListException(String theListIsEmpty) {

            super(theListIsEmpty);
        }
}
