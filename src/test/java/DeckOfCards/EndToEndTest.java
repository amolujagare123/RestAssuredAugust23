package DeckOfCards;

import io.restassured.path.json.JsonPath;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class EndToEndTest {

    @BeforeClass
    public static void setBaseUrl()
    {
        baseURI = "https://deckofcardsapi.com";
    }
    @Test
    public void shuffleCardsTest() {

        String shuffleCardsReq = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then()/*.log().all()*/.assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println("ResponseString:\n"+shuffleCardsReq);

        JsonPath jp = new JsonPath(shuffleCardsReq) ;

        String deckID  = jp.get("deck_id");

        System.out.println("deckID=" + deckID);

        given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckID+"/draw")
                .then().log().all().assertThat().statusCode(200)
                .time(greaterThan(700l));

    }

}
