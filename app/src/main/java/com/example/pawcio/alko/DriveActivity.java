package com.example.pawcio.alko;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



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

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String Text = parent.getSelectedItem().toString();



        if(Text.equals("Polska")){
            double legalLimit = 0.2;
            AlertDialog.Builder builder1 = new AlertDialog.Builder(DriveActivity.this);
            builder1.setTitle("Rezultat");
            builder1.setCancelable(true);
            builder1.setNegativeButton(
                    "Wyjdź",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            if (resultatDriveActivity >= legalLimit){
                builder1.setMessage("Dupa");
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
            else {
                builder1.setMessage("Dupa123");
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        }

        if(Text.equals("Czechy")){
            double legalLimit = 0.0;
            if (resultatDriveActivity >= legalLimit){


            }
        }

        if(Text.equals("Słowacja")){
            double legalLimit = 0.0;
            if (resultatDriveActivity >= legalLimit){


            }
        }

        if(Text.equals("Ukraina")){
            double legalLimit = 0.2;
            if (resultatDriveActivity >= legalLimit){


            }
        }

        if(Text.equals("Białoruś")){
            double legalLimit = 0.0;
            if (resultatDriveActivity >= legalLimit){


            }
        }

        if(Text.equals("Litwa")){
            double legalLimit = 0.4;
            if (resultatDriveActivity >= legalLimit){


            }
            else {

            }
        }

        if(Text.equals("Rosja")){
            double legalLimit = 0.3;
            if (resultatDriveActivity >= legalLimit){


            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}
