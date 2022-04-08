import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Post{

    ////without using the JsonObject
    @Test
    public void postMethod(){
        given()
                .header("Content-TYpe","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/users")
                .then().log().all();
    }


    /////This is Using the JSONObject
    @Test
    public void postMethod1(){

        JSONObject reference = new JSONObject();

        reference.put("name","morpheus");
        reference.put("job","leader");

        Response res = given()
                .header("Content-TYpe","application/json")
                .body(reference.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then().extract().response();

        System.out.println(res.body().asPrettyString());

    }

}