package com.aviral.apwallet.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aviral.apwallet.databinding.ActivityAddMoneyBinding;

public class AddMoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddMoneyBinding binding = ActivityAddMoneyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}