package ivanproject.service.impl;

import ivanproject.model.VeterinaryClinicResponse;
import ivanproject.model.ClinicResponse;
import ivanproject.model.UserAnimalsResponse;
import ivanproject.model.CarServiceResponse;
import ivanproject.model.JobResponse;
import ivanproject.service.UserAnimalsService;
import ivanproject.service.VeterinaryClinicService;
import ivanproject.service.CarServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAnimalsServiceImpl implements UserAnimalsService {

    private final JdbcTemplate jdbcTemplate;
    private final VeterinaryClinicService veterinaryClinicService;
    private final CarServiceService carServiceService;
    private final RestTemplate restTemplate;

    @Autowired
    public UserAnimalsServiceImpl(
            @Qualifier("mainJdbcTemplate") JdbcTemplate jdbcTemplate,
            VeterinaryClinicService veterinaryClinicService,
            CarServiceService carServiceService,
            RestTemplate restTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.veterinaryClinicService = veterinaryClinicService;
        this.carServiceService = carServiceService;
        this.restTemplate = restTemplate;
    }

    @Override
    public UserAnimalsResponse getUserAnimalsAndCarsById(Long userId) {
        String userQuery = "SELECT u.id, u.first_name, u.last_name FROM users u WHERE u.id = ?";
        String animalQuery = "SELECT a.type FROM animals a WHERE a.owner_id = ?";
        String carQuery = "SELECT c.brand FROM cars c WHERE c.owner_id = ?";

        UserAnimalsResponse userAnimalsResponse = new UserAnimalsResponse();
        List<VeterinaryClinicResponse> veterinaryClinicResponses = new ArrayList<>();
        List<CarServiceResponse> carServiceResponses = new ArrayList<>();

        // Получаем информацию о пользователе
        jdbcTemplate.query(userQuery, (rs) -> {
            userAnimalsResponse.setUserId(rs.getLong("id"));
            userAnimalsResponse.setUserName(rs.getString("first_name") + " " + rs.getString("last_name"));
        }, userId);

        // Получаем информацию о животных пользователя
        jdbcTemplate.query(animalQuery, (rs) -> {
            String animalType = rs.getString("type");
            List<ClinicResponse> clinics = veterinaryClinicService.getClinicsByTreatedAnimals(animalType);
            VeterinaryClinicResponse veterinaryClinicResponse = new VeterinaryClinicResponse();
            veterinaryClinicResponse.setAnimalType(animalType);
            veterinaryClinicResponse.setClinics(clinics);
            veterinaryClinicResponses.add(veterinaryClinicResponse);
        }, userId);

        // Получаем информацию о машинах пользователя
        jdbcTemplate.query(carQuery, (rs) -> {
            String carBrand = rs.getString("brand");
            List<CarServiceResponse> carServices = carServiceService.getCarServicesByBrand(carBrand);
            CarServiceResponse carServiceResponse = new CarServiceResponse();
            carServiceResponse.setCarBrand(carBrand);
            carServiceResponse.setCarServices(carServices);
            carServiceResponses.add(carServiceResponse);
        }, userId);

        // Получаем информацию о месте работы пользователя
        JobResponse jobResponse = getJobByUserId(userId);
        userAnimalsResponse.setJob(jobResponse);

        userAnimalsResponse.setAnimals(veterinaryClinicResponses);
        userAnimalsResponse.setCars(carServiceResponses);
        return userAnimalsResponse;
    }

    private JobResponse getJobByUserId(Long userId) {
        String url = "http://localhost:8081/api/jobs/" + userId;
        return restTemplate.getForObject(url, JobResponse.class);
    }
}


