package src.Contacts;

import src.Contacts.actionWithContact.*;
import src.Contacts.actionWithContact.*;
import src.Note.Note;
import src.SortData;

import java.io.*;
import java.util.*;

public class ContactActionManager  implements ActionWithContact, SortedByName, SearchContact, OperationWithContact, ChangesContact, Serializable {

    private static final long serialVersionUID = 1L;
    private List<Contact> contactList;
    private ContactBuilder contactBuilder;
    private SortData<Contact>sortContact;


    public ContactActionManager(ContactBuilder contactBuilder) {
        this.contactBuilder = contactBuilder;
        this.contactList = new ArrayList<>();
        this.sortContact = new SortData<>(contactList);

    }

    @Override
    public void writeContact(String name, String number, String email) {

        Contact newcontact = contactBuilder
                .setName(name)
                .setNumber(number)
                .setEmail(email).buildContact();


        contactList.add(newcontact);

    }

    @Override
    public void readingContacts() {
        for (Contact contact:contactList){
            System.out.println(contact);
        }
    }



    @Override
    public void readingSingleContact(String name) {

        Contact contact = contactSearch(name);
        System.out.println(contact);
    }


    @Override
    public void changesContact(String ex,String change) {
        if (!contactList.isEmpty()) {
            boolean isChanged = false;

            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getName().equals(ex)) {
                    contactList.get(i).setName(change);
                    isChanged = true;
                    break;
                }
            }

            if (!isChanged) {
                System.out.println("Запись отсутствует.");
            }

        } else {
            System.out.println("Записи отсутствуют.");
        }
    }


    @Override
    public void removeContact(String name) {
        if (!contactList.isEmpty()) {
            boolean isChanged = false;

            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getName().equals(name)) {
                    contactList.remove(i);
                    isChanged = true;
                    break;
                }
            }
            if (!isChanged) {
                System.out.println("Запись отсутствует.");
            }
        }
        else {
            System.out.println("Записи отсутствуют.");
        }
    }


    @Override
    public Contact contactSearch(String name) {
        if (!contactList.isEmpty()){
            for (int i = 0; i < contactList.size(); i++) {
                if(contactList.get(i).getName().equals(name)){
                    return contactList.get(i);
                }
            }
        }

        else {
            System.out.println("Записи отсутствуют.");
        }
        return null;
    }

    @Override
    public void save(String name) {
        try (FileOutputStream fileOut = new FileOutputStream(name);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(contactList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Contact> load(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            List<Contact> loadedList = (List<Contact>) ois.readObject();
            return loadedList;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void viewLoadContact(String name) {

        List<Contact> load;

        load = load(name);
        System.out.println("Фамильное дерево загружено из файла");

        System.out.println();

        if (load != null) {
            for (Contact contact : load) {
                System.out.println("Loaded entity:" +
                        " Имя - " + contact.getName() + ", "+ " номер телефона - " + contact.getNumber());
            }
        }
    }

    @Override
    public void SortByName() {
        sortContact.sortByName();
    }
}