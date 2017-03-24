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

                preferences.edit().putString("country", countryToConvert).apply();
                preferences.edit().putString("currency", currencyToConvert).apply();
                preferences.edit().putString("countryCurrency", countryCurrency).apply();


            }
        });

        euruButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countryToConvert = "Euro Currency";
                currencyToConvert = "EURO";
                countryCurrency = "1.41";

                preferences.edit().putString("country", countryToConvert).apply();
                preferences.edit().putString("currency", currencyToConvert).apply();
                preferences.edit().putString("countryCurrency", countryCurrency).apply();

            }
        });

        yenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countryToConvert = "Japanese Currency";
                currencyToConvert = "YEN";
                countryCurrency = "0.012";

                preferences.edit().putString("country", countryToConvert).apply();
                preferences.edit().putString("currency", currencyToConvert).apply();
                preferences.edit().putString("countryCurrency", countryCurrency).apply();

            }
        });

        sekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countryToConvert = "Swedish Krona Currency";
                currencyToConvert = "SEK";
                countryCurrency = "0.15";

                preferences.edit().putString("country", countryToConvert).apply();
                preferences.edit().putString("currency", currencyToConvert).apply();
                preferences.edit().putString("countryCurrency", countryCurrency).apply();

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
    }

    @Override
    protected void onStart() {
        super.onStart();

        countryToConvert = "United States Dollars";
        currencyToConvert = "USD";
        countryCurrency = "1.29";

        preferences.edit().putString("country", countryToConvert).apply();
        preferences.edit().putString("currency", currencyToConvert).apply();
        preferences.edit().putString("countryCurrency", countryCurrency).apply();
    }

    public void backHandler(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
