package com.cybertech.fragmentscourse.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cybertech.fragmentscourse.R;
import com.cybertech.fragmentscourse.listeners.OnClickPersonListener;
import com.cybertech.fragmentscourse.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

  private List<Person> persons = null;
  private OnClickPersonListener onClickPersonListener=null;

  public PersonAdapter(List<Person> persons) {
    this.persons = persons;
  }

  @NonNull
  @Override
  public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View item = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_person, viewGroup, false);
    return new PersonViewHolder(item);
  }

  @Override
  public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int i) {
    personViewHolder.personImageView.setImageResource(R.mipmap.ic_launcher);
    personViewHolder.nameTextView.setText(persons.get(i).getName());
    personViewHolder.lastnameTextView.setText(persons.get(i).getLastname());
    personViewHolder.setOnClickPersonListener(onClickPersonListener);
    personViewHolder.setPerson(persons.get(i));
  }

  @Override
  public int getItemCount() {
    if (persons != null && !persons.isEmpty())
      return persons.size();
    else
      return 0;
  }

  public void addPerson(int id, String name, String lastname){
    persons.add(1,new Person(id,name,lastname));
    notifyItemInserted(1);
  }

  public void setOnClickPersonListener(OnClickPersonListener onClickPersonListener) {
    this.onClickPersonListener = onClickPersonListener;
  }

  static class PersonViewHolder extends RecyclerView.ViewHolder {

    protected ImageView personImageView;
    protected TextView nameTextView;
    protected TextView lastnameTextView;

    private OnClickPersonListener onClickPersonListener;
    private Person person;

    public PersonViewHolder(@NonNull final View itemView) {
      super(itemView);
      personImageView = itemView.findViewById(R.id.person_imageView);
      nameTextView = itemView.findViewById(R.id.name_textView);
      lastnameTextView = itemView.findViewById(R.id.lastname_textView);

      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if(onClickPersonListener!=null){
            onClickPersonListener.onClickPerson(person);
          }
        }
      });
    }

    public void setOnClickPersonListener(OnClickPersonListener onClickPersonListener) {
      this.onClickPersonListener = onClickPersonListener;
    }

    public void setPerson(Person person) {
      this.person = person;
    }
  }
}
