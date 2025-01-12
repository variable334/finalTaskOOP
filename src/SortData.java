package src;

import src.Contacts.compareContact.CompareByName;
import src.Note.comparators.CompareByDate;
import src.Note.comparators.compareByIdentifier;
import src.Contacts.iterators.Iterators;

import java.util.Iterator;
import java.util.List;

public class SortData<T> implements Iterable<T> {

    List<T>iterablList;

    public SortData(List<T>list) {
       this.iterablList = list;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterators<>(iterablList);
    }


    public void sortByDate(){

        iterablList.sort(new CompareByDate());
    }

    public void sortByIdentifier(){
        iterablList.sort(new compareByIdentifier());
    }

    public void sortByName(){
        iterablList.sort(new CompareByName());
    }


}
