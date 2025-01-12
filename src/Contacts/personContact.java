package src.Contacts;

public class personContact extends ContactBuilder{
    @Override
    public Contact buildContact() {

        if(getName() != null || getNumber() != null || getEmail() != null){
            return new Contact(getName(),getNumber(),getEmail());

        }
        else {
            System.out.println("Не все критерии заполнены.");
        }
        return null;

    }


}
