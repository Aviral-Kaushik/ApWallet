package com.aviral.apwallet.AddMoneyFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aviral.apwallet.Activities.MainActivity;
import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.FragmentSuccessBinding;

public class SuccessFragment extends Fragment {

    private FragmentSuccessBinding binding;

    public SuccessFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSuccessBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnBackToHome.setOnClickListener(view1 -> startActivity(new Intent(requireActivity(), MainActivity.class)));
    }
}