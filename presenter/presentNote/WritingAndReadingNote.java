package presenter.presentNote;

import src.Note.Note;

import java.time.LocalDateTime;

public interface WritingAndReadingNote {

    void recordNote(String identifier, String note, LocalDateTime dateTime);

    void viewingNotes();

    void viewingSingleNotes(String name);

    void viewingSingleNoteDate(LocalDateTime dateTime);

    Note searchNote(String identifier);

    Note searchNoteDataTime(LocalDateTime dateTime);
}
