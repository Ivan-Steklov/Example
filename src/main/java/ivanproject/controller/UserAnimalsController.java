package ivanproject.controller;

import ivanproject.model.UserAnimalsResponse;
import ivanproject.service.UserAnimalsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAnimalsController {

    private final UserAnimalsService userAnimalsService;

    @Autowired
    public UserAnimalsController(UserAnimalsService userAnimalsService) {
        this.userAnimalsService = userAnimalsService;
    }

    @Operation(summary = "Get user animals, clinics where they can be treated, cars, car services where they can be repaired, and job information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(schema = @Schema(implementation = UserAnimalsResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid user ID supplied"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/user-animals-and-cars")
    public UserAnimalsResponse getUserAnimalsAndCarsById(
            @Parameter(description = "ID of the user to be queried") @RequestParam Long userId) {
        return userAnimalsService.getUserAnimalsAndCarsById(userId);
    }
}



