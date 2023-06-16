package com.aviral.apwallet.SendMoneyFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aviral.apwallet.Activities.SendMoneyActivity;
import com.aviral.apwallet.databinding.FragmentBankTransferBinding;

public class BankTransferFragment extends Fragment {

    private FragmentBankTransferBinding binding;

    public BankTransferFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBankTransferBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnConfirmDetails.setOnClickListener(view1 -> ((SendMoneyActivity) requireActivity()).showTransferSuccessFragment());
    }
}