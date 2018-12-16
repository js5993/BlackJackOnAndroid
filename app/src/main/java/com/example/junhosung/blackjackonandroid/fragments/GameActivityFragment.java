package com.example.junhosung.blackjackonandroid.fragments;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.FrameLayout;

import com.example.junhosung.blackjackonandroid.fragments.dialog_fragments.DefeatMessageFragment;
import com.example.junhosung.blackjackonandroid.fragments.dialog_fragments.DrawMessageFragment;
import com.example.junhosung.blackjackonandroid.fragments.dialog_fragments.VictoryMessageFragment;
import com.example.junhosung.blackjackonandroid.model.AudioPlayer;
import com.example.junhosung.blackjackonandroid.model.Blackjack;
import com.example.junhosung.blackjackonandroid.model.Card;
import com.example.junhosung.blackjackonandroid.R;

import java.util.List;

/**
 * Created by Junho Sung on 8/10/2018.
 */


public class GameActivityFragment extends Fragment {

    TextView txtViewCash;
    TextView txtViewBet;

    Button btnDeal;
    Button btnStand;
    Button btnHit;
    Button btnBet100;
    Button btnBet25;
    Button btnBet5;
    Button btnBet1;
    Button btnResetCash;

    FrameLayout layoutDealerHand1;
    FrameLayout layoutPlayerHand1;

    Blackjack blackjack = Blackjack.getInstance();
    AudioPlayer audioPlayer = new AudioPlayer();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        blackjack.deck.shuffleDeck();
        audioPlayer.play(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game,container,false);

        txtViewCash = (TextView) view.findViewById(R.id.txtView_display_cash);
        txtViewCash.setText(String.valueOf(blackjack.playerCash));

        txtViewBet = (TextView) view.findViewById(R.id.txtView_display_bet);
        txtViewBet.setText(String.valueOf(blackjack.playerBet));

        layoutDealerHand1 = (FrameLayout) view.findViewById(R.id.layout_dealer_hand);
        layoutPlayerHand1 = (FrameLayout) view.findViewById(R.id.layout_player_hand);

        btnDeal = (Button) view.findViewById(R.id.btn_deal);
        btnDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (blackjack.playerHand.countCards() == 0 && blackjack.dealerHand.countCards() ==0) {
                    blackjack.dealInitialHands();
                    drawHands(layoutDealerHand1, blackjack.dealerHand.hand);
                    drawHands(layoutPlayerHand1, blackjack.playerHand.hand);

                }

