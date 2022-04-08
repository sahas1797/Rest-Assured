import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Get {

    @Test
    public void getMethod(){

        ///This is using only Java
        /*Response abc = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(abc.statusCode());*/

        ///This is using the BDD aproach
        Response abc = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then().extract().response();

        System.out.println(abc.body().asPrettyString());

    }

    @Test
    public void deleteMethod(){
        Response abc = given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then().extract().response();

        System.out.println(abc.statusCode());
        System.out.println(abc.body().asPrettyString());
    }
}
