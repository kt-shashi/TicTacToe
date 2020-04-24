package com.shashi.gridtest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.microedition.khronos.opengles.GL;

public class MainActivity extends AppCompatActivity {

    //0: Zero
    //1: Cross
    //2: Empty

    private int activePlayer = 1;
    private int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    private int[][] winningpositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private boolean playGame = true;

    ActionBar actionBar;

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;


        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && playGame) {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000);

            if (activePlayer == 1) {
                counter.setImageResource(R.drawable.x);
                activePlayer = 0;
            } else {
                counter.setImageResource(R.drawable.o);
                activePlayer = 1;
            }

            counter.animate().translationYBy(1000).setDuration(0);


            for (int[] winPosCheck : winningpositions) {
                if (gameState[winPosCheck[0]] == gameState[winPosCheck[1]] && gameState[winPosCheck[1]] == gameState[winPosCheck[2]] && gameState[winPosCheck[0]] != 2) {
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "0";
                    } else {
                        winner = "X";
                    }
                    playGame = false;

                    Button playAgain = (Button) findViewById(R.id.playAgain);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                    winnerTextView.setText(winner + " has won!");
                    //playAgain.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgainF(View view) {

        Button playAgain = (Button) findViewById(R.id.playAgain);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        //playAgain.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);
        ImageView imageView7 = (ImageView) findViewById(R.id.imageView7);
        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        ImageView imageView9 = (ImageView) findViewById(R.id.imageView9);

        imageView1.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        imageView3.setImageDrawable(null);
        imageView4.setImageDrawable(null);
        imageView5.setImageDrawable(null);
        imageView6.setImageDrawable(null);
        imageView7.setImageDrawable(null);
        imageView8.setImageDrawable(null);
        imageView9.setImageDrawable(null);


        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        activePlayer = 1;
        playGame = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A2727")));
    }
}
