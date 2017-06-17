package kr.ac.cnu.games.poker;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by rokim on 2017. 6. 4..
 */
public class EvaluatorTest {
    private Evaluator evaluator;

    @Before
    public void setUp() {
        evaluator = new Evaluator();
    }

    // <!-- High CARD 테스트
    @Ignore
    @Test
    public void evaluateHighCard1() {
        List<Hands> handsList = new ArrayList<>();
        handsList.add(getStright());
        handsList.add(getFlush());

        List<Hands> resultList = evaluator.evalauteHighHands(handsList);

        assertThat(resultList.get(0).getHandsType(), is(HandsType.FLUSH));
        assertThat(resultList.get(1).getHandsType(), is(HandsType.STRIGHT));
    }

    // TODO 각 HandsType 에 맞춰 ordering 이 잘 되는지 확인
    // TODO HandsType 이 같을때 가장 높은 숫자로 odering 이 되는지 확인.


    // High CARD 테스트 -->



    // <!-- Low CARD 테스트
    @Test
    public void evaluateLowCard1() {
        List<Hands> handsList = new ArrayList<>();
        handsList.add(getStright());
        handsList.add(getFlush());

        List<Hands> resultList = evaluator.evalauteLowHands(handsList);
        System.out.print(handsList);
        assertThat(resultList.get(0).getHandsType(), is(HandsType.STRIGHT));
        assertThat(resultList.get(1).getHandsType(), is(HandsType.FLUSH));

    }

    // TODO 각 HandsType 에 맞춰 ordering 이 잘 되는지 확인
    // TODO HandsType 이 같을때 가장 낮은 숫자로 odering 이 되는지 확인.
    @Test
    public void 핸드_타입이_다를때_족보가_낮으면_이긴다(){
        Hands myHands= getStright();
        Hands otherHands = getFlush();

        int result = evaluator.evalauteHandsType(myHands, otherHands);
        assertThat(result, is(1));
    }

    @Test
    public void extractorLowHands_같은_원페어의_경우_후속_NUMBER_비교(){
        //given
       Hands myHands = getOnePair1();
       Hands otherHans = getOnePair2();

       int result = evaluator.evalauteHandsType(myHands, otherHans);
       assertThat(result, is (-2));
    }

    @Test
    public void extractorLowHands_NUMBER같은_원페어의_경우_후속_문양_비교(){
        //given
        Hands myHands = getOnePair2();
        Hands otherHans = getOnePair3();

        //int result = evaluator.evalauteHandsType(myHands, otherHans);
        //assertThat(result, is (-2));
    }
    // Low CARD 테스트 -->

