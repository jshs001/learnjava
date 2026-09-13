package com.collection.jh4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    private List<Card> allCards = new ArrayList<>();

    public Room () {
        // 做出54张牌存入allCards集合中
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♠", "♥", "♣", "♦"};
        int size = 0;
        for (String number : numbers) {
            size++;
            for (String color : colors) {
                allCards.add(new Card(number, color, size));
            }
        }
        allCards.add(new Card("", "Small", size++));
        allCards.add(new Card("", "Big", size++));
        System.out.println("新牌："+allCards);


    }

    public void start() {
        // 1 洗牌
        Collections.shuffle(allCards);
        System.out.println("洗牌后："+allCards);

        // 2 发牌
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player3 = new ArrayList<>();
        List<Card> dipai = new ArrayList<>();
        for (int i = 0; i < allCards.size() - 3; i++) {
            if (i % 3 == 0) {
                player1.add(allCards.get(i));
            } else if (i % 3 == 1) {
                player2.add(allCards.get(i));
            } else if (i % 3 == 2) {
                player3.add(allCards.get(i));
            }
        }
        dipai = allCards.subList(allCards.size() - 3, allCards.size());

        // 3 对三个玩家进行排序
        sortCards(player1);
        sortCards(player2);
        sortCards(player3);
        // 4 看牌
        System.out.println("玩家1："+player1);
        System.out.println("玩家2："+player2);
        System.out.println("玩家3："+player3);
        System.out.println("底牌："+dipai);
        player2.addAll(dipai);
        sortCards(player2);
        System.out.println("地主："+player2);
    }

    private void sortCards(List<Card> cards) {
        cards.sort((c1, c2) -> c1.getSize() - c2.getSize());
        System.out.println("排序后："+cards);
    }
}
