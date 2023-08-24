package DeckOfCards.RESPPOJO;


import POJO.DeckOfCards.ShuffleCardsRespPOJO;
import POJO.DeckOfCards.drawCards.Cards;
import POJO.DeckOfCards.drawCards.DrawCardsRespPOJO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class ShuffleCards {

    @BeforeClass
    public static void setBaseUrl()
    {
        baseURI = "https://deckofcardsapi.com";
    }
    @Test
    public void shuffleCardsTest()
    {


        ShuffleCardsRespPOJO respObj = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all()
                .statusCode(200)
                .extract().as(ShuffleCardsRespPOJO.class);

        System.out.println("deckID="+respObj.getDeck_id());

        String deckID = respObj.getDeck_id();

        DrawCardsRespPOJO drawCardsResp = given().log().all().queryParam("count", "5")
                .when().get("/api/deck/" + deckID + "/draw")
                .then().log().all().assertThat().statusCode(200)
                .extract().as(DrawCardsRespPOJO.class);

        // print or get the cards Drawn
        // also print path od SVG image

        ArrayList<Cards> myCards = drawCardsResp.getCards();

        for (int i=0;i<myCards.size();i++)
        {
            String cardValue = myCards.get(i).getValue();
            String cardSuit = myCards.get(i).getSuit();

            System.out.println(cardValue+" "+cardSuit);

            // --------------  print path od SVG image -----
            System.out.println(myCards.get(i).getImages().getSvg());
        }


    }



}
