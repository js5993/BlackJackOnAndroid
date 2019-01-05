package com.example.junhosung.blackjackonandroid.models;

/**
 * Created by Junho Sung on 11/13/2018.
 */

public class Card {

    // Suit = Clubs, Hearts, Diamonds, Spades
    private String suit;
    private String rank;
    private int cardValue;
    private String imgId;

    public Card(String suit, String rank, int cardValue, String imgId) {
        this.suit = suit;
        this.rank = rank;
        this.cardValue = cardValue;
        this.imgId = imgId;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }
}

