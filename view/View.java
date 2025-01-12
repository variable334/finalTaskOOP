package view;

import java.io.IOException;

public interface View {

    void run() throws IOException, ClassNotFoundException;

    void print(String message);

}
