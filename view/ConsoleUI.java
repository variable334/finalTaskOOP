package view;

import presenter.presentContact.*;
import presenter.presentNote.*;



import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {


    ChangeAndDeleteContact changeAndDeleteContact;
    ReadingAndWritingContact readingAndWritingContact;
    SavingAndLoadingContact savingAndLoadingContact;
    SortContact sortContact;

    ChangesAndDeleteNote changesAndDeleteNote;
    WritingAndReadingNote writingAndReadingNote;
    SavingAndLoadingNote savingAndLoadingNote;
    SortNotes sortNotes;


    Scanner scanner;
    Menu menu;
    boolean exit;

    public ConsoleUI(ChangeAndDeleteContact changeAndDeleteContact, ReadingAndWritingContact readingAndWritingContact,
                     SavingAndLoadingContact savingAndLoadingContact, SortContact sortContact,
                     ChangesAndDeleteNote changesAndDeleteNote, WritingAndReadingNote writingAndReadingNote,
                     SavingAndLoadingNote savingAndLoadingNote, SortNotes sortNotes) {

        this.readingAndWritingContact = readingAndWritingContact;
        this.changeAndDeleteContact = changeAndDeleteContact;
        this.savingAndLoadingContact = savingAndLoadingContact;
        this.sortContact = sortContact;

        this.changesAndDeleteNote = changesAndDeleteNote;
        this.writingAndReadingNote = writingAndReadingNote;
        this.savingAndLoadingNote = savingAndLoadingNote;
        this.sortNotes = sortNotes;

        this.exit = true;
        this.menu = new Menu(this);
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run() throws IOException, ClassNotFoundException {

        while (exit) {

            print("Здравствуйте,что бы вы хотели сделать?");
            System.out.println();
            print(menu.Menu());


            String choice = scanner.nextLine();
            try {
                int answ = Integer.parseInt(choice);
                if (answ <= 6) {
                    menu.execute(answ);
                } else {
                    print("Такого пункта нет,попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                print("Ошибка!Вы ввели не число");
            }
        }

    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    public void CreateData() {


        print("Вы выбрали 'Создать запись'.");
        System.out.println();
        print("Выберете,какую запись вы бы хотели реализовать?");
        System.out.println();
        print("1.Персональная заметка.");
        print("2.Запись контакта.");
        String choice = scanner.nextLine();

        switch (choice) {


            case "1":
                print("Вы выбрали 'персональная заметка'. ");

                while (true) {

                    print("Введите идентификатор касаемо заметки,например: 'офис','дом' или то что подходит под описание вашей заметки.");
                    System.out.println();
                    String id = scanner.nextLine();
                    print("Напишете то что вы хотели бы записать: ");
                    System.out.println();
                    String note = scanner.nextLine();
                    boolean valid = false;
                    while (!valid) {
                        print("Введите дату и время: (например, 2025-01-15 14:30): ");
                        String date = scanner.nextLine();

                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                            LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

                            print("Вы ввели дату и время: " + dateTime);

                            writingAndReadingNote.recordNote(id, note, dateTime);
                            valid = true;

                        } catch (DateTimeException e) {
                            print("Неверный формат,попробуйте снова");
                        }
                    }

                    print("Хотите записать еще одну заметку?Введите да/нет: ");
                    String input = scanner.nextLine();
                    if (input.equals("нет")) {
                        return;
                    }
                }


            case "2":
                print("Вы выбрали 'Запись контакта'.");
                while (true) {
                    print("Введите имя контакта: ");
                    String name = scanner.nextLine();
                    print("Введите номер телефона: ");
                    String number = scanner.nextLine();
                    print("Введите email:  ");
                    String email = scanner.nextLine();
                    readingAndWritingContact.recordsContact(name, number, email);
                    print("хотите записать еще один контакт?Введите да?нет:  ");
                    String input = scanner.nextLine();
                    if (input.equals("нет")) {
                        return;
                    }
                }


            default:
                System.out.println("Вы ввели неверное число,попробуйте снова.");

        }


    }

    public void viewsData() {
        print("Вы выбрали 'Просмотреть записи'.");
        print("Какие записи вы бы хотели просмотреть.");
        print("1.Заметки.");
        print("2.Контакты.");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                print("Вы выбрали 'Заметки' ");
                print("Вам нужен весь список заметок или вы хотели бы просмотреть только определенную заметку?");
                print("1.Весь список заметок.");
                print("2.Определенная заметка.");

                String quest = scanner.nextLine();
                switch (quest) {
                    case "1":
                        print("Вы выбрали 'Весь список заметок' ");
                        writingAndReadingNote.viewingNotes();
                        break;

                    case "2":
                        print("Вы выбрали 'Определенная заметка' ");
                        System.out.println();
                        print("по какому критерию хотите найти заметку.");
                        print("1.Идентификатор.");
                        print("2.Дата и время.");
                        String quests = scanner.nextLine();


                        switch (quests) {
                            case "1":
                                print("Вы выбрали 'Идентификатор' ");
                                boolean valid = false;
                                while (!valid) {
                                    print("Введите идентификатор заметки которую хотите просмотреть");
                                    String id = scanner.nextLine();

                                    if (writingAndReadingNote.searchNote(id) != null) {
                                        writingAndReadingNote.viewingSingleNotes(id);
                                        valid = true;
                                    }
                                    else {
                                        System.out.println();
                                        print("Вы ввели неверный id.");
                                        System.out.println();
                                        print("Если сомневаетесь что он существует или не помните его введите '1',и попробуйте найти заметку по дате.");
                                        print("Если хотите повторить попытку введите '2'.");
                                        String choice2  = scanner.nextLine();
                                        if(choice2.equals("1")){
                                            valid = true;
                                        }

                                        System.out.println();
                                    }

                                }
                                break;

                            case "2":

                                boolean valids = false;
                                print("Вы выбрали 'Дата и время.' ");
                                while (!valids) {
                                    print("Введите дату и время: (например, 2025-01-15 14:30): ");

                                    String date = scanner.nextLine();

                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                                    LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

                                    if(writingAndReadingNote.searchNote(date) != null) {
                                        writingAndReadingNote.viewingSingleNoteDate(dateTime);
                                        valids = true;
                                    }
                                    else {
                                        System.out.println();
                                        print("Вы ввели неверную дату.");
                                        System.out.println();
                                        print("Если сомневаетесь что она существует или не помните её введите '1',и попробуйте найти заметку по id.");
                                        print("Если хотите повторить попытку введите '2'.");
                                        String choice2  = scanner.nextLine();
                                        if(choice2.equals("1")){
                                            valids = true;
                                        }

                                        System.out.println();
                                    }
                                }

                                break;


                            default:
                                System.out.println("Вы ничего не выбрали.");

                        }
                        break;

                    default:
                        System.out.println("Вы ничего не выбрали.");

                }
                break;

            case "2":
                print("Вы выбрали 'Контакты' ");
                print("Вам нужен весь список контактов или вы хотели бы просмотреть только определенный контакт?");
                print("1.Весь список контактов.");
                print("2.Определенный контакт.");
                String contact = scanner.nextLine();
                switch (contact) {
                    case "1":
                        print("Вы выбрали 'Весь список контактов.' ");
                        readingAndWritingContact.viewingContact();
                        break;

                    case "2":
                        print("Вы выбрали 'Определенный контакт' ");
                        boolean exit = false;
                        while (!exit) {
                            print("Введите имя контакта.");
                            String name = scanner.nextLine();
                            if(readingAndWritingContact.searchContact(name)!=null) {
                                readingAndWritingContact.viewingSingleContact(name);
                                exit = true;
                            }
                            else {
                                System.out.println();
                                print("Вы ввели неверное имя.");
                                System.out.println();
                                print("Если сомневаетесь что оно существует или не помните его введите '1'.");
                                print("Если хотите повторить попытку введите '2'.");
                                String choice2  = scanner.nextLine();
                                if(choice2.equals("1")){
                                    exit = true;
                                }

                                System.out.println();
                            }
                        }
                        break;

                }

                break;

        }
    }

    public void sortData() {
        print("Вы выбрали 'Сортировать'.");
        print("Какие записи вы бы хотели сортировать.");
        print("1.Заметки.");
        print("2.Контакты.");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                print("Вы выбрали 'Заметки'.");
                print("По какому критерию хотите сортировать заметки.");
                print("1.По id");
                print("2.По дате и времени.");
                String input2 = scanner.nextLine();
                switch (input2) {

                    case "1":
                        print("Вы выбрали 'По id'.");
                        sortNotes.sortById();
                        writingAndReadingNote.viewingNotes();
                        break;
                    case "2":
                        print("Вы выбрали 'По дате и времени'.");
                        sortNotes.sortByTime();
                        writingAndReadingNote.viewingNotes();
                        break;

                    default:
                        print("Вы ничего не выбрали.");
                }
                break;

            case "2":
                print("Вы выбрали 'Контакты'.");
                sortContact.triageByName();
                readingAndWritingContact.viewingContact();
                break;

            default:
                print("Вы ничего не выбрали.");

        }

    }

    public void saveData() {
        print("Вы выбрали 'Cохранить'.");
        print("Какие записи вы хотите сохранить.");
        print("1.Заметки.");
        print("2.Контакты.");
        String input = scanner.nextLine();
        switch (input) {

            case "1":
                print("Задайте имя файлу для сохранения: ");
                String name = scanner.nextLine();
                savingAndLoadingNote.save(name);
                print("Заметки успешно сохранены.");
                break;

            case "2":
                print("Задайте имя файлу для сохранения: ");
                String name2 = scanner.nextLine();
                savingAndLoadingContact.saving(name2);
                print("Контакты успешно сохранены.");
                break;

            default:
                print("Вы ничего не выбрали.");

        }

    }

    public void loadData() {
        print("Вы выбрали 'Загрузить записи'.");
        print("Какие записи вы хотите загрузить.");
        print("1.Заметки.");
        print("2.Контакты.");
        String input = scanner.nextLine();
        switch (input) {

            case "1":
                print("Вы выбрали 'Заметки'.");
                print("Введите имя файла которое сохранили: ");
                String name = scanner.nextLine();
                savingAndLoadingNote.load(name);
                savingAndLoadingNote.viewLoad(name);
                break;
            case "2":
                print("Вы выбрали 'Контакты'.");
                print("Введите имя файла которое сохранили: ");
                String name1 = scanner.nextLine();
                savingAndLoadingContact.loading(name1);
                savingAndLoadingContact.viewLoad(name1);
                break;
            default:
                print("Вы ничего не выбрали.");
        }
    }


}
