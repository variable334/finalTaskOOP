package src.Contacts;

public abstract class ContactBuilder {

    private String name;
    private String number;
    private String email;


    public ContactBuilder setName(String name){
        this.name = name;
        return this;
    }

    public ContactBuilder setNumber(String number){
        this.number = number;
        return this;

    }

    public ContactBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public abstract Contact buildContact();


}
