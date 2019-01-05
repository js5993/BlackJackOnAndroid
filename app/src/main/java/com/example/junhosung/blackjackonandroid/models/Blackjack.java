package com.example.junhosung.blackjackonandroid.models;

public class Blackjack {

    private boolean playerVictory = false;
    private boolean dealerVictory = false;
    private boolean gameDraw = false;
    private int playerCash = 500;
    private int playerBet = 1;

    private Deck deck = new Deck();
    private Hand playerHand = new Hand();
    private Hand dealerHand = new Hand();

    private static Blackjack instance;

    public static Blackjack getInstance() {
        if (instance == null) {
            instance = new Blackjack();
        }
        return instance;
    }

    private Blackjack() {
    }

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
        } else {
            return false;
        }
    }

    public void reshuffle() {
        for (int i = 0; i < playerHand.countCards(); i++) {
            Card card = playerHand.getHand().remove(i);
            deck.getDeck().add(card);
        }
        for (int i = 0; i < dealerHand.countCards(); i++) {
            Card card = dealerHand.getHand().remove(i);
            deck.getDeck().add(card);
        }
        deck.shuffleDeck();
    }

    public boolean isPlayerVictory() {
        return playerVictory;
    }

    public void setPlayerVictory(boolean playerVictory) {
        this.playerVictory = playerVictory;
    }

    public boolean isDealerVictory() {
        return dealerVictory;
    }

    public void setDealerVictory(boolean dealerVictory) {
        this.dealerVictory = dealerVictory;
    }

    public boolean isGameDraw() {
        return gameDraw;
    }

    public void setGameDraw(boolean gameDraw) {
        this.gameDraw = gameDraw;
    }

    public int getPlayerCash() {
        return playerCash;
    }

    public void setPlayerCash(int playerCash) {
        this.playerCash = playerCash;
    }

    public int getPlayerBet() {
        return playerBet;
    }

    public void setPlayerBet(int playerBet) {
        this.playerBet = playerBet;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(Hand dealerHand) {
        this.dealerHand = dealerHand;
    }


}
