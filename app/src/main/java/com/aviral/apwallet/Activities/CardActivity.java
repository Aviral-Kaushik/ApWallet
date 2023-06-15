package com.aviral.apwallet.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.ActivityCardBinding;
import com.google.android.material.snackbar.Snackbar;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCardBinding binding = ActivityCardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.card_type, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        binding.cardTypeSpinner.setAdapter(adapter);

        binding.imageView33.setOnClickListener(view -> finish());

        binding.btnApplyNow.setOnClickListener(view -> Snackbar.make(
                binding.layoutCard,
                "Your Request for new card has been initiated!",
                Snackbar.LENGTH_SHORT
        ).show());

        binding.btnBlock.setOnClickListener(view -> Snackbar.make(
                binding.layoutCard,
                "Your all transaction from this card all blocked!",
                Snackbar.LENGTH_SHORT
        ).show());
    }
}