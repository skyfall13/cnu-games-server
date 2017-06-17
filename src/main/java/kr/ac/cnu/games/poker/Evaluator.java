package kr.ac.cnu.games.poker;

import org.springframework.stereotype.Component;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by rokim on 2017. 6. 4..
 */
@Component
public class Evaluator {
    public List<Hands> evalauteHighHands(List<Hands> handsList) {
        // do Something
        return null;
    }
    // 족보를 내림차순 정렬
    public List<Hands> evalauteLowHands(List<Hands> handsList) {
        // do Something
        Comparator<Hands> sort = new Comparator<Hands>() {
            public int compare(Hands o1, Hands o2) {
                return (o2.getHandsType().compareTo(o1.getHandsType()));
            }
        };
        Collections.sort(handsList, sort);

        return handsList;
    }


    public int evaluateLowHandsRanks(Hands myHands, Hands otherHands){

        return 0;
    }
    
    public int evalauteHandsType(Hands myHands,Hands otherHands){

        if(!myHands.getHandsType().equals(otherHands.getHandsType())) {
            return myHands.getHandsType().ordinal() - otherHands.getHandsType().ordinal(); // 양수면 내가이긴다
        } else {
            Comparator<Card> sort = new Comparator<Card>() {
                public int compare(Card o1, Card o2) {
                    return (o2.getNumber() - o1.getNumber());
                }
            };
            Collections.sort(myHands.getCardList(), sort);
            Collections.sort(otherHands.getCardList(), sort);
            LowCardComparator lowComp = new LowCardComparator();

            switch (myHands.getHandsType()){
                case STRIGHT_FLUSH:
                    Iterator<Card> myCard = myHands.getCardList().iterator();
                    Iterator<Card> otherCard = otherHands.getCardList().iterator();

                    while(myCard.hasNext() && otherCard.hasNext()){
                        int temp = lowComp.compare(myCard.next(), otherCard.next());
                        if(temp != 0)
                            return temp;
                    }
                    break;
                case FOUR_CARD:
                case FULL_HOUSE:
                case FLUSH:
                case STRIGHT:
                case THREE_CARD:
                case TWO_PAIR:
                case ONE_PAIR:
                case NOTHING:
                default:
            }
        }
        return 0;

//        LowCardComparator lowCardComp = new LowCardComparator();
//
//        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
//        Map<Integer, Integer> otherMap = new HashMap<Integer, Integer>();
//
//        for (Card card : myHands.getCardList()) {
//            if (myMap.containsKey(card.getNumber())) {
//                Integer count = myMap.get(card.getNumber());
//                count = new Integer(count.intValue() + 1);
//                myMap.put(card.getNumber(), count);
//            } else {
//                myMap.put(card.getNumber(), new Integer(1));
//            }
//        }
//
//        for (Card card : otherHands.getCardList()) {
//            if (myMap.containsKey(card.getNumber())) {
//                Integer count = otherMap.get(card.getNumber());
//                count = new Integer(count.intValue() + 1);
//                otherMap.put(card.getNumber(), count);
//            } else {
//                otherMap.put(card.getNumber(), new Integer(1));
//            }
//        }

    }

//    TODO
//    sort함수 및 compare

}
