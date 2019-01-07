package com.example.junhosung.blackjackonandroid.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Junho Sung on 1/7/2019.
 */
public class HandTest {

    Card testCard = new Card("Hearts","Ace",10,"c14");

    @Test
    public void addCard() throws Exception {
        Hand testHand = new Hand();
        testHand.addCard(testCard);
        assertEquals(testCard,testHand.getHand().get(0));
    }

    @Test
    public void countCards() throws Exception {
        Hand testHand = new Hand();
        testHand.addCard(testCard);
        assertEquals(1,testHand.countCards());
    }

    @Test
    public void handValue() throws Exception {
        Hand testHand = new Hand();
        testHand.addCard(testCard);
        assertEquals(10,testHand.handValue());

    }

    @Test
    public void getHand() throws Exception {
        Hand testHand = new Hand();
        List<Card> testArray = new ArrayList<>();
        assertEquals(testArray, testHand.getHand());

    }

    @Test
    public void setHand() throws Exception {
        Hand testHand = new Hand();
        List<Card> testArray = new ArrayList<>();
        testArray.add(testCard);
        testHand.setHand(testArray);
        assertEquals(testArray, testHand.getHand());

    }

}