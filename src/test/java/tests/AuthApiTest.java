package tests;

import model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.LoginSpec.*;

@Tag("Lombok")
public class AuthApiTest {


    @Tag("positive")
    @DisplayName("Login-Successful")
    @Test
    void loginSuccessful() {
        LoginBodyModel data = new LoginBodyModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("pistol");

        LoginCorrectResponceModel response = step("Data entry", () ->
                given(loginRequestSpec)
                        .body(data)
                        .when()
                        .post("/login")
                        .then()
                        .spec(loginResponseSpecCorrect)
                        .extract().as(LoginCorrectResponceModel.class));

        step("Checking token is not null", () -> {
            assertThat(response.getToken()).isNotNull();
        });
    }

    @Tag("negative")
    @DisplayName("Login-Unsuccessful")
    @Test
    void loginUnsuccessful() {
        LoginBodyModel data = new LoginBodyModel();
        data.setEmail("peter@klaven");


        LoginErrorResponseModel response = step("Data entry", () ->
                given(loginRequestSpec)
                        .body(data)
                        .when()
                        .post("/login")
                        .then()
                        .spec(loginResponseSpecError)
                        .extract().as(LoginErrorResponseModel.class));

        step("Error checking", () -> {
            assertThat(response.getError()).isEqualTo("Missing password");
        });
    }


}
