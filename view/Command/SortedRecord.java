package view.Command;

import view.ConsoleUI;

public class SortedRecord extends Command{


    public SortedRecord(ConsoleUI consoleUI) {
        super(consoleUI);
        descript = "Сортировать записи. ";
    }

    @Override
    public void execute() {
        consoleUI.sortData();
    }
}
