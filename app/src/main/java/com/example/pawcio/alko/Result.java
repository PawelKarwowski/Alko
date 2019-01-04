package com.example.pawcio.alko;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView BAC_result;
    TextView textView_Result;
    double resultat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        BAC_result = (TextView) findViewById(R.id.TextView_Result_BAC);
        BAC_result.setText("Twój wynik to: " + getIntent().getStringExtra("BAC"));

        String test = getIntent().getStringExtra("BAC");
        textView_Result.setText(test);
       /* resultat = Double.valueOf(text);*/


       /* resultat = Double.parseDouble(getIntent().getStringExtra("BAC"));


        if (resultat > 0.2)
        {
            doubleResult.setText("DUPA!");
        }*/


    }
}
