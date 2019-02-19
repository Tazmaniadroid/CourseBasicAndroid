package com.cybertech.practicedesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

  private char sex='M';
  private String state=null;
  private String country=null;

  private ArrayList<String> interest= new ArrayList<>();

  private CompoundButton.OnCheckedChangeListener interestOnCheckedChangeListener = new
      CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
          switch (compoundButton.getId()){
            case R.id.spanish_CheckBox:
              addInterest("Español",b);
              break;
            case R.id.mathematics_CheckBox:
              addInterest("Matematicas",b);
              break;
            case R.id.history_CheckBox:
              addInterest("Historia",b);
              break;
            case R.id.geography_CheckBox:
              addInterest("Geografia",b);
              break;
            case R.id.biology_CheckBox:
              addInterest("Biologia",b);
              break;
            case R.id.anatomy_CheckBox:
              addInterest("Anatomia",b);
              break;
          }
        }
      };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    nameTextInputLayout = findViewById(R.id.name_TextInputLayout);
    lastnameTextInputLayout = findViewById(R.id.lastname_TextInputLayout);
    ageTextInputLayout = findViewById(R.id.age_TextInputLayout);
    numberPhoneTextInputLayout = findViewById(R.id.number_phone_TextInputLayout);
    sexRadioGroup = findViewById(R.id.sex_RadioGroup);
    addressTextInputLayout = findViewById(R.id.address_TextInputLayout);
    stateAppCompatSpinner = findViewById(R.id.state_AppCompatSpinner);
    countryAppCompatSpinner = findViewById(R.id.country_AppCompatSpinner);
    emailTextInputLayout = findViewById(R.id.email_TextInputLayout);
    spanishAppCompatCheckBox = findViewById(R.id.spanish_CheckBox);
    mathematicsAppCompatCheckBox = findViewById(R.id.mathematics_CheckBox);
    historyAppCompatCheckBox = findViewById(R.id.history_CheckBox);
    geographyAppCompatCheckBox = findViewById(R.id.geography_CheckBox);
    biologyAppCompatCheckBox = findViewById(R.id.biology_CheckBox);
    anatomyAppCompatCheckBox = findViewById(R.id.anatomy_CheckBox);
    sendButton = findViewById(R.id.send_Button);

    setCountrySpinner();
    addSexListener();
    addStateListener();
    addCountryListener();
    setInterestListener();
    addSendListener();

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private void setCountrySpinner(){
    List<String> countries=new ArrayList<String>();
    countries.add("Álvaro Obregón");
    countries.add("Benito Juárez");
    countries.add("Coyoacán");
    countries.add("Iztapalapa");
    countries.add("Cuahutemóc");

    ArrayAdapter<String> countryArrayAdapter= new ArrayAdapter<String>(this,
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

  private void addInterest(String interestSelected, boolean isChecked){
    if(isChecked){
      if(!interest.contains(interestSelected))
        interest.add(interestSelected);
    }else{
      if(interest.contains(interestSelected))
        interest.remove(interestSelected);
    }

  }

  private void setInterestListener(){
    spanishAppCompatCheckBox.setOnCheckedChangeListener(interestOnCheckedChangeListener);
    mathematicsAppCompatCheckBox.setOnCheckedChangeListener(interestOnCheckedChangeListener);
    historyAppCompatCheckBox.setOnCheckedChangeListener(interestOnCheckedChangeListener);
    biologyAppCompatCheckBox.setOnCheckedChangeListener(interestOnCheckedChangeListener);
    geographyAppCompatCheckBox.setOnCheckedChangeListener(interestOnCheckedChangeListener);
    anatomyAppCompatCheckBox.setOnCheckedChangeListener(interestOnCheckedChangeListener);
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
          Intent detailIntent=new Intent(MainActivity.this,
              DetailActivity.class);
          detailIntent.putExtra("name",name);
          detailIntent.putExtra("lastname",lastname);
          detailIntent.putExtra("age",age);
          detailIntent.putExtra("address",address);
          detailIntent.putExtra("numberPhone",numberPhone);
          detailIntent.putExtra("email",email);
          detailIntent.putExtra("sex",sex);
          detailIntent.putExtra("interest",interest);
          detailIntent.putExtra("state",state);
          detailIntent.putExtra("country",country);
          startActivity(detailIntent);
        }
      }
    });
  }
}
