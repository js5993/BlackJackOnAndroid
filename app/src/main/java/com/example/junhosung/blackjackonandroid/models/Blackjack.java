package com.example.junhosung.blackjackonandroid.models;

public class Blackjack {

    private static Blackjack instance;

    public static Blackjack getInstance() {
        if (instance == null) {
            instance = new Blackjack();
        }

        return instance;
    }

    private Blackjack() {
    }

    int turn = 0;
    public boolean playerVictory = false;
    public boolean dealerVictory = false;
    public boolean gameDraw = false;
    public int playerCash = 500;
    public int playerBet = 1;

    public Deck deck = new Deck();
    public Hand playerHand = new Hand();
    public Hand dealerHand = new Hand();

    public void dealInitialHands() {
        for (int i = 0; i < 2; i++) {
            playerHand.addCard(deck.dealCard());
            dealerHand.addCard(deck.dealCard());
        }
    }

    public void stand() {
        if (dealerHand.handValue() < 17) {
            dealerHand.addCard(deck.dealCard());
        }
    }

    public void hit() {
        if (playerHand.handValue() < 21) {
            playerHand.addCard(deck.dealCard());
        }
    }

    public void checkWin() {

        // player gets 21 and wins
        if ((dealerHand.handValue() != 21 && playerHand.handValue() == 21 && dealerHand.handValue() >= 17)
                || (playerHand.handValue() == 21 && dealerHand.handValue() < 17) )  {
            playerVictory = true;

        }

        // dealer gets 21 and wins
        else if (dealerHand.handValue() == 21 && playerHand.handValue() != 21) {
            dealerVictory = true;
        }

        // player busts and loses
        else if (playerHand.handValue() > 21 && dealerHand.handValue() <= 21) {
            dealerVictory = true;
        }

        // dealer busts and loses
        else if (playerHand.handValue() <= 21 && dealerHand.handValue() > 21) {
            playerVictory = true;
        }

        // no 21s but the player has the greater ending values that is < 21
        if (dealerHand.handValue() >= 17 && dealerHand.handValue() < 21 && playerHand.handValue() < 21
                && playerHand.handValue() > dealerHand.handValue()) {
            playerVictory = true;
        }

        // no 21s but the dealer has the greater ending values that is < 21
        else if (dealerHand.handValue() >= 17 && dealerHand.handValue() < 21 && playerHand.handValue() < 21
                && playerHand.handValue() < dealerHand.handValue()) {
            dealerVictory = true;
        }

    }

    public boolean checkDraw() {
        if (dealerHand.handValue() >= 17 && dealerHand.handValue() == playerHand.handValue()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void reshuffle() {
        for (int i = 0; i < playerHand.countCards(); i++) {
            Card card = playerHand.hand.remove(i);
            deck.deck.add(card);
        }
        for (int i = 0; i < dealerHand.countCards(); i++) {
            Card card = dealerHand.hand.remove(i);
            deck.deck.add(card);
        }
        deck.shuffleDeck();
    }
}
