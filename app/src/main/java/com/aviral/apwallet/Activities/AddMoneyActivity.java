package com.aviral.apwallet.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.aviral.apwallet.AddMoneyFragment.CardDetailsFragment;
import com.aviral.apwallet.AddMoneyFragment.SuccessFragment;
import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.ActivityAddMoneyBinding;

public class AddMoneyActivity extends AppCompatActivity {

    private final CardDetailsFragment cardDetailsFragment = new CardDetailsFragment();
    private final SuccessFragment successFragment = new SuccessFragment();

    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddMoneyBinding binding = ActivityAddMoneyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_add_money, cardDetailsFragment, "Card Details Fragment")
                .commit();

        activeFragment = cardDetailsFragment;

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_add_money, successFragment, "Success Fragment")
                .hide(successFragment)
                .commit();

    }

    public void showSuccessFragment() {

        fragmentManager.beginTransaction()
                .hide(cardDetailsFragment)
                .show(successFragment)
                .commit();

        activeFragment = successFragment;

    }
}