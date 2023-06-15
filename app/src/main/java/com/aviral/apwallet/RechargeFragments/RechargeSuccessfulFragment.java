package com.aviral.apwallet.RechargeFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aviral.apwallet.Activities.MainActivity;
import com.aviral.apwallet.databinding.FragmentRechargeSuccessfulBinding;

public class RechargeSuccessfulFragment extends Fragment {

    private FragmentRechargeSuccessfulBinding binding;

    public RechargeSuccessfulFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentRechargeSuccessfulBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnBackToHome.setOnClickListener(view1 -> startActivity(new Intent(requireActivity(), MainActivity.class)));
    }
}