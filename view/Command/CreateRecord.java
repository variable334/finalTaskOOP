package view.Command;

import view.ConsoleUI;


public class CreateRecord extends Command{


    public CreateRecord(ConsoleUI consoleUI) {
        super(consoleUI);
        descript = "Создание записи. ";
    }

    @Override
    public void execute() {
        consoleUI.CreateData();
    }
}
