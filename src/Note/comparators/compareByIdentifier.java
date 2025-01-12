package src.Note.comparators;

import src.Note.actionWithNote.GetElementNote;

import java.util.Comparator;

public class compareByIdentifier<T extends GetElementNote>implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getIdentifier().compareTo(o2.getIdentifier());
    }
}
