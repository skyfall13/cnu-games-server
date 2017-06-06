package kr.ac.cnu.games.poker;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rokim on 2017. 6. 4..
 */
public class DeckFactoryTest {
    private DeckFactory deckFactory;

    @Before
    public void setUp() {
        deckFactory = new DeckFactory();
    }

    @Test
    public void shuffleCard() {
        Deck deck = deckFactory.getDeck();

        assertThat(deck.getCardList().size(), is(52));
    }
}