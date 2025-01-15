package src.Note;

import src.Note.actionWithNote.*;
import src.Note.builder.NoteBuilder;
import src.SortData;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotesActionManager implements ActionWithNotes, SortByIdentifier,SortByDate, SearchNotes, OperationWithNote, ChangesNotes,Serializable {

    private static final long serialVersionUID = 1L;
    private List<Note>notes;
    private NoteBuilder noteBuilder;
    private SortData<Note> sortByData;

    public NotesActionManager(NoteBuilder noteBuilder) {
        this.noteBuilder = noteBuilder;
        this.notes = new ArrayList<>();
        this.sortByData = new SortData<>(notes);
    }

    @Override
    public void writeNote(String identifier, String note, LocalDateTime localDateTime) {


        Note newNote = noteBuilder
                .setIdentifier(identifier)
                .setNote(note)
                .setData(localDateTime).buildNote();

        notes.add(newNote);
    }

    @Override
    public void readingNotes() {
        for (Note note:notes){
            System.out.println(note);
        }

    }

    @Override
    public void  readingSingleNotes(String identifier) {


                Note note = searchNote(identifier);
                System.out.println(note);



    }



    @Override
    public void readingSingleNoteDate(LocalDateTime dateTime) {
        Note note = searchNoteDate(dateTime);
        System.out.println(note);
    }


    @Override
    public void changesLocalDateNote(String ex, LocalDateTime change) {
        if (!notes.isEmpty()) {
            boolean isChanged = false;

            for (int i = 0; i < notes.size(); i++) {
                if (notes.get(i).getIdentifier().equals(ex)) {
                    notes.get(i).setData(change);
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
    public void changesStringNote(String ex, String change) {
        if (!notes.isEmpty()) {
            boolean isChanged = false;

            for (int i = 0; i < notes.size(); i++) {
                if (notes.get(i).getIdentifier().equals(ex)) {
                    notes.get(i).setStringNote(change);
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
    public void removeNote(String identifier) {

        if (!notes.isEmpty()) {
            boolean isChanged = false;

            for (int i = 0; i < notes.size(); i++) {
                if (notes.get(i).getIdentifier().equals(identifier)) {
                    notes.remove(i);
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
    public Note searchNote(String identifier) {

        if (!notes.isEmpty()){
            for (int i = 0; i < notes.size(); i++) {
                if(notes.get(i).getIdentifier().equals(identifier)){
                    return notes.get(i);
                }
            }
        }

        else {
            System.out.println("Записи отсутствуют.");
        }
       return null;
    }




    @Override
    public Note searchNoteDate(LocalDateTime dateTime) {
        if (!notes.isEmpty()){
            for (int i = 0; i < notes.size(); i++) {
                if(notes.get(i).getData().equals(dateTime)){
                    return notes.get(i);
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
            out.writeObject(notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Note> load(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            List<Note> loadedMap = (List<Note>) ois.readObject();
            System.out.println("Записи загружены.");
            return loadedMap;

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    public void viewLoad(String name){
        List<Note> load = null;

        load = load(name);

        System.out.println();

        if (load != null) {
            for (Note note : load) {
                System.out.println("Loaded entity:" +
                        " id - " + note.getIdentifier() + ", "+ " дата записи - " + note.getData());
            }
        }
    }

    @Override
    public void sortDate() {
        sortByData.sortByDate();
    }

    @Override
    public void sortIdentifier() {
        sortByData.sortByIdentifier();
    }
}
