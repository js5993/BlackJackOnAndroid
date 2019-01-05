package com.example.junhosung.blackjackonandroid.models;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> hand = new ArrayList<>();

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

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
