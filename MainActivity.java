package com.example.klechak.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double curRate = 20.01;
    double inputEnt = 0.00;
    String inpAmt = "";
    double convAmt = 0.00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // we need to start off calling our logos.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // now we have set finals to each of our inputs and buttons.

        final EditText inpAmt = (EditText) findViewById(R.id.txt_MnyInp);
        final RadioButton USDtoPeso = (RadioButton) findViewById(R.id.radUSDtoPeso);
        final RadioButton PesotoUSD = (RadioButton) findViewById(R.id.radPesotoUSD);
        final TextView result = findViewById(R.id.txtDisplay);

        Button convert = (Button) findViewById(R.id.btnCon);

        convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    inputEnt = Double.parseDouble(inpAmt.getText().toString());
                } catch (NumberFormatException e) {  //This was done as a troubleshooting technique.  My error was actually caused by the result.settext below.

                }
                DecimalFormat tenth = new DecimalFormat("#.##");
                if (USDtoPeso.isChecked()) {
                    if (inputEnt <= 10000) {
                        convAmt = inputEnt * curRate;
                        result.setText(tenth.format(convAmt) + " Pesos");
                    } else {
                        Toast.makeText(MainActivity.this, "Dollars must be 10,000 or less", Toast.LENGTH_LONG).show();
                    }
                }
                if (PesotoUSD.isChecked()) {
                    if (inputEnt <= 499.75) {
                        convAmt = inputEnt / curRate;
                        result.setText(tenth.format(convAmt) + " USD");

                    } else {
                        Toast.makeText(MainActivity.this, "Pesos must be 499.75 or less", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
// comment so i can try to find out why this isnt uploading.