package orgg;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class unresting {

   // @Test
    void name() {
        baseURI    = "https://jsonplaceholder.typicode.com/todos";
        Response response = given()
                .accept("application/json")
                .accept(ContentType.JSON)
               // .pathParam("id",1)
             //   .get("/{id}");
                .queryParam("id","1")
                .get( );

        System.out.println(response.getStatusCode());
        System.out.println(response.asPrettyString());

        System.out.println(response.getContentType());

        System.out.println(response.body().asString());
        System.out.println(response.headers());

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertTrue(response.body().asString().contains("autem"));

    }

    //@Test
    void name01() {
        baseURI = "https://official-joke-api.appspot.com/random_joke";

        Response response = given().accept(ContentType.JSON).get();

        System.out.println(response.getStatusCode());
        System.out.println(response.contentType());
        System.out.println(response.headers().hasHeaderWithName("Date"));
        System.out.println(response.header("Date"));
        System.out.println(response.header("content-length"));
        System.out.println(response.body().asPrettyString());
    }

     @Test
    void name3() {
        baseURI = "https://official-joke-api.appspot.com/random_joke";
        Response response = get();
        System.out.println(response.asPrettyString());

        String s = response.path("setup");
        String ss = response.path("punchline");
        System.out.println(s);
        System.out.println(ss);

        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();


    }
}
