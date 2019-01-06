package com.example.junhosung.blackjackonandroid.views.fragments;

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

import com.example.junhosung.blackjackonandroid.models.AudioPlayer;
import com.example.junhosung.blackjackonandroid.models.Blackjack;
import com.example.junhosung.blackjackonandroid.models.Card;
import com.example.junhosung.blackjackonandroid.R;
import com.example.junhosung.blackjackonandroid.views.fragments.dialogFragments.DefeatMessageFragment;
import com.example.junhosung.blackjackonandroid.views.fragments.dialogFragments.DrawMessageFragment;
import com.example.junhosung.blackjackonandroid.views.fragments.dialogFragments.VictoryMessageFragment;

import java.util.List;

/**
 * Created by Junho Sung on 8/10/2018.
 */


public class GameFragment extends Fragment {

    TextView mTxtViewCash;
    TextView mTxtViewBet;

    Button mBtnDeal;
    Button mBtnStand;
    Button mBtnHit;
    Button mBtnBet100;
    Button mBtnBet25;
    Button mBtnBet5;
    Button mBtnBet1;
    Button mBtnResetCash;

    FrameLayout mLayoutDealerHand1;
    FrameLayout mLayoutPlayerHand1;

    Blackjack sBlackjack = Blackjack.getInstance();
    AudioPlayer mAudioPlayer = new AudioPlayer();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sBlackjack.getDeck().shuffleDeck();
        mAudioPlayer.play(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game,container,false);

        mTxtViewCash = (TextView) view.findViewById(R.id.txtView_display_cash);
        mTxtViewCash.setText(String.valueOf(sBlackjack.getPlayerCash()));

        mTxtViewBet = (TextView) view.findViewById(R.id.txtView_display_bet);
        mTxtViewBet.setText(String.valueOf(sBlackjack.getPlayerBet()));

        mLayoutDealerHand1 = (FrameLayout) view.findViewById(R.id.layout_dealer_hand);
        mLayoutPlayerHand1 = (FrameLayout) view.findViewById(R.id.layout_player_hand);

