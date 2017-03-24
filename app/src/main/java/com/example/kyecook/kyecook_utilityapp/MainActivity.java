package com.example.kyecook.kyecook_utilityapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
Author : Kye Cook

Utility App - Currency Converter/Calculator
 */
/*
todo Change currency variables into 'Currency' or 'BigDecimal' datatypes
todo Allow user to convert from AUD to USD

*/

public class MainActivity extends AppCompatActivity {

    private TextView countryToBeConverted;
    private TextView countryToBeConvertedString;

    private TextView convertedCurrency;
    private double currency;
    private SharedPreferences preferences;

    EditText moneyToConvert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("countryPreferences", MODE_PRIVATE);


        countryToBeConverted = (TextView) findViewById(R.id.countryToBeConverted);
        countryToBeConvertedString = (TextView) findViewById(R.id.countryToBeConvertedString);
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

                    currency = Double.parseDouble(s.toString());

//                     Testing to make sure strings displaying correctly
//                    convertedCurrency.setText(String.valueOf("$" + currency));

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
        /* This is the segment for the conversion button. It uses values from Settings Activity
                in calculations */



                double currencyToConvert = Double.parseDouble(preferences.getString("countryCurrency",""));

                String convertedCurrencyString = '$' + String.valueOf(currency * currencyToConvert);

                convertedCurrency.setText(convertedCurrencyString);

            }
        });

    }

    @Override

//    Sets shared-preferences to from settings to be reloaded each time main is started
    protected void onStart() {
        super.onStart();

        countryToBeConverted.setText(preferences.getString("currency", ""));
        countryToBeConvertedString.setText(preferences.getString("country", ""));

    }

//    Handles handler for the settings button and changes activity view when clicked to that of settings
    public void settingsHandler(View view) {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }

}
