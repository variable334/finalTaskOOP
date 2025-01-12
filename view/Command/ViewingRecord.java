package view.Command;

import view.ConsoleUI;

public class ViewingRecord extends Command {


    public ViewingRecord(ConsoleUI consoleUI) {
        super(consoleUI);
        descript = "показать записи. ";
    }

    @Override
    public void execute() {
        consoleUI.viewsData();
    }
}
