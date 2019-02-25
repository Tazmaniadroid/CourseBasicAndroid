package com.cybertech.practicetoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cybertech.practicetoolbar.adapters.PersonAdapter;
import com.cybertech.practicetoolbar.listeners.OnClickPersonListener;
import com.cybertech.practicetoolbar.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickPersonListener {

  private RecyclerView personsRecyclerView=null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    personsRecyclerView=findViewById(R.id.persons_recyclerView);
    LinearLayoutManager layoutManager= new LinearLayoutManager(this,
        LinearLayoutManager.VERTICAL,false);
    personsRecyclerView.setHasFixedSize(true);
    personsRecyclerView.setLayoutManager(layoutManager);
    final PersonAdapter personAdapter = new PersonAdapter(getPersons());
    personsRecyclerView.setAdapter(personAdapter);
    personsRecyclerView.setLayoutFrozen(false);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        personAdapter.addPerson(57,"Josimar","Solano");
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
      Toast.makeText(getBaseContext(), "Settings", Toast.LENGTH_SHORT).show();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private List<Person> getPersons(){
    List<Person> persons=new ArrayList<>();
    persons.add(new Person(1,"Juan","Solis"));
    persons.add(new Person(2,"Janeth","Solis"));
    persons.add(new Person(3,"Jaive","Solis"));
    persons.add(new Person(4,"Jose","Solis"));
    persons.add(new Person(5,"Jorge","Solis"));
    persons.add(new Person(6,"Jandra","Solis"));
    persons.add(new Person(7,"Janitzia","Solis"));
    persons.add(new Person(8,"Jacaranda","Solis"));
    persons.add(new Person(9,"Jaro","Solis"));
    persons.add(new Person(10,"Jenma","Solis"));
    persons.add(new Person(11,"Janta","Solis"));
    persons.add(new Person(12,"Juanita","Solis"));

    return persons;
  }

  @Override
  public void onClickPerson(Person person) {
    /*Intent detailIntent= new Intent(MainActivity.this,DetailActivity.class);
    detailIntent.putExtra("Person",person);
    startActivity(detailIntent);*/

  }
}
