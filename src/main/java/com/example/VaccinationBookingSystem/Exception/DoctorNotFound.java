package com.example.VaccinationBookingSystem.Exception;

    public class DoctorNotFound extends RuntimeException {
        public DoctorNotFound(String invalidDoctorReq) {

            super(invalidDoctorReq);
        }
    }
