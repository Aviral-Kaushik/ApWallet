package com.aviral.apwallet.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignupBinding binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnNext.setOnClickListener(view -> addUserToSharedPreferences());
    }

    private void addUserToSharedPreferences() {

        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putBoolean("isUserLoggedIn", true);
        myEdit.apply();

        Intent intent = new Intent(this, PinActivity.class);
        intent.putExtra(getString(R.string.command), getString(R.string.newUser));
        startActivity(intent);

    }
}