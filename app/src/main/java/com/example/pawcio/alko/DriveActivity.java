package com.example.pawcio.alko;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

        spinner = (Spinner) findViewById(R.id.Spinner_Drive);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String Text = parent.getSelectedItem().toString();
        ImageView myImageView = (ImageView) findViewById(R.id.imageView_BAC);

        String levelBAC = "W tym momencie w Twoim organizmie znajduje się około " + getIntent().getStringExtra("BAC_Result") + " ‰ alkoholu.";
        String canDrive = "Taka zawartość alkoholu w Twojej krwi pozwala Ci na prowadzenie pojazdu w tym kraju.";
        String cantDrive = "Taka zawartość alkoholu w Twojej krwi nie pozwala Ci na prowadzenie pojazdu w tym kraju.";
        AlertDialog.Builder builder1 = new AlertDialog.Builder(DriveActivity.this);
        builder1.setTitle("Rezultat:");
        builder1.setCancelable(true);
        builder1.setNegativeButton(
                "Cofnij",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        if (getIntent().getStringExtra("BAC_Result").equals("9.223372036854776E14")) {
            AlertDialog.Builder builderValid = new AlertDialog.Builder(DriveActivity.this);
            builderValid.setTitle("Uwaga!");
            builderValid.setCancelable(true);
            builderValid.setMessage("Dane błędnie uzupełnione. Spróbuj jeszcze raz.");
            AlertDialog alert = builderValid.create();
            alert.setButton(AlertDialog.BUTTON_NEUTRAL, "Cofnij",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent activityChangeIntent1 = new Intent(DriveActivity.this, MainActivity.class);
                            startActivity(activityChangeIntent1);
                        }
                    });
            alert.show();
        } else {
            if (Text.equals("Polska")) {
                double legalLimit = 0.2;
                myImageView.setImageResource(R.drawable.mappoland);

                if (resultatDriveActivity >= legalLimit) {
                    builder1.setMessage(levelBAC + "\n" + cantDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    builder1.setMessage(levelBAC + "\n" + canDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }

            if (Text.equals("Niemcy")) {
                double legalLimit = 0.5;
                myImageView.setImageResource(R.drawable.mapgermany);

                if (resultatDriveActivity >= legalLimit) {
                    builder1.setMessage(levelBAC + "\n" + cantDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    builder1.setMessage(levelBAC + "\n" + canDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }

            if (Text.equals("Czechy")) {
                double legalLimit = 0.0;
                myImageView.setImageResource(R.drawable.mapczech);
                if (resultatDriveActivity >= legalLimit) {
                    builder1.setMessage(levelBAC + "\n" + cantDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    builder1.setMessage(levelBAC + "\n" + canDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }

            if (Text.equals("Słowacja")) {
                double legalLimit = 0.0;
                myImageView.setImageResource(R.drawable.mapslovakia);
                if (resultatDriveActivity >= legalLimit) {
                    builder1.setMessage(levelBAC + "\n" + cantDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    builder1.setMessage(levelBAC + "\n" + canDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }

            if (Text.equals("Ukraina")) {
                double legalLimit = 0.2;
                myImageView.setImageResource(R.drawable.mapukraina);
                if (resultatDriveActivity >= legalLimit) {
                    builder1.setMessage(levelBAC + "\n" + cantDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    builder1.setMessage(levelBAC + "\n" + canDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }

            if (Text.equals("Białoruś")) {
                double legalLimit = 0.0;
                myImageView.setImageResource(R.drawable.mapbialorus);
                if (resultatDriveActivity >= legalLimit) {
                    builder1.setMessage(levelBAC + "\n" + cantDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    builder1.setMessage(levelBAC + "\n" + canDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }

            if (Text.equals("Litwa")) {
                double legalLimit = 0.4;
                myImageView.setImageResource(R.drawable.maplithuana);
                if (resultatDriveActivity >= legalLimit) {
                    builder1.setMessage(levelBAC + "\n" + cantDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    builder1.setMessage(levelBAC + "\n" + canDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }

            if (Text.equals("Rosja")) {
                double legalLimit = 0.3;
                myImageView.setImageResource(R.drawable.maprussia);
                if (resultatDriveActivity >= legalLimit) {
                    builder1.setMessage(levelBAC + "\n" + cantDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    builder1.setMessage(levelBAC + "\n" + canDrive);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
