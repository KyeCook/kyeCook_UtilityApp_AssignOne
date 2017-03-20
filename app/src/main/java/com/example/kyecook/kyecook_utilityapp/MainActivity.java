package com.example.kyecook.kyecook_utilityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView countryToBeConverted;
    private TextView convertedCurrency;
    private EditText moneyToConvert;
    private float currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        countryToBeConverted = (TextView) findViewById(R.id.countryToBeConverted);
        convertedCurrency = (TextView) findViewById(R.id.convertedCurrency);
        moneyToConvert = (EditText) findViewById(R.id.moneyToConvertInput);

        Button conversionButton = (Button) findViewById(R.id.conversionButton);

        moneyToConvert.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                try {

                    currency = Integer.parseInt(s.toString());

                    convertedCurrency.setText(String.valueOf("$" + currency));

                } catch (Exception e) {

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        conversionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                This is the segment for the conversion button. It loads the 'convert' method.


            }
        });

    }
}
