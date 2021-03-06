package com.example.pawcio.alko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Result extends AppCompatActivity {

    TextView BAC_result;
    TextView textView_Result;
    Button Button_ResultActivity;
    TextView textView_test;
    // Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String objawy = "", dodatek = "";

        BAC_result = (TextView) findViewById(R.id.TextView_Result_BAC);
        textView_Result = (TextView) findViewById(R.id.textView_result);
        final String anotherActivityBAC = getIntent().getStringExtra("BAC");


        if (getIntent().getStringExtra("BAC").equals("9.223372036854776E14")) {
            BAC_result.setText("Uzupełnij dane poprawnie.");
        } else {
            BAC_result.setText("Twój wynik to: " + getIntent().getStringExtra("BAC") + " ‰");
        }

        final double resultat = Double.valueOf(getIntent().getStringExtra("BAC"));
        if (resultat >= 0 && resultat <= 0.3) {
            objawy = "Brak znaczących objawów.";
            textView_Result.setText("Typowe objawy: " + "\n" + objawy);
        }

        if (resultat > 0.3 && resultat <= 0.7) {
            objawy = "Nieznaczne zaburzenia równowagi oraz euforia i obniżenie krytycyzmu, upośledzenie koordynacji " +
                    "wzrokowo-ruchowej oraz zaburzenia widzenia.";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat > 0.7 && resultat <= 2) {
            objawy = "Zaburzenia równowagi, sprawności i koordynacji ruchowej, obniżenie progu bólu, spadek sprawności " +
                    "intelektualnej (błędy w logicznym rozumowaniu, wadliwe wyciąganie wniosków itp.) pogłębiający się w miarę " +
                    "narastania intoksykacji alkoholowej, opóźnienie czasu reakcji, wyraźna drażliwość, obniżona tolerancja, zachowania " +
                    "agresywne, pobudzenie seksualne, wzrost ciśnienia krwi oraz przyspieszenie akcji serca.";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat > 2 && resultat <= 3) {
            objawy = "Zaburzenia mowy (mowa bełkotliwa), wyraźne spowolnienie i zaburzenia równowagi, wzmożona senność, " +
                    "znaczne obniżona zdolność do kontroli własnych zachowań.";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat > 3 && resultat <= 4) {
            objawy = "Spadek ciśnienia krwi, obniżenie ciepłoty ciała, osłabienie lub zanik odruchów fizjologicznych oraz głębokie " +
                    "zaburzenia świadomości prowadzące do śpiączki.";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat > 4 && resultat <= 5) {
            objawy = "Głęboka śpiączka, zaburzenia czynności ośrodka oddechowego i naczyniowo-ruchowego, możliwość porażenia " +
                    "tych ośrodków przez alkohol.";
            dodatek = "(No czasami się umiera xD)";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy + "\n" + dodatek);
        }
        if (resultat > 5 && resultat <= 10) {
            objawy = "Ty jeszcze żyjesz?";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat > 10) {
            objawy = "Jak Ci się to udało? Ciąg alkoholowy? ";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat == 9.223372036854776E14){
            objawy = "Coś poszło nie tak. Uzupełnij dane poprawnie.";
            textView_Result.setText(objawy);
        }

        Button_ResultActivity = findViewById(R.id.Button_ResultActivity);
        Button_ResultActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(Result.this, DriveActivity.class);
                activityChangeIntent.putExtra("BAC_Result", anotherActivityBAC);
                startActivity(activityChangeIntent);

            }
        });


        double hoursDecimal = (resultat / 0.15);
        double secondsDecimal = hoursDecimal * 3600;
        double rounded = Math.round(secondsDecimal);
        int a = (int) Math.round(rounded);
        int hours = a / 3600;
        int minutes = (a % 3600) / 60;
        String timeString = String.format("%02d h %02d min", hours, minutes);

        textView_test = (TextView) findViewById(R.id.textView_test);
        textView_test.setText("Czas do całkowitego wytrzeźwienia:" + "\n" + timeString);

      /*  int timeInSeconds = a;
        final MyRunnable myRunnable = new MyRunnable(timeInSeconds);
         t = new Thread(myRunnable) {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (myRunnable.time >= 0) {
                                    textView_test.setText("Czas do całkowitego wytrzeźwienia: " + String.valueOf(myRunnable.time));
                                    myRunnable.time--;
                                } else {
                                    textView_test.setText("Jesteś trzeźwy.");
                                }
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();*/
    }

}



