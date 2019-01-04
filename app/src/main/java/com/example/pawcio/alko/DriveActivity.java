package com.example.pawcio.alko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DriveActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    double resultatDriveActivity;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);

        resultatDriveActivity = Double.valueOf(getIntent().getStringExtra("BAC_Result"));

        //---- Najlepszy poradnik do spinnera - https://www.youtube.com/watch?v=on_OrrX7Nw4 ----//

        spinner = (Spinner)findViewById(R.id.Spinner_Drive);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        /*switch (radioGroup.getCheckedRadioButtonId()) {
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
        }*/

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String Text = parent.getSelectedItem().toString();
        if(Text.equals("Polska")){
            double legalLimit = 0.2;
            if (resultatDriveActivity >= legalLimit){

                Toast.makeText(getApplicationContext(), "Zawartość alkoholu w Twojej krwi nie pozwala Ci prowadzić pojazdu w tym kraju.",
                        Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Zawartość alkoholu w Twojej krwi pozwala Ci na prowadzenie pojazdu w tym kraju.",
                        Toast.LENGTH_LONG).show();
            }
        }
        if(Text.equals("Czechy")){

        }
        if(Text.equals("Słowacja")){

        }
        if(Text.equals("Ukraina")){

        }
        if(Text.equals("Białoruś")){

        }
        if(Text.equals("Litwa")){

        }
        if(Text.equals("Rosja")){

        }




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
