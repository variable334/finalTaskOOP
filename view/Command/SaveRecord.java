package view.Command;

import view.ConsoleUI;

public class SaveRecord extends Command {


    public SaveRecord(ConsoleUI consoleUI) {
        super(consoleUI);
        descript = "Сохранить записи. ";
    }

    @Override
    public void execute() {
        consoleUI.saveData();
    }
}
