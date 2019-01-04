package com.example.pawcio.alko;


import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double[] data = new double[5];
    RadioGroup radioGroup;
    double factor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);

        final Button result = findViewById(R.id.button);
        result.setOnClickListener(onResultButtonClicked);
    }


    private View.OnClickListener onResultButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {



            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.radioButton_men:
                    factor = 0.7;
                    break;
                case R.id.radioButton_women:
                    factor = 0.65;
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Aby dokonać wyliczenia musisz wybrać płeć i uzupełnić dane",
                            Toast.LENGTH_LONG).show();
                break;
            }


            int[] ids = new int[]{R.id.editTextKG, R.id.editText_beer, R.id.editText_wine, R.id.editText_vodka, R.id.editText_time};
            int i = 0;
            for (int id : ids) {
                EditText textField = findViewById(id);
                textField.clearFocus();
                if (!textField.getText().toString().isEmpty()) {
                    data[i] = Double.parseDouble(textField.getText().toString());
                } else {
                    data[i] = 0.0;
                }
                i++;
            }

            final double beer_GOA = (data[1] * 10) / 250;
            double wine_GOA = (data[2] * 10) / 120;
            double vodka_GOA = (data[3] * 10) / 30;
            double result = ((beer_GOA + wine_GOA + vodka_GOA) / (factor * data[0])) - (0.15 * data[4]);

            DecimalFormat df = new DecimalFormat("#.####");
            result = Double.valueOf(df.format(result));

            final String BAC = Double.toString(result);


            // DIALOG //


           AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setTitle("Wynik");
            if (result > 0.2)
            {
                String alert1 = "W tym momencie masz: " + BAC + " ‰";
                builder1.setMessage(alert1 +"\n");
            }
            if (result <= 0.2)
            {
                String alert3 = "W tym momencie masz: " + BAC + " ‰";
                builder1.setMessage(alert3 +"\n");
            }
            builder1.setCancelable(true);


            final double finalResult = result;
            builder1.setPositiveButton(
                    "Co dalej?",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(MainActivity.this, Result.class);
                            intent.putExtra("BAC", BAC);
                            startActivity(intent);
                        }
                    });

            builder1.setNegativeButton(
                    "Wyjdź",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();






        }

    };

}
