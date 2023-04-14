package tests;

import static io.qameta.allure.Allure.step;
import static specs.CreateUserSpecs.createUserRequestSpec;
import static specs.CreateUserSpecs.createUserResponseSpec;
import static specs.DeleteUserSpecs.deletedUserRequestSpec;
import static specs.DeleteUserSpecs.deletedUserResponseSpec;
import static specs.ListUserSpecs.listUserRequestSpec;
import static specs.ListUserSpecs.listUserResponseSpec;
import static specs.LoginSpec.loginRequestSpec;
import static specs.LoginSpec.loginResponseSpec;
import static specs.UpdateUserSpec.updatedUserRequestSpec;
import static specs.UpdateUserSpec.updatedUserResponseSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Lombok")
public class ReqresInLombokTest {
  @Tag("positive")
  @DisplayName("Checking the name and position when creating a user")
  @Test
  void createUser() {

    UserBodyModel data = new UserBodyModel();
    data.setName("morpheus");
    data.setJob("leader");

    CreateUserResponseModel response = step("Data entry", () ->
        given(createUserRequestSpec)
            .body(data)
            .when()
            .post("/users")
            .then()
            .spec(createUserResponseSpec)
            .extract().as(CreateUserResponseModel.class));

    step("Checking the input data", () -> {
      assertThat(response.getName()).isEqualTo("morpheus");
      assertThat(response.getJob()).isEqualTo("leader");
    });
  }
  @Tag("positive")
  @DisplayName("Checking the number of all users")
  @Test
  void getUsers() {
    ListUserModel response = step("Viewing all users", () ->
        given(listUserRequestSpec)
            .when()
            .get("/users?page=2")
            .then()
            .spec(listUserResponseSpec)
            .extract().as(ListUserModel.class));

    step("Checking the number of all users", () -> {
      assertThat(response.getTotal()).isEqualTo(12);
    });
  }
  @Tag("positive")
  @DisplayName("Editing the user's place of work")
  @Test
  void editUser() {
    String dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
    UserBodyModel data = new UserBodyModel();
    data.setName("morpheus");
    data.setJob("zion resident");

    UpdateUserResponseModel response = step("Data entry", () ->
        given(updatedUserRequestSpec)
            .when()
            .patch("/users/2")
            .then()
            .spec(updatedUserResponseSpec)
            .extract().as(UpdateUserResponseModel.class));

    step("Checking that the place of work has been edited", () -> {
      assertThat(response.getUpdatedAt()).contains(dateTime);
    });
  }
  @Tag("positive")
  @DisplayName("Deleting a user")
  @Test
  void deleteUser() {
    step("Deleting a user", () -> {
      given(deletedUserRequestSpec)
          .when()
          .delete("/users/2")
          .then()
          .spec(deletedUserResponseSpec);
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
            .spec(loginResponseSpec)
            .extract().as(LoginErrorResponseModel.class));

    step("Error checking", () -> {
      assertThat(response.getError()).isEqualTo("Missing password");
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
                    .spec(loginResponseSpec)
                    .extract().as(RegisterErrorResponseModel.class));

    step("Error checking", () -> {
      assertThat(response.getError()).isEqualTo("Missing password");
    });
  }
}

