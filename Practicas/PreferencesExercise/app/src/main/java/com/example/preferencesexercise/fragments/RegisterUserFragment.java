package com.example.preferencesexercise.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.preferencesexercise.R;
import com.example.preferencesexercise.listener.OnSavedContactClickListener;
import com.example.preferencesexercise.model.Contact;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterUserFragment extends Fragment implements OnSavedContactClickListener {

    private TextInputLayout nameTextInputLayout;
    private TextInputLayout lastnameTextInputLayout;
    private TextInputLayout numberPhoneTextInputLayout;

    public RegisterUserFragment() {
        // Required empty public constructor
    }

    public static RegisterUserFragment newInstance() {
        RegisterUserFragment fragment = new RegisterUserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTextInputLayout=view.findViewById(R.id.name_TextView);
        lastnameTextInputLayout=view.findViewById(R.id.lastname_TextView);
        numberPhoneTextInputLayout=view.findViewById(R.id.number_phone_TextView);
    }

    @Override
    public void onClickContact() {
        String name = nameTextInputLayout.getEditText().getText().toString();
        String lastname = lastnameTextInputLayout.getEditText().getText().toString();
        String numberPhone = numberPhoneTextInputLayout.getEditText().getText().toString();

        if(TextUtils.isEmpty(name) && TextUtils.isEmpty(lastname)
                && TextUtils.isEmpty(numberPhone)){
            Toast.makeText(getContext(),"NO hay información",Toast.LENGTH_LONG).show();
        }else{
            saveContact(new Contact(0,name,lastname,numberPhone));
        }
    }

    private void saveContact(Contact contact){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(
                "ContactPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",contact.getName());
        editor.putString("lastname",contact.getLastname());
        editor.putString("numberPhone",contact.getNumberPhone());
        editor.commit();
    }
}
