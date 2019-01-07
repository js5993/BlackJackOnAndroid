package com.example.junhosung.blackjackonandroid.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Junho Sung on 1/7/2019.
 */
public class CardTest {

    @Test
    public void getSuit() throws Exception {
        Card testCard = new Card("Club","6",6,"c45");
        assertEquals("Club",testCard.getSuit());
    }

    @Test
    public void getRank() throws Exception {
        Card testCard = new Card("Club","6",6,"c45");
        assertEquals("6",testCard.getRank());
    }

    @Test
    public void setSuit() throws Exception {
        Card testCard = new Card("Club","6",6,"c45");
        testCard.setSuit("Spades");
        assertEquals("Spades",testCard.getSuit());
    }

    @Test
    public void setRank() throws Exception {
        Card testCard = new Card("Club","6",6,"c45");
        testCard.setRank("Ace");
        assertEquals("Ace",testCard.getRank());
    }

    @Test
    public void getCardValue() throws Exception {
        Card testCard = new Card("Club","6",6,"c45");
        assertEquals(6,testCard.getCardValue());
    }

    @Test
    public void setCardValue() throws Exception {
        Card testCard = new Card("Club","6",6,"c45");
        testCard.setCardValue(7);
        assertEquals(7, testCard.getCardValue());
    }

    @Test
    public void getImgId() throws Exception {
        Card testCard = new Card("Club","6",6,"c45");
        assertEquals("c45",testCard.getImgId());
    }

    @Test
    public void setImgId() throws Exception {
        Card testCard = new Card("Club","6",6,"c45");
        testCard.setImgId("c46");
        assertEquals("c46",testCard.getImgId());
    }

}