package com.cybertech.practicelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cybertech.practicelistview.adapters.PersonAdapter;
import com.cybertech.practicelistview.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ListView personListView=null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    personListView = findViewById(R.id.personListView);

    PersonAdapter personAdapter = new PersonAdapter(getBaseContext(),getPersons());
    personListView.setAdapter(personAdapter);
    personListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Person person = ((PersonAdapter)adapterView.getAdapter()).getItem(i);
        Toast.makeText(getBaseContext(),person.toString(),Toast.LENGTH_LONG).show();
      }
    });


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
}
