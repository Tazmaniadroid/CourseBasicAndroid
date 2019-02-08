package com.cybertech.intentexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  public static final String NAME_KEY="nameKey";
  public static final String PASSWORD_KEY="passwordKey";
  public static final String DATA_KEY="dataKey";

  private EditText nameEditText = null;
  private EditText passwordEditText = null;
  private Button sendButton = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    nameEditText=findViewById(R.id.name_editText);
    passwordEditText=findViewById(R.id.password_editText);
    sendButton=findViewById(R.id.send_button);

    sendButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String name = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        //Paso 1
        Intent detailIntent=new Intent(MainActivity.this,DetailActivity.class);
        Bundle detailBundle=new Bundle();
        detailBundle.putString(NAME_KEY,name);
        detailBundle.putString(PASSWORD_KEY,password);
        detailIntent.putExtra(DATA_KEY,detailBundle);

        //Paso 2
        /*Intent detailIntent=new Intent(MainActivity.this,DetailActivity.class);
        detailIntent.putExtra(NAME_KEY,name);
        detailIntent.putExtra(PASSWORD_KEY,password);*/

        startActivity(detailIntent);
      }
    });

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });
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
}
