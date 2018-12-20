package com.example.junhosung.blackjackonandroid.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    public String[] suits = {"Clubs","Hearts","Diamonds","Spades"};
    public String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    public Integer[] values = {10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,10};
    public List<Card> deck = new ArrayList<>();

    public Deck() {

        for (int i = 0; i < suits.length; i++) {
            int counter = 1;
            for (int j = 0; j < ranks.length; j++) {
                Card card = new Card(suits[i],ranks[j],values[j],"c"+String.valueOf(counter));
                deck.add(card);
                counter++;

            }
        }
    }


    public void addCard(Card card) {
        this.deck.add(card);
    }

    public int countCard() {
        int cardNumber = this.deck.size();
        return cardNumber;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public Card dealCard() {

        if (this.deck.size() != 0) {
            Card card = this.deck.remove(0);
            return card;
        }

        else {
            return null;
        }

    }

}
