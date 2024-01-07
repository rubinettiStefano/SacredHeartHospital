package com.generation.entities;

import java.time.LocalDate;

public abstract class Person {
   
    protected int id;
    protected String name;
    protected String surname;
    protected LocalDate dob;
    
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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDob(String dob_string)
    {
        this.dob = LocalDate.parse(dob_string);
    }

    public boolean isValid(){
        
        return id>0 && name!=null && !name.isBlank() &&
        surname!=null && !surname.isBlank()  &&
        dob!=null;
    }

    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", dob=" + dob + "]";
    }
    
}
