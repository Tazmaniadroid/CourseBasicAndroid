package com.cybertch.updateexercise;

import android.os.Build;

import java.io.Serializable;
import java.util.Objects;

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
public class Person implements Serializable {

    private int id=0;
    private String name=null;
    private String lastname=null;
    private int age=0;
    private String numberPhone=null;
    private char sex;
    private String address=null;
    private String state=null;
    private String city=null;
    private String email=null;

    public Person() {
    }

    public Person(int id, String name, String lastname, int age, String numberPhone, char sex,
                  String address, String state, String city, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.numberPhone = numberPhone;
        this.sex = sex;
        this.address = address;
        this.state = state;
        this.city = city;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return id == person.id &&
                    age == person.age &&
                    sex == person.sex &&
                    Objects.equals(name, person.name) &&
                    Objects.equals(lastname, person.lastname) &&
                    Objects.equals(numberPhone, person.numberPhone) &&
                    Objects.equals(address, person.address) &&
                    Objects.equals(state, person.state) &&
                    Objects.equals(city, person.city) &&
                    Objects.equals(email, person.email);
        }else{
            return id== person.id && name.equals(person.name) && lastname.equals(person.lastname);
        }
    }

    @Override
    public int hashCode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Objects.hash(id, name, lastname, age, numberPhone, sex, address, state, city, email);
        }else{
            return id * 5 + name.hashCode();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", numberPhone='" + numberPhone + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
