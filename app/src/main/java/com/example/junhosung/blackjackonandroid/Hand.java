package com.example.junhosung.blackjackonandroid;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    public List<Card> hand = new ArrayList<>();

    public void addCard(Card card) {
        hand.add(card);
    }

    public int countCards() {
        return hand.size();

    }

    public int handValue() {
        int handValue = 0;
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            handValue += card.getCardValue();

        }

        return handValue;
    }

}
