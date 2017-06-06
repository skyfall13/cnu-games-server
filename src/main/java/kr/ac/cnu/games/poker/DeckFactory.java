package kr.ac.cnu.games.poker;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rokim on 2017. 6. 4..
 */
@Component
public class DeckFactory {
    public Deck getDeck() {
        List<Card> cardList = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = 1 ; i < 14; i++) {
                Card card = new Card(i, suit);
                cardList.add(card);
            }
        }

        Collections.shuffle(cardList);

        Deck deck = new Deck(cardList);
        return deck;
    }
}
