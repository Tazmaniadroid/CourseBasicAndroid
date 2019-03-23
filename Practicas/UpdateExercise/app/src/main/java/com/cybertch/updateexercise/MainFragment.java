package com.cybertch.updateexercise;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private RecyclerView personsRecyclerView=null;

    private List<Person> persons=null;
    private PersonAdapter personAdapter=null;

    public static final int RESULT_SAVED=283;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        persons=new ArrayList<>();
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
        personsRecyclerView = view.findViewById(R.id.personsRecyclerView);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false);
        personsRecyclerView.setHasFixedSize(true);
        personsRecyclerView.setLayoutManager(layoutManager);
        personAdapter = new PersonAdapter(persons);
        personsRecyclerView.setAdapter(personAdapter);
        personsRecyclerView.setLayoutFrozen(false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_SAVED){
            Person person = (Person)data.getSerializableExtra("Person");
            persons.add(person);
            personAdapter.notifyDataSetChanged();
        }
    }
}
