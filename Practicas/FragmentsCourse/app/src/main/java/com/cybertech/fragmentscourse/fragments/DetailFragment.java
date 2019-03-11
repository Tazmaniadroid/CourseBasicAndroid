package com.cybertech.fragmentscourse.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cybertech.fragmentscourse.R;
import com.cybertech.fragmentscourse.model.Person;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PERSON = "person";

  // TODO: Rename and change types of parameters
  private Person person;

  private TextView nameTextView=null;

  public DetailFragment() {
    // Required empty public constructor
  }

  public static DetailFragment newInstance(Person person) {
    DetailFragment fragment = new DetailFragment();
    Bundle args = new Bundle();
    args.putSerializable(ARG_PERSON,person);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      person = (Person) getArguments().getSerializable(ARG_PERSON);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_detail, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    nameTextView = view.findViewById(R.id.name_textView);
    if(person!=null){
      nameTextView.setText(person.getName()+" "+person.getLastname());
    }
  }
}
