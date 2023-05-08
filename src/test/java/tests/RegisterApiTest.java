package tests;

import model.LoginBodyModel;
import model.RegisterCorrectResponseModel;
import model.RegisterErrorResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.LoginSpec.*;
@Tag("Lombok")
public class RegisterApiTest {
    @Tag("positive")
    @DisplayName("Register-Successful")
    @Test
    void registerSuccessful() {

        String email = "eve.holt@reqres.in";
        String password = "pistol";
        LoginBodyModel data = new LoginBodyModel();
        data.setEmail(email);
        data.setPassword(password);

        RegisterCorrectResponseModel response = step("Data entry", () ->
                given(loginRequestSpec)
                        .body(data)
                        .when()
                        .post("/register")
                        .then()
                        .spec(loginResponseSpecCorrect)
                        .extract().as(RegisterCorrectResponseModel.class));

        step("Checking token is not null", () -> {
            assertThat(response.getId()).isEqualTo(4);
            assertThat(response.getToken()).isNotNull();
        });
    }

    @Tag("negative")
    @DisplayName("Register-Unsuccessful")
    @Test
    void registerUnsuccessful() {

        String email = "sydney@fife";
        LoginBodyModel data = new LoginBodyModel();
        data.setEmail(email);

        RegisterErrorResponseModel response = step("Data entry", () ->
                given(loginRequestSpec)
                        .body(data)
                        .when()
                        .post("/register")
                        .then()
                        .spec(loginResponseSpecError)
                        .extract().as(RegisterErrorResponseModel.class));

        step("Error checking", () -> {
            assertThat(response.getError()).isEqualTo("Missing password");
        });
    }
}
