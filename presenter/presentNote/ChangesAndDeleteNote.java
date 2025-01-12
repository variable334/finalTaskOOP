package presenter.presentNote;

import java.time.LocalDateTime;

public interface ChangesAndDeleteNote {

    void amendBysLocalDateNote(String ex, LocalDateTime change);

    void amendByStringNote(String ex,String change);

    void deleteNote(String identifier);
}