        mBtnDeal = (Button) view.findViewById(R.id.btn_deal);
        mBtnDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sBlackjack.getPlayerHand().countCards() == 0 && sBlackjack.getDealerHand().countCards() ==0) {
                    sBlackjack.dealInitialHands();
                    drawHands(mLayoutDealerHand1, sBlackjack.getDealerHand().getHand());
                    drawHands(mLayoutPlayerHand1, sBlackjack.getPlayerHand().getHand());
                }

                else {
                    Toast.makeText(getActivity(),"you have already dealt the initial hands!",Toast.LENGTH_SHORT).show();
                }

            }

        });

        mBtnStand = (Button) view.findViewById(R.id.btn_stand);
        mBtnStand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sBlackjack.getDealerHand().countCards() == 0 && sBlackjack.getPlayerHand().countCards() == 0) {
                    Toast.makeText(getActivity(),"you have to deal cards before you can stand!",Toast.LENGTH_LONG).show();
                }

                else {
                    sBlackjack.stand();
                    drawHands(mLayoutDealerHand1, sBlackjack.getDealerHand().getHand());
                    drawHands(mLayoutPlayerHand1, sBlackjack.getPlayerHand().getHand());
                    sBlackjack.checkWin();
                }

                if (sBlackjack.checkDraw()) {
                    resetGame(sBlackjack);
                    sBlackjack.reshuffle();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawHands(mLayoutDealerHand1, sBlackjack.getDealerHand().getHand());
                            drawHands(mLayoutPlayerHand1, sBlackjack.getPlayerHand().getHand());
                        }
                    },2500);

                }

                else if (sBlackjack.isPlayerVictory() || sBlackjack.isDealerVictory()) {

                    resetGame(sBlackjack);
                    sBlackjack.reshuffle();
                    mTxtViewCash.setText(String.valueOf(sBlackjack.getPlayerCash()));

                    sBlackjack.reshuffle();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawHands(mLayoutDealerHand1, sBlackjack.getDealerHand().getHand());
                            drawHands(mLayoutPlayerHand1, sBlackjack.getPlayerHand().getHand());

                        }
                    },2500);
                }

            }
        });

        mBtnHit = (Button) view.findViewById(R.id.btn_hit);
        mBtnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sBlackjack.getPlayerHand().countCards() == 0 && sBlackjack.getDealerHand().countCards() ==0 ) {
                    Toast.makeText(getActivity(),"You have to deal before you can hit!",Toast.LENGTH_SHORT).show();
                }

                else {
                    sBlackjack.hit();
                    drawHands(mLayoutDealerHand1, sBlackjack.getDealerHand().getHand());
                    drawHands(mLayoutPlayerHand1, sBlackjack.getPlayerHand().getHand());
                    sBlackjack.checkWin();
                }

                if (sBlackjack.checkDraw()) {
                    resetGame(sBlackjack);
                    sBlackjack.reshuffle();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawHands(mLayoutDealerHand1, sBlackjack.getDealerHand().getHand());
                            drawHands(mLayoutPlayerHand1, sBlackjack.getPlayerHand().getHand());
                        }
                    },2500);

                }

                else if (sBlackjack.isPlayerVictory() || sBlackjack.isDealerVictory()) {

                    resetGame(sBlackjack);
                    sBlackjack.reshuffle();
                    mTxtViewCash.setText(String.valueOf(sBlackjack.getPlayerCash()));

                    sBlackjack.reshuffle();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            drawHands(mLayoutDealerHand1, sBlackjack.getDealerHand().getHand());
                            drawHands(mLayoutPlayerHand1, sBlackjack.getPlayerHand().getHand());

                        }
                    },2500);
                }
            }
        });

        mBtnBet100 = (Button) view.findViewById(R.id.btn_bet_100);
        mBtnBet100.setBackgroundResource(R.drawable.chip100);
        mBtnBet100.post(new Runnable() {
            @Override
            public void run() {
                int btnBet100Width = mBtnBet100.getWidth();
                int btnBet100Height = mBtnBet100.getHeight();
                Bitmap originalBtnBet100 = BitmapFactory.decodeResource(getResources(),R.drawable.chip100);
                Bitmap scaledBtnBet100 = Bitmap.createScaledBitmap(originalBtnBet100,btnBet100Width,btnBet100Height,true);
                Resources resource = getResources();
                mBtnBet100.setBackground(new BitmapDrawable(resource,scaledBtnBet100));
            }
        });


        mBtnBet100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sBlackjack.setPlayerBet(100);
                mTxtViewBet.setText(String.valueOf(sBlackjack.getPlayerBet()));
            }
        });

        mBtnBet25 = (Button) view.findViewById(R.id.btn_bet_25);
        mBtnBet25.setBackgroundResource(R.drawable.chip25);
        mBtnBet25.post(new Runnable() {
            @Override
            public void run() {
                int btnBet25Width = mBtnBet25.getWidth();
                int btnBet25Height = mBtnBet25.getHeight();
                Bitmap originalBtnBet25 = BitmapFactory.decodeResource(getResources(),R.drawable.chip25);
                Bitmap scaledBtnBet25 = Bitmap.createScaledBitmap(originalBtnBet25,btnBet25Width,btnBet25Height,true);
                Resources resource = getResources();
                mBtnBet25.setBackground(new BitmapDrawable(resource,scaledBtnBet25));
            }
        });
        mBtnBet25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sBlackjack.setPlayerBet(25);
                mTxtViewBet.setText(String.valueOf(sBlackjack.getPlayerBet()));
                //Toast.makeText(GameActivity.this,"something happened!",Toast.LENGTH_SHORT).show();
            }
        });

        mBtnBet5 = (Button) view.findViewById(R.id.btn_bet_5);
        mBtnBet5.setBackgroundResource(R.drawable.chip5);
        mBtnBet5.post(new Runnable() {
            @Override
            public void run() {
                int btnBet5Width = mBtnBet5.getWidth();
                int btnBet5Height = mBtnBet5.getHeight();
                Bitmap originalBtnBet5 = BitmapFactory.decodeResource(getResources(),R.drawable.chip5);
                Bitmap scaledBtnBet5 = Bitmap.createScaledBitmap(originalBtnBet5,btnBet5Width,btnBet5Height,true);
                Resources resource = getResources();
                mBtnBet5.setBackground(new BitmapDrawable(resource,scaledBtnBet5));
            }
        });

        mBtnBet5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sBlackjack.setPlayerBet(5);
                mTxtViewBet.setText(String.valueOf(sBlackjack.getPlayerBet()));

            }
        });

        mBtnBet1 = (Button) view.findViewById(R.id.btn_bet_1);
        mBtnBet1.setBackgroundResource(R.drawable.chip1);
        mBtnBet1.post(new Runnable() {
            @Override
            public void run() {
                int btnBet1Width = mBtnBet1.getWidth();
                int btnBet1Height = mBtnBet1.getHeight();
                Bitmap originalBtnBet1 = BitmapFactory.decodeResource(getResources(), R.drawable.chip1);
                Bitmap scaledBtnBet1 = Bitmap.createScaledBitmap(originalBtnBet1,btnBet1Width,btnBet1Height,true);
                Resources resource = getResources();
                mBtnBet1.setBackground(new BitmapDrawable(resource,scaledBtnBet1));

            }
        });

        mBtnBet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sBlackjack.setPlayerBet(1);
                mTxtViewBet.setText(String.valueOf(sBlackjack.getPlayerBet()));

            }
        });

        mBtnResetCash = (Button) view.findViewById(R.id.btn_reset_cash);
        mBtnResetCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sBlackjack.setPlayerCash(500);
                mTxtViewCash.setText(String.valueOf(sBlackjack.getPlayerCash()));

            }
        });

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mAudioPlayer.stop();
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

                String cardImgId = hand.get(i).getImgId();
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

        if (blackjack.isPlayerVictory() == true) {

            String finalScore = "final score: the player -> " + blackjack.getPlayerHand().handValue() + ", the dealer -> "
                    + blackjack.getDealerHand().handValue();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            VictoryMessageFragment victoryMessageFragment = VictoryMessageFragment.newInstance(finalScore);
            victoryMessageFragment.show(fragmentManager,"Victory Dialog");

            blackjack.setPlayerCash(blackjack.getPlayerCash() + blackjack.getPlayerBet());
            blackjack.setPlayerVictory(false);
            blackjack.setDealerVictory(false);
            blackjack.reshuffle();
        }

        else if (blackjack.isDealerVictory() == true) {

            String finalScore = "final score: the player -> " + blackjack.getPlayerHand().handValue() + ", the dealer -> "
                    + blackjack.getDealerHand().handValue();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            DefeatMessageFragment defeatMessageFragment = DefeatMessageFragment.newInstance(finalScore);
            defeatMessageFragment.show(fragmentManager,"Defeat Dialog");

            blackjack.setPlayerCash(blackjack.getPlayerCash()-blackjack.getPlayerBet());
            blackjack.setPlayerVictory(false);
            blackjack.setDealerVictory(false);
            blackjack.reshuffle();
        }

        // In case of draw ...

        else if (blackjack.isPlayerVictory() == false && blackjack.isDealerVictory() == false) {
            String finalScore = "final score: the player -> " + blackjack.getPlayerHand().handValue() + ", the dealer -> "
                    + blackjack.getDealerHand().handValue();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            DrawMessageFragment drawMessageFragment = DrawMessageFragment.newInstance(finalScore);
            drawMessageFragment.show(fragmentManager,"Draw Dialog");

            blackjack.reshuffle();
        }

    }
}
