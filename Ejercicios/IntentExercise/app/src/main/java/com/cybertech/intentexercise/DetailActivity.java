package com.cybertech.intentexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

  private TextView nameTextView=null;
  private TextView passwordTextView=null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    nameTextView=findViewById(R.id.name_textView);
    passwordTextView=findViewById(R.id.password_textView);

    //Paso 1
    Bundle detailBundle = getIntent().getBundleExtra(MainActivity.DATA_KEY);
    if(detailBundle!=null) {
      nameTextView.setText(detailBundle.getString(MainActivity.NAME_KEY));
      passwordTextView.setText(detailBundle.getString(MainActivity.PASSWORD_KEY));
    }

    //Paso 2
    /*Bundle detailBundle = getIntent().getExtras();
    if(detailBundle!=null) {
      nameTextView.setText(detailBundle.getString(MainActivity.NAME_KEY));
      passwordTextView.setText(detailBundle.getString(MainActivity.PASSWORD_KEY));
    }*/

  }
}
