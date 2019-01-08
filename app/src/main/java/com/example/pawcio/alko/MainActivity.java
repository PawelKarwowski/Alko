package com.example.pawcio.alko;


import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


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
                    factor = 0.0;
                    Toast.makeText(getApplicationContext(), "Aby dokonać wyliczenia musisz wybrać płeć i uzupełnić dane.",
                            Toast.LENGTH_LONG).show();
                    break;
            }

            int[] ids = new int[]{R.id.editTextKG, R.id.editText_beer, R.id.editText_wine, R.id.editText_vodka, R.id.editText_time};
            int i = 0;
            for (int id : ids) {
                EditText textField = findViewById(id);
                textField.clearFocus();
                if (!textField.getText().toString().isEmpty()) {
                    if (textField.getText().toString().equals(".")) {
                        data[i] = 0.0;
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Uwaga!");
                        alertDialog.setMessage("Nie sądzisz, że w tym miejscu nie powinno wstawiać się kropki?");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Rozumiem, przepraszam.",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        alertDialog.show();
                    } else {
                        data[i] = Double.parseDouble(textField.getText().toString());
                    }
                } else {
                    data[i] = 0.0;
                }
                i++;
            }

            final double beer_GOA = (data[1] * 10) / 250;
            double wine_GOA = (data[2] * 10) / 120;
            double vodka_GOA = (data[3] * 10) / 40;

            if (data[0] == 0) {
                Toast toastWeight = Toast.makeText(MainActivity.this, "Waga nie może być równa 0.", Toast.LENGTH_LONG);
                toastWeight.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 325);
                toastWeight.show();
            }
            double result = ((beer_GOA + wine_GOA + vodka_GOA) / (factor * data[0])) - (0.15 * data[4]);

            if (result < 0) {
                result = 0.0000;
            }

            double result1 = Math.round(result * 10000.0) / 10000.0;
            final String BAC = Double.toString(result1);

            // DIALOG //

            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setTitle("Wynik");
            if (result > 0 && !(BAC.equals("9.223372036854776E14"))) {
                String alert1 = "W tym momencie masz: " + BAC + " ‰";
                builder1.setMessage(alert1 + "\n");
            } else if (BAC.equals("9.223372036854776E14")) {
                String alert2 = "Sprawdź czy poprawnie uzupełniłeś wszystkie pola.";
                builder1.setMessage(alert2 + "\n");
            } else {
                builder1.setMessage("Masz 0 ‰");
            }
            builder1.setCancelable(true);
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
                    "Cofnij",
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
