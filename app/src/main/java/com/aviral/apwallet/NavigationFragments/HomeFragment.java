package com.aviral.apwallet.NavigationFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aviral.apwallet.Activities.AddMoneyActivity;
import com.aviral.apwallet.Activities.BillPayActivity;
import com.aviral.apwallet.Activities.CardActivity;
import com.aviral.apwallet.Activities.RechargeActivity;
import com.aviral.apwallet.Activities.SendMoneyActivity;
import com.aviral.apwallet.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnAddMoney.setOnClickListener(view1 -> startActivity(
                new Intent(requireContext(), AddMoneyActivity.class)));

        binding.btnMobileRecharge.setOnClickListener(view1 -> startActivity(
                new Intent(requireContext(), RechargeActivity.class)));

        binding.btnBillPayment.setOnClickListener(view1 -> startActivity(
                new Intent(requireContext(), BillPayActivity.class)));

        binding.btnCards.setOnClickListener(view1 -> startActivity(
                new Intent(requireContext(), CardActivity.class)));

        binding.btnSendMoney.setOnClickListener(view1 -> startActivity(
                new Intent(requireContext(), SendMoneyActivity.class)));

    }
}