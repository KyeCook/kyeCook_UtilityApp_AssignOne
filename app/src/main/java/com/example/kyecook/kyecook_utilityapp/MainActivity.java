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

import java.util.Locale;

/*
Author : Kye Cook

Utility App - Currency Converter/Calculator
 */

public class MainActivity extends AppCompatActivity {

//    Setup variables for XML values
    private TextView countryToBeConverted;
    private TextView countryToBeConvertedString;

    private TextView convertedCountryText;
    private TextView convertedCountryCurrency;

    private TextView convertedCurrency;
    private double currency;
    private SharedPreferences preferences;

    private double currencyToConvert;
    private String countrySymbol;

    EditText moneyToConvert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        Set the preferences to be shared between activities
        preferences = getSharedPreferences("countryPreferences", MODE_PRIVATE);




//        Pull XML values
        countryToBeConverted = (TextView) findViewById(R.id.countryToBeConverted);
        countryToBeConvertedString = (TextView) findViewById(R.id.countryToBeConvertedString);

        convertedCountryText = (TextView) findViewById(R.id.convertedCountryText);
        convertedCountryCurrency = (TextView) findViewById(R.id.convertedCountryCurrency);

        convertedCurrency = (TextView) findViewById(R.id.convertedCurrency);
        moneyToConvert = (EditText) findViewById(R.id.moneyToConvertInput);

        Button conversionButton = (Button) findViewById(R.id.conversionButton);
        Button switchConversions = (Button) findViewById(R.id.switchConversions);


//        Handles user input within EditText field
        moneyToConvert.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                try {

//                    Changes user input (String) into double so that calculations etc. can be performed
                    currency = Double.parseDouble(s.toString());


                } catch (Exception e) {
//                    Catches inputs that aren't numerical and stops from crashing/showing developer style error messages
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        conversionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
            This is the segment for the conversion button. It uses values from Settings Activity
            in calculations
*/

                String convertedCurrencyString;

//                Set condition statement to detect whether Aus currency is being converted or other
                if(countryToBeConverted.getText().toString().equals("AUD")){
//                    Have used Local.getdefault to eliminate error messages for implicitly using it
                    convertedCurrencyString = countrySymbol + String.format(Locale.getDefault(), "%.2f",
                            (currency / currencyToConvert));

                    convertedCurrency.setText(convertedCurrencyString);

                } else {

                    convertedCurrencyString = "$" + String.format(Locale.getDefault(), "%.2f",
                            (currency * currencyToConvert));
                    convertedCurrency.setText(convertedCurrencyString);
                }

            }
        });

        switchConversions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                Handles switching of currencies too allow user to input Australian currency to see
                foreign value
*/

                if(countryToBeConverted.getText().toString().equals("AUD")){
                    if(preferences.getString("currency", "").equals("")){
//                        For testing
                        System.out.println("Null Preferences - Default Values used");

                        countryToBeConverted.setText(R.string.usd);
                        countryToBeConvertedString.setText(R.string.americanValue);

                        convertedCountryCurrency.setText(R.string.aud);
                        convertedCountryText.setText(R.string.australianValue);
                    }else {
                        System.out.println("Preferences have been changed");

                        countryToBeConverted.setText(preferences.getString("currency", ""));
                        countryToBeConvertedString.setText(preferences.getString("country", ""));

                        convertedCountryCurrency.setText(R.string.aud);
                        convertedCountryText.setText(R.string.australianValue);
                    }


                } else {
                    if(preferences.getString("currency", "").equals("")) {
//                        For testing
                        System.out.println("Null preferences - Default values used");

                        convertedCountryCurrency.setText(R.string.usd);
                        convertedCountryText.setText(R.string.americanValue);

                        countryToBeConverted.setText(R.string.aud);
                        countryToBeConvertedString.setText(R.string.australianValue);
                    } else {
                        System.out.println("Preferences have been changed");

                        convertedCountryCurrency.setText(preferences.getString("currency", ""));
                        convertedCountryText.setText(preferences.getString("country", ""));

                        countryToBeConverted.setText(R.string.aud);
                        countryToBeConvertedString.setText(R.string.australianValue);
                    }
                }
            }
        });

    }

    @Override

//    Sets shared-preferences to from settings to be reloaded each time main is started
    protected void onStart() {
        super.onStart();

        countryToBeConverted.setText(preferences.getString("currency", "USD"));
        countryToBeConvertedString.setText(preferences.getString("country", "United States Dollars"));
        currencyToConvert = Double.parseDouble(preferences.getString("countryCurrency","1.29"));
        countrySymbol = preferences.getString("countrySymbol", "$");

    }

//    Handles handler for the settings button and changes activity view when clicked to that of settings
    public void settingsHandler(View view) {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }
}
