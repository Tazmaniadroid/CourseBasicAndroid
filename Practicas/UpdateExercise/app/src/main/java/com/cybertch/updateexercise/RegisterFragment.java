package com.cybertch.updateexercise;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import static com.cybertch.updateexercise.MainFragment.RESULT_SAVED;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    private TextInputLayout nameTextInputLayout = null;
    private TextInputLayout lastnameTextInputLayout = null;
    private TextInputLayout ageTextInputLayout = null;
    private TextInputLayout numberPhoneTextInputLayout = null;
    private RadioGroup sexRadioGroup = null;
    private TextInputLayout addressTextInputLayout = null;
    private AppCompatSpinner stateAppCompatSpinner = null;
    private AppCompatSpinner countryAppCompatSpinner = null;
    private TextInputLayout emailTextInputLayout = null;
    private AppCompatCheckBox spanishAppCompatCheckBox = null;
    private AppCompatCheckBox mathematicsAppCompatCheckBox = null;
    private AppCompatCheckBox historyAppCompatCheckBox = null;
    private AppCompatCheckBox geographyAppCompatCheckBox = null;
    private AppCompatCheckBox biologyAppCompatCheckBox = null;
    private AppCompatCheckBox anatomyAppCompatCheckBox = null;
    private Button sendButton = null;

    private char sex = 'M';
    private String state = null;
    private String country = null;

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
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
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameTextInputLayout = view.findViewById(R.id.name_TextInputLayout);
        lastnameTextInputLayout = view.findViewById(R.id.lastname_TextInputLayout);
        ageTextInputLayout = view.findViewById(R.id.age_TextInputLayout);
        numberPhoneTextInputLayout = view.findViewById(R.id.number_phone_TextInputLayout);
        sexRadioGroup = view.findViewById(R.id.sex_RadioGroup);
        addressTextInputLayout = view.findViewById(R.id.address_TextInputLayout);
        stateAppCompatSpinner = view.findViewById(R.id.state_AppCompatSpinner);
        countryAppCompatSpinner = view.findViewById(R.id.country_AppCompatSpinner);
        emailTextInputLayout = view.findViewById(R.id.email_TextInputLayout);
        spanishAppCompatCheckBox = view.findViewById(R.id.spanish_CheckBox);
        mathematicsAppCompatCheckBox = view.findViewById(R.id.mathematics_CheckBox);
        historyAppCompatCheckBox = view.findViewById(R.id.history_CheckBox);
        geographyAppCompatCheckBox = view.findViewById(R.id.geography_CheckBox);
        biologyAppCompatCheckBox = view.findViewById(R.id.biology_CheckBox);
        anatomyAppCompatCheckBox = view.findViewById(R.id.anatomy_CheckBox);
        sendButton = view.findViewById(R.id.send_Button);

        setCountrySpinner();
        addSexListener();
        addStateListener();
        addCountryListener();
        addSendListener();
    }

    private void setCountrySpinner(){
        List<String> countries=new ArrayList<String>();
        countries.add("Álvaro Obregón");
        countries.add("Benito Juárez");
        countries.add("Coyoacán");
        countries.add("Iztapalapa");
        countries.add("Cuahutemóc");

        ArrayAdapter<String> countryArrayAdapter= new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,countries);
        countryArrayAdapter.setDropDownViewResource(android.R.
                layout.simple_spinner_dropdown_item);
        countryAppCompatSpinner.setAdapter(countryArrayAdapter);
    }

    private boolean validateName(String name){
        if(TextUtils.isEmpty(name)){
            return false;
        }else{
            return true;
        }
    }

    private void addSexListener(){
        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.male_radioButton:
                        sex='M';
                        break;
                    case R.id.female_radioButton:
                        sex='F';
                        break;
                }
            }
        });
    }

    private void addStateListener(){
        stateAppCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                state = (String) adapterView.getAdapter().getItem(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addCountryListener(){
        countryAppCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                country = (String)countryAppCompatSpinner.getAdapter().getItem(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addSendListener(){
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSendInformation=false;
                String name =nameTextInputLayout.getEditText().getText().toString();
                String lastname = lastnameTextInputLayout.getEditText().getText().toString();
                String age = ageTextInputLayout.getEditText().getText().toString();
                String numberPhone = numberPhoneTextInputLayout.getEditText().getText().toString();
                String email = emailTextInputLayout.getEditText().getText().toString();
                String address = addressTextInputLayout.getEditText().getText().toString();

                if(validateName(name)){
                    nameTextInputLayout.setError("");
                    nameTextInputLayout.setErrorEnabled(false);
                    isSendInformation=true;
                }else{
                    nameTextInputLayout.setError("EL nombre no es valido");
                    nameTextInputLayout.setErrorEnabled(true);
                    isSendInformation=false;
                }

                if(isSendInformation){
                    Intent detailIntent=new Intent();
                    Person person = new Person(1,name,lastname,Integer.parseInt(age),
                            numberPhone, sex, address,state, country,email);
                    detailIntent.putExtra("Person",person);
                    getActivity().setResult(RESULT_SAVED,detailIntent);
                    getActivity().finish();
                }
            }
        });
    }
}
