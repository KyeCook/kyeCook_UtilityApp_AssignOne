package com.example.kyecook.kyecook_utilityapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settingsActivity extends AppCompatActivity {

    String countryToConvert;
    String currencyToConvert;
    String countryCurrency;
    String countrySymbol;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences = getSharedPreferences("countryPreferences", MODE_PRIVATE);

        Button usdButton = (Button) findViewById(R.id.changeToUSD);
        Button euruButton = (Button) findViewById(R.id.changeToEUR);
        Button yenButton = (Button) findViewById(R.id.changeToYEN);
        Button sekButton = (Button) findViewById(R.id.changeToSEK);

//        Handles USD button operation - sets American values to preferences to be used by main Activity
        usdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countryToConvert = "America";
                currencyToConvert = "USD";
                countryCurrency = "1.29";
                countrySymbol = "$";

                preferences.edit().putString("country", countryToConvert).apply();
                preferences.edit().putString("currency", currencyToConvert).apply();
                preferences.edit().putString("countryCurrency", countryCurrency).apply();
                preferences.edit().putString("countrySymbol", countrySymbol).apply();


            }
        });
//        Handles EURO button operation - sets European values to preferences to be used by main Activity
        euruButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countryToConvert = "Euro Currency";
                currencyToConvert = "EURO";
                countryCurrency = "1.41";
                countrySymbol = "€";

                preferences.edit().putString("country", countryToConvert).apply();
                preferences.edit().putString("currency", currencyToConvert).apply();
                preferences.edit().putString("countryCurrency", countryCurrency).apply();
                preferences.edit().putString("countrySymbol", countrySymbol).apply();

            }
        });

//        Handles YEN button operation - sets Japanese values to preferences to be used by main Activity
        yenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countryToConvert = "Japanese Currency";
                currencyToConvert = "YEN";
                countryCurrency = "0.012";
                countrySymbol = "¥";

                preferences.edit().putString("country", countryToConvert).apply();
                preferences.edit().putString("currency", currencyToConvert).apply();
                preferences.edit().putString("countryCurrency", countryCurrency).apply();
                preferences.edit().putString("countrySymbol", countrySymbol).apply();

            }
        });

//        Handles SEK button operation - sets Swedish values to preferences to be used by main Activity
        sekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countryToConvert = "Swedish Krona Currency";
                currencyToConvert = "SEK";
                countryCurrency = "0.15";
                countrySymbol = "kr";

                preferences.edit().putString("country", countryToConvert).apply();
                preferences.edit().putString("currency", currencyToConvert).apply();
                preferences.edit().putString("countryCurrency", countryCurrency).apply();
                preferences.edit().putString("countrySymbol", countrySymbol).apply();

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Sets preferences value to remain when activity is 'stopped'

        preferences.edit().putString("country", countryToConvert).apply();
        preferences.edit().putString("currency", currencyToConvert).apply();
        preferences.edit().putString("countryCurrency", countryCurrency).apply();
        preferences.edit().putString("countrySymbol", countrySymbol).apply();
    }

//    Sets default values to be used when starting the program for the very first time
    @Override
    protected void onStart() {
        super.onStart();

        countryToConvert = "United States Dollars";
        currencyToConvert = "USD";
        countryCurrency = "1.29";
        countrySymbol = "$";

        preferences.edit().putString("country", countryToConvert).apply();
        preferences.edit().putString("currency", currencyToConvert).apply();
        preferences.edit().putString("countryCurrency", countryCurrency).apply();
        preferences.edit().putString("countrySymbol", countrySymbol).apply();
    }

/*
Back button for those that don't like built-in android back - also allows for possible IOS
version to be implemented
*/
    public void backHandler(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
