import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WIreMockTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8011);

    @Test
    public void testMethod() {
        wireMockRule.stubFor(get(urlEqualTo("/api/users"))
                .willReturn(okJson("{}")));
//        https://reqres.in/api/users?page=2
        Response response = given()
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .extract().response();
        System.out.println(response.getBody().asString());
    }
}
