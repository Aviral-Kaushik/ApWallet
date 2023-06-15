package com.aviral.apwallet.BillPayFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aviral.apwallet.Activities.BillPayActivity;
import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.FragmentBillTransactionBinding;

public class BillTransactionFragment extends Fragment {

    private FragmentBillTransactionBinding binding;

    public BillTransactionFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBillTransactionBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnConfirmPayment.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllSuccessfulFragment());
    }
}