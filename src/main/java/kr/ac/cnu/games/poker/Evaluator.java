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

    public int evalauteHandsType(Hands myHands,Hands otherHands) {

        if (!myHands.getHandsType().equals(otherHands.getHandsType())) {
            return myHands.getHandsType().ordinal() - otherHands.getHandsType().ordinal(); // 양수면 내가이긴다
        } else {
            LowCardComparator lowComp = new LowCardComparator();
            Collections.sort(myHands.getCardList(), lowComp);
            Collections.sort(otherHands.getCardList(), lowComp);

            Iterator<Card> myCard = myHands.getCardList().iterator();
            Iterator<Card> otherCard = otherHands.getCardList().iterator();
            int comp;
            List<Card> myTempList = new ArrayList<>();
            List<Card> otherTempList = new ArrayList<>();
            switch (myHands.getHandsType()) {
                case STRIGHT_FLUSH:
                    myCard = myHands.getCardList().iterator();
                    otherCard = otherHands.getCardList().iterator();

                    while (myCard.hasNext() && otherCard.hasNext()) {
                        int temp = lowComp.compare(myCard.next(), otherCard.next());
                        if (temp != 0)
                            return temp;
                    }
                    break;
                case FOUR_CARD:
                case FULL_HOUSE:
                case FLUSH:
                case STRIGHT:
                case THREE_CARD:
                case TWO_PAIR:

                    return 0;
                case ONE_PAIR:
                    Card card1 = myCard.next();
                    Card card2;
                    Card card3 = otherCard.next();
                    while (myCard.hasNext()) {
                        card2 = myCard.next();
                        if (card1.getNumber() - card2.getNumber() != 0) {
                            myTempList.add(card1);
                            card1 = card2;
                            continue;
                        } else {        // card1 과 card2가 같을 때
                            while(myCard.hasNext()) {
                                myTempList.add(myCard.next());
                            }
                            break;
                        }
                    }
                    while (otherCard.hasNext()) {
                        card2 = otherCard.next();
                        if (card3.getNumber() - card2.getNumber() != 0) {
                            otherTempList.add(card3);
                            card3 = card2;
                            continue;
                        } else {
                            while(otherCard.hasNext()) {
                                otherTempList.add(otherCard.next());
                            }
                            break;
                        }
                    }
                    if (lowComp.compare(card1, card3, 1) == 0 ) {
                        int result;
                        int i= 0;
                        while(i < 3) {
                            if((result = lowComp.compare(myTempList.get(i),otherTempList.get(i), 1)) != 0) {
                                return result;
                            }
                            i++;
                        }
                        return lowComp.compare(card1,card3);
                    }
                case NOTHING:
                    while (myCard.hasNext()) {
                        if ((comp = lowComp.compare(myCard.next(), otherCard.next(), 1)) == 0) {
                            continue;
                        } else {
                            return comp;
                        }
                    }
                    return myHands.getCardList().get(0).getSuit().compareTo(otherHands.getCardList().get(0).getSuit());
                default:
            }
        }
        return 0;
    }

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


//    TODO
//    sort함수 및 compare

}
