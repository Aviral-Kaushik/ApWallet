package com.aviral.apwallet.AddMoneyFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aviral.apwallet.Activities.AddMoneyActivity;
import com.aviral.apwallet.R;
import com.aviral.apwallet.databinding.FragmentCardDetailsBinding;

public class CardDetailsFragment extends Fragment {

    private FragmentCardDetailsBinding binding;

    public CardDetailsFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCardDetailsBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnNext.setOnClickListener(view1 -> ((AddMoneyActivity) requireActivity()).showSuccessFragment());

    }
}