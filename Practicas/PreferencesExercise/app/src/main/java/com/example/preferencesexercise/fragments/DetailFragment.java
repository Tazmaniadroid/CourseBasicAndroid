package com.example.preferencesexercise.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.preferencesexercise.R;
import com.example.preferencesexercise.model.Contact;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailFragment extends Fragment {

    private TextView nameDetailTextView=null;
    private TextView lastnameDetailTextView=null;
    private TextView numberPhoneDetailTextView=null;

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameDetailTextView = view.findViewById(R.id.name_detail_textView);
        lastnameDetailTextView = view.findViewById(R.id.lastname_detail_textView);
        numberPhoneDetailTextView = view.findViewById(R.id.number_phone_detail_textView);
        showContact();
    }

    private void showContact(){
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences(
                "ContactPreferences", Context.MODE_PRIVATE);
        Contact contact = new Contact(0,
                sharedPreferences.getString("name",""),
                sharedPreferences.getString("lastname",""),
                sharedPreferences.getString("numberPhone",""));
        nameDetailTextView.setText(contact.getName());
        lastnameDetailTextView.setText(contact.getLastname());
        numberPhoneDetailTextView.setText(contact.getNumberPhone());
    }
}
