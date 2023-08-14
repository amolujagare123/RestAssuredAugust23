package DeckOfCards;


import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class ShuffleCards {

    @BeforeClass
    public static void setBaseUrl()
    {
        baseURI = "https://deckofcardsapi.com";
    }
    @Test
    public void shuffleCardsTest()
    {


        given().log().all().queryParam("deck_count","1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all()
                .statusCode(200)
              //  .header("Connection", Matchers.equalTo("keep-alive"))
                .body("remaining",equalTo(102))
                .body("shuffled",equalTo(false));
}

    @Test
    public void drawCards() // vupqq1axqxgv
    {
        given().log().all().queryParam("count","2")
                .when().get("/api/deck/vupqq1axqxgv/draw/")
                .then().log().all().assertThat().statusCode(200);
    }

}
