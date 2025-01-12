package src.Contacts;


import src.Contacts.actionWithContact.GetElemContact;

import java.io.Serializable;

public class Contact implements GetElemContact,Serializable {

    private String name;
    private String number;
    private String email;


    public Contact(String name,String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
