package kr.ac.cnu.games.poker;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * Created by rokim on 2017. 6. 4..
 */
@Data
public class Deck {
    private final List<Card> cardList;

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Card popCard() {
        if (cardList.size() == 0) {
            return null;
        }

        return cardList.remove(0);
    }
}
