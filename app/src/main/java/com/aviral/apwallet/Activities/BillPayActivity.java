package com.aviral.apwallet.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.aviral.apwallet.BillPayFragments.BillSuccessfulFragment;
import com.aviral.apwallet.BillPayFragments.BillTransactionFragment;
import com.aviral.apwallet.BillPayFragments.ChooseBillFragment;
import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.ActivityBillPayBinding;

public class BillPayActivity extends AppCompatActivity {

    private final ChooseBillFragment chooseBillFragment = new ChooseBillFragment();
    private final BillTransactionFragment billTransactionFragment = new BillTransactionFragment();
    private final BillSuccessfulFragment billSuccessfulFragment = new BillSuccessfulFragment();

    private final FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBillPayBinding binding = ActivityBillPayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_pay_bill, chooseBillFragment, "Choose Bill Fragment")
                .commit();

        activeFragment = chooseBillFragment;

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_pay_bill, billTransactionFragment, "Bill Transaction Fragment")
                .hide(billTransactionFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_pay_bill, billSuccessfulFragment, "Bill Successful Fragment")
                .hide(billSuccessfulFragment)
                .commit();
    }

    public void showBllTransactionFragment() {
        fragmentManager.beginTransaction()
                .hide(activeFragment)
                .show(billTransactionFragment)
                .commit();

        activeFragment = billTransactionFragment;
    }

    public void showBllSuccessfulFragment() {
        fragmentManager.beginTransaction()
                .hide(activeFragment)
                .show(billSuccessfulFragment)
                .commit();

        activeFragment = billSuccessfulFragment;
    }
}