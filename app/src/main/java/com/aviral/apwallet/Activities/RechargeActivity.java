package com.aviral.apwallet.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.aviral.apwallet.RechargeFragments.MobileOperatorFragment;
import com.aviral.apwallet.RechargeFragments.RechargeAmountFragment;
import com.aviral.apwallet.RechargeFragments.RechargeSuccessfulFragment;
import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.ActivityRechargeBinding;

public class RechargeActivity extends AppCompatActivity{

    private final MobileOperatorFragment mobileOperatorFragment = new MobileOperatorFragment();
    private final RechargeAmountFragment rechargeAmountFragment = new RechargeAmountFragment();
    private final RechargeSuccessfulFragment rechargeSuccessfulFragment = new RechargeSuccessfulFragment();

    private final FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRechargeBinding binding = ActivityRechargeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_mobile_recharge, mobileOperatorFragment, "Mobile Operator Fragment")
                .commit();

        activeFragment = mobileOperatorFragment;

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_mobile_recharge, rechargeAmountFragment, "Recharge Amount Fragment")
                .hide(rechargeAmountFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_mobile_recharge, rechargeSuccessfulFragment, "Recharge Amount Fragment")
                .hide(rechargeSuccessfulFragment)
                .commit();
    }

    public void showRechargeAmountFragment() {
        fragmentManager.beginTransaction()
                .hide(activeFragment)
                .show(rechargeAmountFragment)
                .commit();

        activeFragment = rechargeAmountFragment;
    }

    public void showRechargeSuccessfulFragment() {
        fragmentManager.beginTransaction()
                .hide(activeFragment)
                .show(rechargeSuccessfulFragment)
                .commit();

        activeFragment = rechargeSuccessfulFragment;
    }
}