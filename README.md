# BlackJackOnAndroid

Blackjack implementation on Android.

This is an Android implementation of a previous project done on Processing with Python.

The basic functionality of the game are as follows:
1.	There are three buttons on the left side for the three Blackjack game functions: Deal, Stand, Hit
2.	The four buttons on the right control the number of money you are betting, which go in increments of 1, 5, 25, and 100.
3.	The current bet is display on the upper right corner.
4.	 A button in the center-top region resets the money.

The code architecture of note are as follows:
1.	All UI code is shifted onto fragments from activities, with the exception of the welcome screen.
2.	The game logic object utilizes singleton model that restricts the instantiation of a class to one object, so that there is no race       condition with multiple instances of the game running.

