package com.aviral.apwallet.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.ActivityPinBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class PinActivity extends AppCompatActivity {

    private ActivityPinBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String command = "";

        Intent intent = getIntent();

        if (intent.hasExtra(getString(R.string.command))) {
            command = intent.getStringExtra(getString(R.string.command));
        }

        String finalCommand = command;
        binding.btnNext.setOnClickListener(view -> {
            if (finalCommand.equals(getString(R.string.newUser))) {

                addPinToSharedPreferences();

            } else {

                verifyPinFromSharedPreferences();

            }
        });

        binding.btn0.setOnClickListener(view -> addToPin(0));
        binding.btn1.setOnClickListener(view -> addToPin(1));
        binding.btn2.setOnClickListener(view -> addToPin(2));
        binding.btn3.setOnClickListener(view -> addToPin(3));
        binding.btn4.setOnClickListener(view -> addToPin(4));
        binding.btn5.setOnClickListener(view -> addToPin(5));
        binding.btn6.setOnClickListener(view -> addToPin(6));
        binding.btn7.setOnClickListener(view -> addToPin(7));
        binding.btn8.setOnClickListener(view -> addToPin(8));
        binding.btn9.setOnClickListener(view -> addToPin(9));

        binding.btnClear.setOnClickListener(view -> binding.pin.setText(""));

    }

    private void addToPin(int i) {

        if(String.valueOf(binding.pin.getText()).length() != 4) {

            binding.pin.setText(String.format(Locale.US,"%s%d", binding.pin.getText(), i));

        }

    }

    private void addPinToSharedPreferences() {

        if (String.valueOf(binding.pin.getText()).length() == 4) {

            SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();

            myEdit.putInt("pin", Integer.parseInt(String.valueOf(binding.pin.getText())));
            myEdit.apply();

            startActivity(new Intent(this, MainActivity.class));

            finish();

        } else {

            Snackbar.make(
                    binding.layoutPin,
                    "Invalid Pin",
                    Snackbar.LENGTH_SHORT
            ).show();

        }

    }

    private void verifyPinFromSharedPreferences() {

        if (String.valueOf(binding.pin.getText()).length() == 4) {

            SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
            int pin = sharedPreferences.getInt("pin", 1111);

            if (Integer.parseInt(String.valueOf(binding.pin.getText())) == pin) {

                startActivity(new Intent(this, MainActivity.class));

                finish();

            } else {

                Snackbar.make(
                        binding.layoutPin,
                        "Wrong Pin",
                        Snackbar.LENGTH_SHORT
                ).show();

            }

        } else {

            Snackbar.make(
                    binding.layoutPin,
                    "Invalid Pin",
                    Snackbar.LENGTH_SHORT
            ).show();

        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        boolean isLogin = sharedPreferences.getBoolean("isUserLoggedIn", false);

        if (!isLogin) {
            startActivity(new Intent(this, SignupActivity.class));
        }

    }
}