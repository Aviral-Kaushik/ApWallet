package com.aviral.apwallet.NavigationFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aviral.apwallet.Adapter.TransactionAdapter;
import com.aviral.apwallet.Models.Transaction;
import com.aviral.apwallet.databinding.FragmentTransactionBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class TransactionFragment extends Fragment {

    private FragmentTransactionBinding binding;

    public TransactionFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTransactionBinding.inflate(inflater, container, false);

        binding.btnSendHistory.setOnClickListener(view -> {
            Snackbar.make(
                    binding.layoutTransaction,
                    "Your transaction history has been send to your E-Mail",
                    Snackbar.LENGTH_SHORT
            ).show();
        });

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

        setUpTransactionAdapter();
    }

    private void setUpTransactionAdapter() {

        ArrayList<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(
           "RE-CHARGE",
           "012978xxxxxxx",
           "+  Rs. 50",
           "#2EB723"
        ));

        transactions.add(new Transaction(
                "ONLINE SHOP",
                "011234xxxxxxx",
                "-  Rs. 100",
                "#AC0505"
        ));

        transactions.add(new Transaction(
                "Goods Shopping",
                "059681xxxxxx",
                "-  Rs. 1,599",
                "#AC0505"
        ));

        transactions.add(new Transaction(
                "Phone Pe",
                "028796xxxxxx",
                "+ Rs. 11,520",
                "#2EB723"
        ));

        transactions.add(new Transaction(
                "Amazon Online",
                "038594xxxxxx",
                "+ Rs. 5,565",
                "#2EB723"
        ));

        transactions.add(new Transaction(
                "RE-CHARGE",
                "011234xxxxxxx",
                "-  Rs. 469",
                "#AC0505"
        ));

        transactions.add(new Transaction(
                "Salary",
                "065894xxxxxx",
                "+  Rs. 33,500",
                "#2EB723"
        ));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false
        );

        binding.transactionRecyclerView.setLayoutManager(linearLayoutManager);

        TransactionAdapter transactionAdapter = new TransactionAdapter(transactions);

        binding.transactionRecyclerView.setAdapter(transactionAdapter);

    }
}