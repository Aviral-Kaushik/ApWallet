package com.aviral.apwallet.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.aviral.apwallet.databinding.ActivityChangePinBinding;
import com.google.android.material.snackbar.Snackbar;

public class ChangePinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChangePinBinding binding = ActivityChangePinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnChangePin.setOnClickListener(view -> {

            if (String.valueOf(binding.newPin.getText())
                    .equals(String.valueOf(binding.confirmNewPin.getText()))) {

                SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                int pin = sharedPreferences.getInt("pin", 1111);

                if (Integer.parseInt(String.valueOf(binding.currentPin.getText())) == pin) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putInt("pin", Integer.parseInt(String.valueOf(binding.newPin.getText())));

                    editor.apply();

                    Snackbar.make(
                            binding.layoutChangePin,
                            "Your pin has been changed successfully",
                            Snackbar.LENGTH_SHORT
                    ).show();

                    finish();

                } else {

                    Snackbar.make(
                            binding.layoutChangePin,
                            "Invalid current pin",
                            Snackbar.LENGTH_SHORT
                    ).show();

                }

            } else {

                Snackbar.make(
                        binding.layoutChangePin,
                        "New pin doesn't match",
                        Snackbar.LENGTH_SHORT
                ).show();

            }

        });
    }
}