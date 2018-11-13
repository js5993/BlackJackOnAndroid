package com.example.junhosung.blackjackonandroid;

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
    boolean playerVictory = false;
    boolean dealerVictory = false;
    int playerCash = 500;
    int playerBet = 1;

    Deck deck = new Deck();
    Hand playerHand = new Hand();
    Hand dealerHand = new Hand();
    int playerHandAce = 0;

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

        if (dealerHand.handValue() == 21 && playerHand.handValue() != 21) {
            dealerVictory = true;
        }

        // player busts and loses

        if (playerHand.handValue() > 21 && dealerHand.handValue() <= 21) {
            dealerVictory = true;

        }

        // dealer busts and loses

        if (playerHand.handValue() <= 21 && dealerHand.handValue() > 21) {
            playerVictory = true;

        }

        // no 21s but the player has the greater ending values that is < 21
        if (dealerHand.handValue() >= 17 && dealerHand.handValue() < 21 && playerHand.handValue() > dealerHand.handValue()) {
            playerVictory = true;
        }

        if (dealerHand.handValue() >= 17 && dealerHand.handValue() < 21 && playerHand.handValue() < dealerHand.handValue()) {
            dealerVictory = true;
        }

    }

    public boolean checkDraw() {
        if (instance.dealerHand.handValue() >= 17 && instance.dealerHand.handValue() == instance.playerHand.handValue()) {
            return true;
        }

        else {
            return false;
        }
    }

    public void afterMath() {
        if (playerVictory == true) {

            playerCash += playerBet;
            turn = 0;
            playerBet = 1;

            reshuffle();

            playerVictory = false;
            dealerVictory = false;
        }

        if (dealerVictory == true) {
            playerBet -= playerBet;
            turn = 0;
            playerBet = 1;

            reshuffle();

            playerVictory = false;
            dealerVictory = false;
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
