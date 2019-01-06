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

    int TestTime = 870;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        BAC_result = (TextView) findViewById(R.id.TextView_Result_BAC);
        textView_Result = (TextView) findViewById(R.id.textView_result);
        final String anotherActivityBAC = getIntent().getStringExtra("BAC");
        BAC_result.setText("Twój wynik to: " + getIntent().getStringExtra("BAC") + " ‰");

        double resultat = Double.valueOf(getIntent().getStringExtra("BAC"));
        if (resultat >= 0 && resultat <= 0.3)
        {
            String objawy = "Brak znaczących objawów.";
            textView_Result.setText("Typowe objawy: " + "\n"+ objawy);
        }

        if (resultat > 0.3 && resultat <= 0.7)
        {
            String objawy = "Nieznaczne zaburzenia równowagi oraz euforia i obniżenie krytycyzmu, upośledzenie koordynacji wzrokowo-ruchowej oraz zaburzenia widzenia.";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat > 0.7 && resultat <= 2)
        {
            String objawy = "Zaburzenia równowagi, sprawności i koordynacji ruchowej, obniżenie progu bólu, spadek sprawności intelektualnej (błędy w logicznym rozumowaniu, wadliwe wyciąganie wniosków itp.) pogłębiający się w miarę narastania intoksykacji alkoholowej, opóźnienie czasu reakcji, wyraźna drażliwość, obniżona tolerancja, zachowania agresywne, pobudzenie seksualne, wzrost ciśnienia krwi oraz przyspieszenie akcji serca.";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat > 2 && resultat <= 3)
        {
            String objawy = "Zaburzenia mowy (mowa bełkotliwa), wyraźne spowolnienie i zaburzenia równowagi, wzmożona senność, znaczne obniżona zdolność do kontroli własnych zachowań.";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat > 3 && resultat <= 4)
        {
            String objawy = "Spadek ciśnienia krwi, obniżenie ciepłoty ciała, osłabienie lub zanik odruchów fizjologicznych oraz głębokie zaburzenia świadomości prowadzące do śpiączki.";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }
        if (resultat > 4 && resultat <= 5)
        {
            String objawy = "Głęboka śpiączka, zaburzenia czynności ośrodka oddechowego i naczyniowo-ruchowego, możliwość porażenia tych ośrodków przez alkohol.";
            String dodatek = "(No czasami się umiera xD)";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy + "\n" + dodatek);
        }
        if (resultat > 5)
        {
            String objawy = "Ty jeszcze żyjesz?";
            textView_Result.setText("Typowe objawy:" + "\n" + objawy);
        }


        Button_ResultActivity = (Button) findViewById(R.id.Button_ResultActivity);

        Button_ResultActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent activityChangeIntent = new Intent(Result.this, DriveActivity.class);
                activityChangeIntent.putExtra("BAC_Result", anotherActivityBAC);
                startActivity(activityChangeIntent);
            }
        });


        double hoursDecimal = (resultat/0.15);
        double milisecondsDecimal = hoursDecimal * 3600;
        double rounded = Math.round(milisecondsDecimal);
        int a = (int) Math.round(rounded);

        /*int hours = a / 3600;
        int minutes = (a % 3600) / 60;
        String timeString = String.format("%02d:%02d", hours, minutes);*/


        textView_test = (TextView) findViewById(R.id.textView_test);
       // textView_test.setText(timeString);

        Thread t = new Thread(){
            @Override
                public void run(){
                while(!isInterrupted()){

                    try {
                        Thread.sleep(1000);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TestTime--; // Tutaj chce dać zmienną "a", która mam zedeklarowaną wyżej. Pojawia się niesety problem, którego nie jestem w stanie przeskoczyć bo nie znam sposobu na jego rozwiązanie.
                                textView_test.setText(String.valueOf(TestTime)); //Ze zmienną TestTime, która jest zadeklarowana globalnie jest luxio, odlicza pieknie w dół co sekunda, natomiast z tą z "a" nawet final a nie chce się bawić :(
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        t.start();

    }
}


