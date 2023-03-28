package orgg;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class unresting {
  //  @Test
    void name() {
        String url = "https://jsonplaceholder.typicode.com/todos/1";

        Response response = RestAssured.given().accept("application/json").get(url);

        System.out.println(response.getStatusCode());
        System.out.println(response.asPrettyString());

        System.out.println(response.getContentType());

        System.out.println(response.body().asString());

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertTrue(response.body().asString().contains("autem"));

    }

    @Test
    void name01() {
        RestAssured.baseURI = "https://official-joke-api.appspot.com/random_joke";

        Response response = RestAssured.get();
        System.out.println(response.getStatusCode());
        System.out.println(response.contentType());
        System.out.println(response.headers().hasHeaderWithName("Date"));
        System.out.println(response.header("Date"));
        System.out.println(response.header("content-length"));
        System.out.println(response.body().asPrettyString());
    }
}
