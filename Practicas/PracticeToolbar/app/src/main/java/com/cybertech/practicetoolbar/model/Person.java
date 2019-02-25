package com.cybertech.practicetoolbar.model;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

  private int id=0;
  private String name=null;
  private String lastname=null;

  public Person(){

  }

  public Person(int id, String name, String lastname){
    this.id=id;
    this.name=name;
    this.lastname=lastname;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  @Override
  public String toString() {
    return this.name+ " "+this.lastname;
  }

  @TargetApi(Build.VERSION_CODES.KITKAT)
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return id == person.id &&
        Objects.equals(name, person.name) &&
        Objects.equals(lastname, person.lastname);
  }

  @TargetApi(Build.VERSION_CODES.KITKAT)
  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname);
  }
}
