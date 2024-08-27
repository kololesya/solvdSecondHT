package entities.service;

import entities.vehicle.Car;

import java.time.LocalDate;

public abstract class Service {
        private String serviceId;
        private LocalDate serviceDate;
        private Car car;

        public Service(String serviceId, LocalDate serviceDate, Car car) {
            this.serviceId = serviceId;
            this.serviceDate = serviceDate;
            this.car = car;
        }

        public abstract double calculateCost();

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public LocalDate getServiceDate() {
            return serviceDate;
        }

        public void setServiceDate(LocalDate serviceDate) {
            this.serviceDate = serviceDate;
        }

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

}
