package ivanproject.model;

public class ClinicResponse {


    private Long id;
    private String name;
    private String address;
    private String treatedAnimals; // Переименовано для соответствия стандартам Java Naming Conventions
    private String phoneNumber; // Переименовано для соответствия стандартам Java Naming Conventions
    private String email;
    private String website;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTreatedAnimals() {
        return treatedAnimals;
    }

    public void setTreatedAnimals(String treatedAnimals) {
        this.treatedAnimals = treatedAnimals;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}