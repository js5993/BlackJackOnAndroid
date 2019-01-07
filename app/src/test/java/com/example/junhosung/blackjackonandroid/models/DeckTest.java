package com.example.junhosung.blackjackonandroid.models;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Junho Sung on 1/7/2019.
 */
public class DeckTest {

    Card testCard = new Card("Hearts","Ace",10, "c14");

    @Test
    public void addCard() throws Exception {
        Deck testDeck = new Deck();
        testDeck.addCard(testCard);
        assertEquals(testCard,testDeck.getDeck().get(52));

    }

    @Test
    public void countCard() throws Exception {
        Deck testDeck = new Deck();
        assertEquals(52,testDeck.countCard());
    }

    @Test
    public void dealCard() throws Exception {
        Deck testDeck = new Deck();
        Card dealtCard = testDeck.dealCard();
        assertEquals(51, testDeck.countCard());
    }

    @Test
    public void getSuits() throws Exception {
        Deck testDeck = new Deck();
        String[] testArray = testDeck.getSuits();
        assertArrayEquals(testArray, testDeck.getSuits());
    }

    @Test
    public void setSuits() throws Exception {
        Deck testDeck = new Deck();
        String[] testSuits = {};
        testDeck.setSuits(testSuits);
        assertArrayEquals(testSuits, testDeck.getSuits());
    }

    @Test
    public void getRanks() throws Exception {
        Deck testDeck = new Deck();
        String[] testArray = testDeck.getRanks();
        assertArrayEquals(testArray, testDeck.getRanks());
    }

    @Test
    public void setRanks() throws Exception {
        Deck testDeck = new Deck();
        String[] testArray = {};
        testDeck.setRanks(testArray);
        assertArrayEquals(testArray, testDeck.getRanks());
    }

    @Test
    public void getValues() throws Exception {
        Deck testDeck = new Deck();
        Integer[] testArray = testDeck.getValues();
        assertArrayEquals(testArray, testDeck.getValues());
    }

    @Test
    public void setValues() throws Exception {
        Deck testDeck = new Deck();
        Integer[] testArray = {};
        testDeck.setValues(testArray);
        assertArrayEquals(testArray, testDeck.getValues());

    }
    @Test
    public void getDeck() throws Exception {
        Deck testDeck = new Deck();
        List<Card> testList = testDeck.getDeck();
        assertEquals(testList,testDeck.getDeck());
    }

    @Test
    public void setDeck() throws Exception {
        Deck testDeck = new Deck();
        List<Card> testList = new ArrayList<>();
        testDeck.setDeck(testList);
        assertEquals(testList, testDeck.getDeck());
    }

}