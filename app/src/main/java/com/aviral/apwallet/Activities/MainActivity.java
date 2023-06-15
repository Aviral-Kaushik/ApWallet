package com.aviral.apwallet.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.aviral.apwallet.NavigationFragments.HomeFragment;
import com.aviral.apwallet.NavigationFragments.PeopleFragment;
import com.aviral.apwallet.NavigationFragments.ProfileFragment;
import com.aviral.apwallet.NavigationFragments.TransactionFragment;
import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private final HomeFragment homeFragment = new HomeFragment();
    private final TransactionFragment transactionFragment = new TransactionFragment();
    private final PeopleFragment peopleFragment = new PeopleFragment();
    private final ProfileFragment profileFragment = new ProfileFragment();

    private final FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager.beginTransaction()
                .add(R.id.frame_container, homeFragment, "Home Fragment")
                .commit();

        activeFragment = homeFragment;

        fragmentManager.beginTransaction()
                .add(R.id.frame_container, transactionFragment, "Transaction Fragment")
                .hide(transactionFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame_container, peopleFragment, "People Fragment")
                .hide(peopleFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame_container, profileFragment, "Profile Fragment")
                .hide(profileFragment)
                .commit();

        binding.bottomNavigationBar.setOnItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {

            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(homeFragment)
                    .commit();
            activeFragment = homeFragment;

        } else if (item.getItemId() == R.id.transaction) {

            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(transactionFragment)
                    .commit();
            activeFragment = transactionFragment;

        } else if (item.getItemId() == R.id.people) {

            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(peopleFragment)
                    .commit();
            activeFragment = peopleFragment;

        } else if (item.getItemId() == R.id.profile) {

            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(profileFragment)
                    .commit();
            activeFragment = profileFragment;


        }

        return true;

    }


}