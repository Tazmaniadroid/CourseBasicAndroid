package com.cybertch.updateexercise;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Description:
 * <p>
 * Project: UpdateExercise
 * Package: com.cybertch.updateexercise
 *
 * @author: Jaive Torres Pineda
 * dateCreated: 3/23/19
 * dateLastModified:
 * @version:
 * @since:
 **/
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> persons = null;
    private PersonOnClickListener personOnClickListener=null;

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
        personViewHolder.nameTextView.setText(persons.get(i).getName());
        personViewHolder.lastnameTextView.setText(persons.get(i).getLastname());
        personViewHolder.setPerson(persons.get(i));
        personViewHolder.setPersonOnClickListener(personOnClickListener);
    }

    @Override
    public int getItemCount() {
        if (persons == null && persons.isEmpty())
            return 0;
        else
            return persons.size();
    }

    public void setPersonOnClickListener(PersonOnClickListener personOnClickListener) {
        this.personOnClickListener = personOnClickListener;
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder {

        protected TextView nameTextView = null;
        protected TextView lastnameTextView = null;
        private Person person=null;
        private PersonOnClickListener personOnClickListener=null;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            lastnameTextView = itemView.findViewById(R.id.lastnameTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(personOnClickListener!=null)
                        personOnClickListener.OnClickPerson(person);
                }
            });
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public void setPersonOnClickListener(PersonOnClickListener personOnClickListener) {
            this.personOnClickListener = personOnClickListener;
        }
    }
}
