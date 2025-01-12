package src.Note.comparators;

import src.Note.actionWithNote.GetElementNote;


import java.util.Comparator;

public class CompareByDate<T extends GetElementNote>implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return o1.getData().compareTo(o2.getData());
    }
}