                else {
                    Toast.makeText(getActivity(),"you have already dealt the initial hands!",Toast.LENGTH_SHORT).show();
                }

            }

        });

        btnStand = (Button) view.findViewById(R.id.btn_stand);
        btnStand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (blackjack.dealerHand.countCards() == 0 && blackjack.playerHand.countCards() == 0) {
                    Toast.makeText(getActivity(),"you have to deal cards before you can stand!",Toast.LENGTH_LONG).show();
                }

                else {
                    blackjack.stand();
                    drawHands(layoutDealerHand1, blackjack.dealerHand.hand);
                    drawHands(layoutPlayerHand1, blackjack.playerHand.hand);
                    blackjack.checkWin();
                }

                if (blackjack.checkDraw()) {
                    resetGame(blackjack);
                    blackjack.reshuffle();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawHands(layoutDealerHand1, blackjack.dealerHand.hand);
                            drawHands(layoutPlayerHand1, blackjack.playerHand.hand);
                        }
                    },2500);

                }

                else if (blackjack.playerVictory || blackjack.dealerVictory) {

                    resetGame(blackjack);
                    blackjack.reshuffle();
                    txtViewCash.setText(String.valueOf(blackjack.playerCash));

                    blackjack.reshuffle();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawHands(layoutDealerHand1, blackjack.dealerHand.hand);
                            drawHands(layoutPlayerHand1, blackjack.playerHand.hand);

                        }
                    },2500);

                }


            }
        });

        btnHit = (Button) view.findViewById(R.id.btn_hit);
        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (blackjack.playerHand.countCards() == 0 && blackjack.dealerHand.countCards() ==0 ) {
                    Toast.makeText(getActivity(),"You have to deal before you can hit!",Toast.LENGTH_SHORT).show();
                }

                else {
                    blackjack.hit();
                    drawHands(layoutDealerHand1, blackjack.dealerHand.hand);
                    drawHands(layoutPlayerHand1, blackjack.playerHand.hand);
                    blackjack.checkWin();
                }

                if (blackjack.checkDraw()) {
                    resetGame(blackjack);
                    blackjack.reshuffle();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawHands(layoutDealerHand1, blackjack.dealerHand.hand);
                            drawHands(layoutPlayerHand1, blackjack.playerHand.hand);
                        }
                    },2500);

                }

                else if (blackjack.playerVictory || blackjack.dealerVictory) {

                    resetGame(blackjack);
                    blackjack.reshuffle();
                    txtViewCash.setText(String.valueOf(blackjack.playerCash));

                    blackjack.reshuffle();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawHands(layoutDealerHand1, blackjack.dealerHand.hand);
                            drawHands(layoutPlayerHand1, blackjack.playerHand.hand);

                        }
                    },2500);
                }
            }
        });

        btnBet100 = (Button) view.findViewById(R.id.btn_bet_100);
        btnBet100.setBackgroundResource(R.drawable.chip100);
        btnBet100.post(new Runnable() {
            @Override
            public void run() {
                int btnBet100Width = btnBet100.getWidth();
                int btnBet100Height = btnBet100.getHeight();
                Bitmap originalBtnBet100 = BitmapFactory.decodeResource(getResources(),R.drawable.chip100);
                Bitmap scaledBtnBet100 = Bitmap.createScaledBitmap(originalBtnBet100,btnBet100Width,btnBet100Height,true);
                Resources resource = getResources();
                btnBet100.setBackground(new BitmapDrawable(resource,scaledBtnBet100));
            }
        });


        btnBet100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blackjack.playerBet = 100;
                txtViewBet.setText(String.valueOf(blackjack.playerBet));
                //Toast.makeText(GameActivitgy.this,"something happened!",Toast.LENGTH_SHORT).show();
            }
        });

        btnBet25 = (Button) view.findViewById(R.id.btn_bet_25);
        btnBet25.setBackgroundResource(R.drawable.chip25);
        btnBet25.post(new Runnable() {
            @Override
            public void run() {
                int btnBet25Width = btnBet25.getWidth();
                int btnBet25Height = btnBet25.getHeight();
                Bitmap originalBtnBet25 = BitmapFactory.decodeResource(getResources(),R.drawable.chip25);
                Bitmap scaledBtnBet25 = Bitmap.createScaledBitmap(originalBtnBet25,btnBet25Width,btnBet25Height,true);
                Resources resource = getResources();
                btnBet25.setBackground(new BitmapDrawable(resource,scaledBtnBet25));
            }
        });
        btnBet25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blackjack.playerBet = 25;
                txtViewBet.setText(String.valueOf(blackjack.playerBet));
                //Toast.makeText(GameActivity.this,"something happened!",Toast.LENGTH_SHORT).show();
            }
        });

        btnBet5 = (Button) view.findViewById(R.id.btn_bet_5);
        btnBet5.setBackgroundResource(R.drawable.chip5);
        btnBet5.post(new Runnable() {
            @Override
            public void run() {
                int btnBet5Width = btnBet5.getWidth();
                int btnBet5Height = btnBet5.getHeight();
                Bitmap originalBtnBet5 = BitmapFactory.decodeResource(getResources(),R.drawable.chip5);
                Bitmap scaledBtnBet5 = Bitmap.createScaledBitmap(originalBtnBet5,btnBet5Width,btnBet5Height,true);
                Resources resource = getResources();
                btnBet5.setBackground(new BitmapDrawable(resource,scaledBtnBet5));
            }
        });

        btnBet5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blackjack.playerBet = 5;
                txtViewBet.setText(String.valueOf(blackjack.playerBet));

            }
        });

        btnBet1 = (Button) view.findViewById(R.id.btn_bet_1);
        btnBet1.setBackgroundResource(R.drawable.chip1);
        btnBet1.post(new Runnable() {
            @Override
            public void run() {
                int btnBet1Width = btnBet1.getWidth();
                int btnBet1Height = btnBet1.getHeight();
                Bitmap originalBtnBet1 = BitmapFactory.decodeResource(getResources(), R.drawable.chip1);
                Bitmap scaledBtnBet1 = Bitmap.createScaledBitmap(originalBtnBet1,btnBet1Width,btnBet1Height,true);
                Resources resource = getResources();
                btnBet1.setBackground(new BitmapDrawable(resource,scaledBtnBet1));

            }
        });

        btnBet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blackjack.playerBet = 1;
                txtViewBet.setText(String.valueOf(blackjack.playerBet));

            }
        });

        btnResetCash = (Button) view.findViewById(R.id.btn_reset_cash);
        btnResetCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                blackjack.playerCash = 500;
                txtViewCash.setText(String.valueOf(blackjack.playerCash));

            }
        });


        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        audioPlayer.stop();
    }

    private void drawHands(FrameLayout layout, List<Card> hand) {
        if (layout.getChildCount() > 0) {
            layout.removeAllViews();
        }

        if (hand.size() != 0) {
            int leftMargin = 0;

            for (int i = 0; i < hand.size(); i++) {

                FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT);

                leftMargin += 70;
                params1.leftMargin = leftMargin;

                String cardImgId = hand.get(i).imgId;
                int imageResource = getResources().getIdentifier(cardImgId, "drawable", getActivity().getPackageName());
                ImageView card = new ImageView(getActivity());
                card.setBackgroundResource(imageResource);
                card.setLayoutParams(params1);

                layout.addView(card);
            }

        }
        else if (hand.size() == 0) {
            layout.removeAllViews();
        }
    }
    private void resetGame(Blackjack blackjack) {

        if (blackjack.playerVictory == true) {

            String finalScore = "final score: the player -> " + blackjack.playerHand.handValue() + ", the dealer -> "
                    + blackjack.dealerHand.handValue();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            VictoryMessageFragment victoryMessageFragment = VictoryMessageFragment.newInstance(finalScore);
            victoryMessageFragment.show(fragmentManager,"Victory Dialog");

            blackjack.playerCash += blackjack.playerBet;
            blackjack.playerVictory = false;
            blackjack.dealerVictory = false;
            blackjack.reshuffle();
        }

        else if (blackjack.dealerVictory == true) {

            String finalScore = "final score: the player -> " + blackjack.playerHand.handValue() + ", the dealer -> "
                    + blackjack.dealerHand.handValue();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            DefeatMessageFragment defeatMessageFragment = DefeatMessageFragment.newInstance(finalScore);
            defeatMessageFragment.show(fragmentManager,"Defeat Dialog");

            blackjack.playerCash -= blackjack.playerBet;
            blackjack.playerVictory = false;
            blackjack.dealerVictory = false;
            blackjack.reshuffle();
        }

        // In case of draw ...

        else if (blackjack.playerVictory == false && blackjack.dealerVictory == false) {
            String finalScore = "final score: the player -> " + blackjack.playerHand.handValue() + ", the dealer -> "
                    + blackjack.dealerHand.handValue();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            DrawMessageFragment drawMessageFragment = DrawMessageFragment.newInstance(finalScore);
            drawMessageFragment.show(fragmentManager,"Draw Dialog");

            blackjack.reshuffle();
        }

    }
}
