package presenter.presentNote;

import src.Note.Note;

import java.util.List;

public interface SavingAndLoadingNote {

    void save(String name);

    void load(String name);

    void viewLoad(String name);
}
