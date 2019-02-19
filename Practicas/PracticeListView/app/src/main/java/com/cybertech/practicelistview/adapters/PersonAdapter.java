package com.cybertech.practicelistview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cybertech.practicelistview.R;
import com.cybertech.practicelistview.model.Person;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {

  private Context context=null;
  private List<Person> persons=null;

  public PersonAdapter(@NonNull Context context, @NonNull List<Person> objects) {
    super(context, R.layout.item_person, objects);
    this.context=context;
    this.persons=objects;
  }

  @Override
  public int getCount() {
    if(persons==null || persons.size()==0)
      return 0;
    else
      return persons.size();
  }


  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view=convertView;
    PersonHolder personHolder;
    if(view==null){
      LayoutInflater inflater = (LayoutInflater) context
          .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      view=inflater.inflate(R.layout.item_person,null);
      personHolder = new PersonHolder();
      personHolder.personImageView=view.findViewById(R.id.person_imageView);
      personHolder.nameTextView=view.findViewById(R.id.name_textView);
      personHolder.lastnameTextView=view.findViewById(R.id.lastname_textView);
      view.setTag(personHolder);
    }else{
      personHolder=(PersonHolder)view.getTag();
    }

    personHolder.personImageView.setImageResource(R.mipmap.ic_launcher_round);
    personHolder.nameTextView.setText(persons.get(position).getName());
    personHolder.lastnameTextView.setText(persons.get(position).getLastname());

    return view;
  }

  static class PersonHolder{
    ImageView personImageView;
    TextView nameTextView;
    TextView lastnameTextView;
  }
}