    // Givens
    private Hands getFlush() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(2, Suit.CLUBS));
        cardList.add(new Card(5, Suit.CLUBS));
        cardList.add(new Card(6, Suit.CLUBS));
        cardList.add(new Card(7, Suit.CLUBS));

        return new Hands(HandsType.FLUSH, cardList);
    }

    private Hands getStright() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(2, Suit.DIAMONDS));
        cardList.add(new Card(5, Suit.CLUBS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(4, Suit.CLUBS));

        return new Hands(HandsType.STRIGHT, cardList);
    }

    private Hands getOnePair1() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(2, Suit.SPADES));
        cardList.add(new Card(2, Suit.HEARTS));
        cardList.add(new Card(5, Suit.HEARTS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(4, Suit.CLUBS));

        return new Hands(HandsType.ONE_PAIR, cardList);
    }

    private Hands getOnePair2() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(2, Suit.CLUBS));
        cardList.add(new Card(2, Suit.DIAMONDS));
        cardList.add(new Card(5, Suit.CLUBS));
        cardList.add(new Card(7, Suit.DIAMONDS));
        cardList.add(new Card(4, Suit.CLUBS));

        return new Hands(HandsType.ONE_PAIR, cardList);
    }

    private Hands getOnePair3() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(2, Suit.SPADES));
        cardList.add(new Card(2, Suit.HEARTS));
        cardList.add(new Card(5, Suit.SPADES));
        cardList.add(new Card(7, Suit.HEARTS));
        cardList.add(new Card(4, Suit.HEARTS));

        return new Hands(HandsType.ONE_PAIR, cardList);
    }

    private Hands getTwoPair() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(2, Suit.CLUBS));
        cardList.add(new Card(2, Suit.DIAMONDS));
        cardList.add(new Card(5, Suit.SPADES));
        cardList.add(new Card(5, Suit.DIAMONDS));
        cardList.add(new Card(4, Suit.CLUBS));

        return new Hands(HandsType.TWO_PAIR, cardList);
    }

    private Hands getTwoPair2() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(2, Suit.SPADES));
        cardList.add(new Card(2, Suit.HEARTS));
        cardList.add(new Card(5, Suit.CLUBS));
        cardList.add(new Card(5, Suit.HEARTS));
        cardList.add(new Card(4, Suit.DIAMONDS));

        return new Hands(HandsType.TWO_PAIR, cardList);
    }

    private Hands getTripple() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(3, Suit.SPADES));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(3, Suit.CLUBS));
        cardList.add(new Card(5, Suit.SPADES));
        cardList.add(new Card(4, Suit.CLUBS));

        return new Hands(HandsType.THREE_CARD, cardList);
    }

    private Hands getTripple2() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(5, Suit.SPADES));
        cardList.add(new Card(6, Suit.HEARTS));
        cardList.add(new Card(5, Suit.CLUBS));
        cardList.add(new Card(5, Suit.DIAMONDS));
        cardList.add(new Card(4, Suit.CLUBS));

        return new Hands(HandsType.THREE_CARD, cardList);
    }

    private Hands getFullHouse() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(3, Suit.SPADES));
        cardList.add(new Card(4, Suit.HEARTS));
        cardList.add(new Card(3, Suit.CLUBS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(4, Suit.CLUBS));

        return new Hands(HandsType.FULL_HOUSE, cardList);
    }

    private Hands getFullHouse2() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.SPADES));
        cardList.add(new Card(5, Suit.HEARTS));
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(1, Suit.HEARTS));
        cardList.add(new Card(5, Suit.CLUBS));

        return new Hands(HandsType.FULL_HOUSE, cardList);
    }

    private Hands getFourCard() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.SPADES));
        cardList.add(new Card(1, Suit.DIAMONDS));
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(1, Suit.HEARTS));
        cardList.add(new Card(5, Suit.CLUBS));

        return new Hands(HandsType.FOUR_CARD, cardList);
    }

    private Hands getFourCard2() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(13, Suit.SPADES));
        cardList.add(new Card(13, Suit.DIAMONDS));
        cardList.add(new Card(13, Suit.CLUBS));
        cardList.add(new Card(13, Suit.HEARTS));
        cardList.add(new Card(7, Suit.DIAMONDS));

        return new Hands(HandsType.FOUR_CARD, cardList);
    }

    private Hands getStrightFlash() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.HEARTS));
        cardList.add(new Card(2, Suit.HEARTS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(4, Suit.HEARTS));
        cardList.add(new Card(5, Suit.HEARTS));

        return new Hands(HandsType.STRIGHT_FLUSH, cardList);
    }

    private Hands getStrightFlash2() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(5, Suit.CLUBS));
        cardList.add(new Card(4, Suit.CLUBS));
        cardList.add(new Card(2, Suit.CLUBS));
        cardList.add(new Card(3, Suit.CLUBS));

        return new Hands(HandsType.STRIGHT_FLUSH, cardList);
    }

    private Hands getStrightFlash3() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(12, Suit.CLUBS));
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(10, Suit.CLUBS));
        cardList.add(new Card(13, Suit.CLUBS));
        cardList.add(new Card(11, Suit.CLUBS));

        return new Hands(HandsType.STRIGHT_FLUSH, cardList);
    }

    private Hands getNoting() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.SPADES));
        cardList.add(new Card(3, Suit.CLUBS));
        cardList.add(new Card(7, Suit.HEARTS));
        cardList.add(new Card(8, Suit.CLUBS));
        cardList.add(new Card(9, Suit.DIAMONDS));

        return new Hands(HandsType.NOTHING, cardList);
    }
    private Hands getNoting2() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.DIAMONDS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(7, Suit.SPADES));
        cardList.add(new Card(8, Suit.SPADES));
        cardList.add(new Card(9, Suit.CLUBS));

        return new Hands(HandsType.NOTHING, cardList);
    }

    private Hands getNoting3() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.DIAMONDS));
        cardList.add(new Card(2, Suit.HEARTS));
        cardList.add(new Card(7, Suit.SPADES));
        cardList.add(new Card(10, Suit.SPADES));
        cardList.add(new Card(9, Suit.SPADES));

        return new Hands(HandsType.NOTHING, cardList);
    }

    private Hands getNoting4() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.DIAMONDS));
        cardList.add(new Card(2, Suit.HEARTS));
        cardList.add(new Card(7, Suit.DIAMONDS));
        cardList.add(new Card(9, Suit.DIAMONDS));
        cardList.add(new Card(10, Suit.HEARTS));

        return new Hands(HandsType.NOTHING, cardList);
    }
}
