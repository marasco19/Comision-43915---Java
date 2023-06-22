package com.coderhouse.Clase8JPAABM.model;

public class ClientDTO {

    private String name;
    private String lastname;
    private int docnumber;


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

    public int getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(int docnumber) {
        this.docnumber = docnumber;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docnumber=" + docnumber +
                '}';
    }
}
