package com.aviral.apwallet.RechargeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aviral.apwallet.Activities.RechargeActivity;
import com.aviral.apwallet.databinding.FragmentMobileOperatorBinding;

public class MobileOperatorFragment extends Fragment {

    private FragmentMobileOperatorBinding binding;

    public MobileOperatorFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMobileOperatorBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.jio.setOnClickListener(view1-> ((RechargeActivity) requireActivity()).showRechargeAmountFragment());
        binding.airtel.setOnClickListener(view1-> ((RechargeActivity) requireActivity()).showRechargeAmountFragment());
        binding.vi.setOnClickListener(view1-> ((RechargeActivity) requireActivity()).showRechargeAmountFragment());
        binding.bsnl.setOnClickListener(view1-> ((RechargeActivity) requireActivity()).showRechargeAmountFragment());
    }
}