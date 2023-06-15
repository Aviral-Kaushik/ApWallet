package com.aviral.apwallet.RechargeFragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aviral.apwallet.Activities.RechargeActivity;
import com.aviral.apwallet.databinding.FragmentRechargeAmountBinding;

public class RechargeAmountFragment extends Fragment {

    private FragmentRechargeAmountBinding binding;

    public RechargeAmountFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRechargeAmountBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnConfirmPayment.setOnClickListener(view1 -> {

            SharedPreferences sharedPreferences = requireContext().getSharedPreferences("user", Context.MODE_PRIVATE);
            int pin = sharedPreferences.getInt("pin", 1111);

            if (Integer.parseInt(String.valueOf(binding.editTextPin.getText())) == pin) {

                ((RechargeActivity) requireActivity()).showRechargeSuccessfulFragment();

            }

        });
    }
}