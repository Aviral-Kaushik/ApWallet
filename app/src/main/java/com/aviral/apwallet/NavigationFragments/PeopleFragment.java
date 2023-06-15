package com.aviral.apwallet.NavigationFragments;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aviral.apwallet.Adapter.ContactsAdapter;
import com.aviral.apwallet.Models.Contact;
import com.aviral.apwallet.databinding.FragmentPeopleBinding;

import java.util.ArrayList;

public class PeopleFragment extends Fragment {

    private FragmentPeopleBinding binding;

    public PeopleFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPeopleBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

//        setUpContactsAdapter();

    }

    private void setUpContactsAdapter() {

        ArrayList<Contact> contacts = new ArrayList<>();

        Cursor cursor = requireContext().getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                null, null, null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");



        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {

                @SuppressLint("Range")
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY));
                @SuppressLint("Range")
                String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                Contact contact = new Contact(name, phoneNumber);
                contacts.add(contact);

            }

            cursor.close();

        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false
        );

        binding.contactsRecyclerView.setLayoutManager(linearLayoutManager);

        ContactsAdapter contactsAdapter = new ContactsAdapter(contacts);

        binding.contactsRecyclerView.setAdapter(contactsAdapter);

    }
}