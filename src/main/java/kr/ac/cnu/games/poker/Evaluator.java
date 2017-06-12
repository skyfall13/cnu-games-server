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

    public int evalauteHandsType(Hands myHands,Hands otherHands){

        if(!myHands.getHandsType().equals(otherHands.getHandsType())) {
            return myHands.getHandsType().ordinal() - otherHands.getHandsType().ordinal(); // 양수면 내가이긴다
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
