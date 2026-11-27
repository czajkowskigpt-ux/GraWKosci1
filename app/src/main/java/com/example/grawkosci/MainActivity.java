package com.example.grawkosci;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int DICE_COUNT = 5;

    private final ImageView[] diceViews = new ImageView[DICE_COUNT];
    private final int[] diceDrawables = {
            R.drawable.k1,
            R.drawable.k2,
            R.drawable.k3,
            R.drawable.k4,
            R.drawable.k5,
            R.drawable.k6
    };

    private TextView tvRollScore;
    private TextView tvGameScore;
    private int totalGameScore = 0;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceViews[0] = findViewById(R.id.ivDice1);
        diceViews[1] = findViewById(R.id.ivDice2);
        diceViews[2] = findViewById(R.id.ivDice3);
        diceViews[3] = findViewById(R.id.ivDice4);
        diceViews[4] = findViewById(R.id.ivDice5);

        tvRollScore = findViewById(R.id.tvRollScore);
        tvGameScore = findViewById(R.id.tvGameScore);

        Button btnRoll = findViewById(R.id.btnRoll);
        Button btnReset = findViewById(R.id.btnReset);

        btnRoll.setOnClickListener(v -> rollDice());
        btnReset.setOnClickListener(v -> resetGame());
    }

    private void rollDice() {
        int[] rolls = new int[DICE_COUNT];
        int[] counts = new int[7]; // indeksy 1..6

        for (int i = 0; i < DICE_COUNT; i++) {
            int value = random.nextInt(6) + 1; // zakres 1..6
            rolls[i] = value;
            counts[value]++;
            diceViews[i].setImageResource(diceDrawables[value - 1]);
        }

        int rollScore = calculateRollScore(counts);
        totalGameScore += rollScore;

        tvRollScore.setText("Wynik tego losowania: " + rollScore);
        tvGameScore.setText("Wynik gry: " + totalGameScore);
    }

    private int calculateRollScore(int[] counts) {
        int score = 0;
        for (int face = 1; face <= 6; face++) {
            if (counts[face] >= 2) {
                score += face * counts[face];
            }
        }
        return score;
    }

    private void resetGame() {
        totalGameScore = 0;
        tvRollScore.setText("Wynik tego losowania: 0");
        tvGameScore.setText("Wynik gry: 0");

        for (ImageView diceView : diceViews) {
            diceView.setImageResource(R.drawable.question);
        }
    }
}