package POJO.DeckOfCards.drawCards;

import java.util.ArrayList;

public class DrawCardsRespPOJO {
    boolean success;
    String deck_id;
    int remaining;
    ArrayList<Cards> cards;

    public boolean isSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public int getRemaining() {
        return remaining;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }
}
