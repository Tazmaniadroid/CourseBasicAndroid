package com.cybertch.basedatosexercise.models;

/**
 * Description:
 * <p>
 * Project: BaseDatosExercise
 * Package: com.cybertch.basedatosexercise.models
 *
 * @author: Jaive Torres Pineda
 * dateCreated: 3/16/19
 * dateLastModified:
 * @version:
 * @since:
 **/
public class Contact {

    private int id=0;
    private String name=null;
    private String lastname=null;
    private String numberPhone=null;

    public Contact() {
    }

    public Contact(int id, String name, String lastname, String numberPhone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.numberPhone = numberPhone;
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
