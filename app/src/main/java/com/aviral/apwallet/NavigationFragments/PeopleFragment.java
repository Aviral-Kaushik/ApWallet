package com.aviral.apwallet.NavigationFragments;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
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

        setUpContactsAdapter();

    }

    @SuppressLint("Range")
    private void setUpContactsAdapter() {

        ArrayList<String> nameList = new ArrayList<>();
        ContentResolver cr = requireContext().getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if ((cur != null ? cur.getCount() : 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                @SuppressLint("Range") String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                @SuppressLint("Range") String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));
                nameList.add(name);
                if (cur.getInt(cur.getColumnIndex( ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                    pCur.close();
                }
            }
        }
        if (cur != null) {
            cur.close();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false
        );

        binding.contactsRecyclerView.setLayoutManager(linearLayoutManager);

        ContactsAdapter contactsAdapter = new ContactsAdapter(nameList);

        binding.contactsRecyclerView.setAdapter(contactsAdapter);

    }
}