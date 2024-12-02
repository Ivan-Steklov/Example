package ivanproject.model;

import java.util.List;

public class UserAnimalsResponse {

    private Long userId;
    private String userName;
    private List<VeterinaryClinicResponse> animals;
    private List<CarServiceResponse> cars;
    private JobResponse job;

    // Геттеры и сеттеры
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<VeterinaryClinicResponse> getAnimals() {
        return animals;
    }

    public void setAnimals(List<VeterinaryClinicResponse> animals) {
        this.animals = animals;
    }

    public List<CarServiceResponse> getCars() {
        return cars;
    }

    public void setCars(List<CarServiceResponse> cars) {
        this.cars = cars;
    }

    public JobResponse getJob() {
        return job;
    }

    public void setJob(JobResponse job) {
        this.job = job;
    }
}



