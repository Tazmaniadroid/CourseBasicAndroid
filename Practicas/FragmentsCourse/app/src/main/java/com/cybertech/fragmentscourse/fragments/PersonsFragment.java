package com.cybertech.fragmentscourse.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.cybertech.fragmentscourse.DetailActivity;
import com.cybertech.fragmentscourse.R;
import com.cybertech.fragmentscourse.adapters.PersonAdapter;
import com.cybertech.fragmentscourse.listeners.OnClickPersonListener;
import com.cybertech.fragmentscourse.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonsFragment extends Fragment {

  private RecyclerView personsRecyclerView = null;

  public PersonsFragment() {
    // Required empty public constructor
  }

  // TODO: Rename and change types and number of parameters
  public static PersonsFragment newInstance() {
    PersonsFragment fragment = new PersonsFragment();
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_persons, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    personsRecyclerView = view.findViewById(R.id.persons_recyclerView);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
        LinearLayoutManager.VERTICAL, false);
    personsRecyclerView.setHasFixedSize(true);
    personsRecyclerView.setLayoutManager(layoutManager);
    final PersonAdapter personAdapter = new PersonAdapter(getPersons());
    personAdapter.setOnClickPersonListener(new OnClickPersonListener() {
      @Override
      public void onClickPerson(Person person) {
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        if (isTablet) {
          Log.d("[Test]", "Es tableta");
          DetailFragment detailFragment = DetailFragment.newInstance(person);

          getActivity().getSupportFragmentManager().beginTransaction()
              .replace(R.id.detail_person_container, detailFragment, "PersonViewm")
              .commit();


        } else {
          Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
          detailIntent.putExtra("Person",person);
          startActivity(detailIntent);
        }
      }
    });
    personsRecyclerView.setAdapter(personAdapter);
    personsRecyclerView.setLayoutFrozen(false);
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
  }

  private List<Person> getPersons() {
    List<Person> persons = new ArrayList<>();
    persons.add(new Person(1, "Juan", "Solis"));
    persons.add(new Person(2, "Janeth", "Solis"));
    persons.add(new Person(3, "Jaive", "Solis"));
    persons.add(new Person(4, "Jose", "Solis"));
    persons.add(new Person(5, "Jorge", "Solis"));
    persons.add(new Person(6, "Jandra", "Solis"));
    persons.add(new Person(7, "Janitzia", "Solis"));
    persons.add(new Person(8, "Jacaranda", "Solis"));
    persons.add(new Person(9, "Jaro", "Solis"));
    persons.add(new Person(10, "Jenma", "Solis"));
    persons.add(new Person(11, "Janta", "Solis"));
    persons.add(new Person(12, "Juanita", "Solis"));

    return persons;
  }
}
