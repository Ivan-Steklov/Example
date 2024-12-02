package ivanproject.model;

import java.util.List;

public class CarServiceResponse {

    private Long id;
    private String name;
    private String address;
    private String brandServiced; // Марки автомобилей, которые обслуживаются
    private String carBrand;
    private List<CarServiceResponse> carServices;

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

    public String getBrandServiced() {
        return brandServiced;
    }

    public void setBrandServiced(String brandServiced) {
        this.brandServiced = brandServiced;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public List<CarServiceResponse> getCarServices() {
        return carServices;
    }

    public void setCarServices(List<CarServiceResponse> carServices) {
        this.carServices = carServices;
    }
}
