package com.aviral.apwallet.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aviral.apwallet.Models.Transaction;
import com.aviral.apwallet.R;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private final ArrayList<Transaction> transactions;

    public TransactionAdapter(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_transaction,
                parent,
                false
        );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.transaction.setText(transactions.get(position).getTransaction());
        holder.transactionNumber.setText(transactions.get(position).getTransactionNumber());
        holder.transactionAmount.setText(transactions.get(position).getTransactionAmount());

        holder.transactionAmount.setTextColor(Color.parseColor(transactions.get(position).getTransactionAmountColor()));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView transaction;
        public final TextView transactionNumber;
        public final TextView transactionAmount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            transaction = itemView.findViewById(R.id.transaction);
            transactionNumber = itemView.findViewById(R.id.transaction_number);
            transactionAmount = itemView.findViewById(R.id.transaction_amount);

        }
    }

}
