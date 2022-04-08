import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Put {

    ///without using JSon Object
    @Test
    public void putMethod(){
        given()
                .header("Content-TYpe","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/users/2")
                .then().assertThat().statusCode(200).log().all();
    }

    ///Using JSONObject
    @Test
    public void putMethod1(){

        JSONObject reference = new JSONObject();

        reference.put("name","morpheus");
        reference.put("job","zion resident");

        Response res = given()
                .header("Content-TYpe","application/json")
                .body(reference.toString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then().extract().response();

        System.out.println(res.body().asPrettyString());
    }
}
