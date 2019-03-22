package com.cybertch.basedatosexercise.fragments;


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

import com.cybertch.basedatosexercise.R;
import com.cybertch.basedatosexercise.databases.BDHelper;
import com.cybertch.basedatosexercise.listener.OnSavedContactClickListener;
import com.cybertch.basedatosexercise.models.Contact;

public class MainFragment extends Fragment implements OnSavedContactClickListener {
    private TextInputLayout nameTextInputLayout;
    private TextInputLayout lastnameTextInputLayout;
    private TextInputLayout numberPhoneTextInputLayout;

    private BDHelper bdHelper=null;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bdHelper = new BDHelper(getActivity(),BDHelper.MODE_WRITE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
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
            saveContact(new Contact(1,name,lastname,numberPhone));
        }
    }

    private void saveContact(Contact contact){
        if(bdHelper.insert(contact)){
            Toast.makeText(getContext(),"INSERTADO",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(),"NO INSERTADO",Toast.LENGTH_SHORT).show();
        }
    }

}
