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

//todo make settings go into top menu bar using <menu> within xml file

public class MainActivity extends AppCompatActivity {

    private TextView countryToBeConverted;
    private TextView countryToBeConvertedString;

    private TextView convertedCurrency;
    private EditText moneyToConvert;
    private double currency;

    private SharedPreferences preferences;

//    TODO use shared preferences to set country/currency that is to be converted

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

                    currency = Integer.parseInt(s.toString());

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
//                This is the segment for the conversion button. It loads the 'convert' method.

                double currencyToConvert = Double.parseDouble(preferences.getString("countryCurrency",""));

                String convertedCurrencyString = '$' + String.valueOf(currency * currencyToConvert);

                convertedCurrency.setText(convertedCurrencyString);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        countryToBeConverted.setText(preferences.getString("currency", ""));
        countryToBeConvertedString.setText(preferences.getString("country", ""));

    }

    public void settingsHandler(View view) {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }

}
