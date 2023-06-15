package com.aviral.apwallet.NavigationFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aviral.apwallet.Activities.ChangePinActivity;
import com.aviral.apwallet.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tvChangePin.setOnClickListener(view1 -> startActivity(new Intent(requireContext(), ChangePinActivity.class)));
        binding.ivChangePin.setOnClickListener(view1 -> startActivity(new Intent(requireContext(), ChangePinActivity.class)));


    }


}