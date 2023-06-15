package com.aviral.apwallet.BillPayFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aviral.apwallet.Activities.BillPayActivity;
import com.aviral.apwallet.databinding.FragmentChooseBillBinding;

public class ChooseBillFragment extends Fragment {

    private FragmentChooseBillBinding binding;

    public ChooseBillFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChooseBillBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnElectricity.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllTransactionFragment());
        binding.btnGas.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllTransactionFragment());
        binding.btnPrepaid.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllTransactionFragment());
        binding.btnDth.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllTransactionFragment());
        binding.btnPostpaid.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllTransactionFragment());
        binding.btnPipedGas.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllTransactionFragment());
        binding.btnFastTag.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllTransactionFragment());
        binding.btnWater.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllTransactionFragment());
        binding.btnCableTv.setOnClickListener(view1 -> ((BillPayActivity) requireActivity()).showBllTransactionFragment());

    }
}