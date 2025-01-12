package src.Note.actionWithNote;

import src.Note.Note;

import java.util.List;

public interface OperationWithNote {

    void save(String name);

    List<Note> load(String path);

    void viewLoad(String name);

}
