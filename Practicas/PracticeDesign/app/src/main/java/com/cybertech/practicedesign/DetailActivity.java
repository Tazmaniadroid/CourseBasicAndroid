package com.cybertech.practicedesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    Bundle userInformationBundle = getIntent().getExtras();
    String name = userInformationBundle.getString("name","");
    String lastname=userInformationBundle.getString("lastname","");
    String age=userInformationBundle.getString("age","");
    String address=userInformationBundle.getString("address","");
    String numberPhone=userInformationBundle.getString("numberPhone","");
    String email=userInformationBundle.getString("email","");
    char sex=userInformationBundle.getChar("sex",'M');
    ArrayList<String>interests=userInformationBundle.getStringArrayList("interest");
    String state=userInformationBundle.getString("state","");
    String country=userInformationBundle.getString("country","");

    Log.d("[DATA]",name+"|"+lastname+"|"+age+"|"+address+"|"+numberPhone+"|"+email+"|"+
        sex+"|"+interests.toString()+"|"+state+"|"+country);
  }
}
