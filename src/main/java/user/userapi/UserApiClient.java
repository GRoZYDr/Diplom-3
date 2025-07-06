package user.userapi;

import baseconfig.BaseHTTPClient;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import user.usermodel.UserEditModel;
import user.usermodel.UserLoginModel;
import user.usermodel.UserRegistrationModel;

public class UserApiClient extends BaseHTTPClient {
    private final String apiBasePath = "/auth";
    private final String apiPathRegister = "/register";
    private final String apiPathLogin = "/login";
    private final String apiPathLogout = "/logout";
    private final String apiPathDelete = "/user";
    private final String apiPathPatch = "/user";


    @Step("Создание пользователя")
    public Response registerNewUser(UserRegistrationModel userRegistrationModel) {
        return doPostRequest(apiBasePath + apiPathRegister, userRegistrationModel);
    }

    @Step("Авторизация пользователя")
    public Response loginUser(UserLoginModel userLoginModel) {
        return doPostRequest(apiBasePath + apiPathLogin, userLoginModel);
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String accessToken) {
        return doDeleteRequest(apiBasePath + apiPathDelete, accessToken);
    }

    @Step("Получение accessToken пользователя")
    public String getAccessTokenUser(Response response) {
        return response.getHeader("Authorization").replace("Bearer ", "").trim();
    }

    @Step("Получение refreshToken пользователя")
    public String getRefreshTokenUser(Response response) {
        return response.jsonPath().getString("refreshToken");
    }

    @Step("Изменение авторизованного пользователя")
    public Response editUser(UserEditModel userModifyModel, String accessToken) {
        return doPatchRequest(apiBasePath + apiPathPatch, userModifyModel, accessToken);
    }

    @Step("Изменение неавторизованного пользователя")
    public Response editUser(UserEditModel userModifyModel) {
        return doPatchRequest(apiBasePath + apiPathPatch, userModifyModel);
    }
}
