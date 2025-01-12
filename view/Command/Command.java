package view.Command;

import view.ConsoleUI;


public abstract class Command {

    String descript;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescript() {
        return descript;
    }

    public abstract void execute();

}
