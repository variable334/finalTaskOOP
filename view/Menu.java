package view;

import view.Command.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<Command> commandList;

    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new CreateRecord(consoleUI));
        commandList.add(new ViewingRecord(consoleUI));
        commandList.add(new SortedRecord(consoleUI));
        commandList.add(new SaveRecord(consoleUI));
        commandList.add(new LoadRecord(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    String Menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescript());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }


}
