package com.example.junhosung.blackjackonandroid.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private String[] suits = {"Clubs","Hearts","Diamonds","Spades"};
    private String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private Integer[] values = {10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,10};
    private List<Card> deck = new ArrayList<>();

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

    public String[] getSuits() {
        return suits;
    }

    public void setSuits(String[] suits) {
        this.suits = suits;
    }

    public String[] getRanks() {
        return ranks;
    }

    public void setRanks(String[] ranks) {
        this.ranks = ranks;
    }

    public Integer[] getValues() {
        return values;
    }

    public void setValues(Integer[] values) {
        this.values = values;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
}
