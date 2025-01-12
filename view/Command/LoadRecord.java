package view.Command;

import view.ConsoleUI;

public class LoadRecord extends Command {


    public LoadRecord(ConsoleUI consoleUI) {
        super(consoleUI);
        descript = "Загрузить записи. ";
    }

    @Override
    public void execute() {
        consoleUI.loadData();
    }
}
