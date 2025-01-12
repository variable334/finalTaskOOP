package view.Command;

import view.ConsoleUI;

public class Finish extends Command {


    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        descript = "Выйти. ";
    }

    @Override
    public void execute() {

    }
}
