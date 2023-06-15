package com.aviral.apwallet.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.aviral.apwallet.R;
import com.aviral.apwallet.SendMoneyFragments.BankDetailsFragment;
import com.aviral.apwallet.SendMoneyFragments.BankTransferFragment;
import com.aviral.apwallet.SendMoneyFragments.TransferSuccessFragment;
import com.aviral.apwallet.databinding.ActivitySendMoneyBinding;

public class SendMoneyActivity extends AppCompatActivity {

    private final BankDetailsFragment bankDetailsFragment = new BankDetailsFragment();
    private final BankTransferFragment bankTransferFragment = new BankTransferFragment();
    private final TransferSuccessFragment transferSuccessFragment = new TransferSuccessFragment();

    private final FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySendMoneyBinding binding = ActivitySendMoneyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_send_money, bankDetailsFragment, "Bank Details Fragment")
                .commit();

        activeFragment = bankDetailsFragment;

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_send_money, bankTransferFragment, "Bank Transaction Fragment")
                .hide(bankTransferFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame_container_send_money, transferSuccessFragment, "Transfer Success Fragment")
                .hide(transferSuccessFragment)
                .commit();
    }

    public void showBankTransferFragment() {

        fragmentManager.beginTransaction()
                .hide(activeFragment)
                .show(bankTransferFragment)
                .commit();

        activeFragment = bankTransferFragment;

    }

    public void showTransferSuccessFragment() {

        fragmentManager.beginTransaction()
                .hide(activeFragment)
                .show(transferSuccessFragment)
                .commit();

        activeFragment = transferSuccessFragment;

    }
}