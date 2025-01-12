package src.Contacts.compareContact;

import src.Contacts.actionWithContact.GetElemContact;

import java.util.Comparator;

public class CompareByName <T extends GetElemContact> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
