# cnu-games-server


### Homework 
* Extractor
    ```
        cardList.add(new Card(1, Suit.HEARTS));
        cardList.add(new Card(6, Suit.HEARTS));
        cardList.add(new Card(7, Suit.HEARTS));
        cardList.add(new Card(8, Suit.HEARTS));
        cardList.add(new Card(9, Suit.HEARTS));
        cardList.add(new Card(10, Suit.DIAMONDS));
        cardList.add(new Card(11, Suit.DIAMONDS));
    ```
  * extractHighHands 5조 
    * 주어진 N개의 카드에 대해 가장 높은 조합을 가지는 5개의 카드를 추출해 내야 한다.
    * 위의 경우 FLUSH의 1,6,7,8,9 카드가 추출되어야 한다.
  * extractLowHands 6조
    * 주어진 N개의 카드에 대해 가장 낮은 조합을 가지는 5개의 카드를 추출해 내야 한다.
    * 위의 경우 NOTHING 의 1,6,7,8,10 이 되어야 한다.
* Evaluator
  * evalauteHighHands 15조
    * HandsType 에 맞춰 Ordering 이 잘 되는지 확인
    * HandsType 이 같을 경우 숫자 + 모양으로 판단해야 한다.
  * evalauteLowHands 13조
    * HandsType 에 맞춰 Ordering 이 잘 되는지 확인
    * HandsType 이 같을 경우 숫자 + 모양으로 판단해야 한다. 
* 고려해야할 사항
  * Ace 는 1과 14로 모두 사용될 수 있다.
  * 1,2,3,4,5 는, high에서는 mountin 바로 다음 족보로, low에서는 perpect로 사용될 수 있다.
  * Suit 의 순서는 스페이드, 다이아, 하트, 클로버 순서다.
  * 조커는 고려하지 않는다.
* 완료조건
  * 각 method 를 구현하고, Test code 를 만들어 각종 조건을 테스트 한다.
  * 마감은 6/9 24:00 까지로 정한다.
  * 일부 버그가 있거나 구현이 힘들 부분이 있을 경우, 주석으로 TODO를 마킹해 놓으면, 감점없이 다음 주차 숙제에 포함시킨다.
  * 작업이 완료되면 직접 merge 한다. Test 가 깨지지 않는 상황이라면 merge 의 횟수에 대한 제약은 없다.
