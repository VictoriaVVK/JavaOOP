import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String FILE_NAME = "books.dat";
    private static List<Book> bookCollection = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        loadBooksFromFile();
        while(true){
            System.out.println("--Здравейте в моята библиотека--");
            System.out.println("1. Добави книга");
            System.out.println("2. Покажи всички книги");
            System.out.println("3. Изтрий книга");
            System.out.println("4. Търси книга");
            System.out.println("5. Изход");
            System.out.print("Избери опция: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    addBook();
                    break;
                case 2:
                    showBooks();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    saveBooksToFile();
                    System.out.println("Програмата завърши");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Невалидна опция. Пробвай пак :)");

            }
        }
    }

    private static void loadBooksFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            // Четене на целия списък от книги от бинарния файл
            //десериализация
            bookCollection = (List<Book>) ois.readObject();  //възстановява, като се чете обект от файла и го преобразува обратно в тип List<Book>.
            System.out.println("Книгите са заредени успешно от файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Грешка при зареждане на файла: " + e.getMessage());
        }
    }

    private static void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) { // за четене на обекти
            // Записване на целия списък от книги в сериализиран формат
            //сериализация
            oos.writeObject(bookCollection);
            System.out.println("Книгите са записани успешно в бинарен формат.");
        } catch (IOException e) {
            System.out.println("Грешка при запис на файла: " + e.getMessage());
        }
    }

    private static void addBook() {
        System.out.println("\n=== Добавяне на книга ===");
        System.out.println("Избери тип книга: ");
        System.out.println("1. Роман");
        System.out.println("2. Стихотворение");
        System.out.println("3. Научна книга");
        System.out.print("Избери опция: ");

        int choice = Integer.parseInt(sc.nextLine());
        try {
            System.out.print("Въведи заглавие: ");
            String title = sc.nextLine();
            System.out.print("Въведи автор: ");
            String author = sc.nextLine();
            System.out.print("Въведи брой страници: ");
            int pageCount = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Въведи жанр: ");
                    String genre = sc.nextLine();
                    System.out.print("Въведи главен герой: ");
                    String mainCharacter = sc.nextLine();
                    bookCollection.add(new Novel(title, author, pageCount, genre, mainCharacter));
                }
                case 2 -> {
                    System.out.print("Въведи поетична форма: ");
                    String poeticForm = sc.nextLine();
                    System.out.print("Въведи брой строфи: ");
                    int verseCount = Integer.parseInt(sc.nextLine());
                    bookCollection.add(new Poetry(title, author, pageCount, poeticForm, verseCount));
                }
                case 3 -> {
                    System.out.print("Въведи научна област: ");
                    String fieldOfStudy = sc.nextLine();
                    System.out.print("Въведи справки (разделени със запетая): ");
                    String[] referencesArray = sc.nextLine().split(",");
                    List<String> references = List.of(referencesArray);
                    bookCollection.add(new ScientificBook(title, author, pageCount, fieldOfStudy, references));
                }
                default -> System.out.println("Невалиден тип книга.");
            }
        } catch (Exception e) {
            System.out.println("Грешка при добавяне на книга: " + e.getMessage());
        }
    }
    private static void showBooks() {
        System.out.println("\n=== Списък с книги ===");
        if (bookCollection.isEmpty()) {
            System.out.println("Няма добавени книги.");
            return;
        }
        for (int i = 0; i < bookCollection.size(); i++) {
            System.out.println((i + 1) + ". " + bookCollection.get(i).getTitle() + " от " + bookCollection.get(i).getAuthor());
        }
    }
    private static void deleteBook() {
        showBooks();
        if (bookCollection.isEmpty()) return;

        System.out.print("Избери номер на книга за изтриване: ");
        try {
            int index = Integer.parseInt(sc.nextLine()) - 1;
            if (index < 0 || index >= bookCollection.size()) {
                System.out.println("Невалиден номер на книга.");
                return;
            }
            Book removedBook = bookCollection.remove(index);
            System.out.println("Книгата \"" + removedBook.getTitle() + "\" беше изтрита.");
        } catch (Exception e) {
            System.out.println("Грешка при изтриване на книга: " + e.getMessage());
        }
    }

    private static void searchBook() {
        System.out.println("\n=== Търсене на книга ===");
        System.out.println("1. Търси по заглавие");
        System.out.println("2. Търси по автор");
        System.out.print("Избери опция: ");

        int choice = Integer.parseInt(sc.nextLine());
        System.out.print("Въведи ключова дума за търсене: ");
        String keyword = sc.nextLine().toLowerCase(); // Преобразуване в малки букви за лесно сравнение

        boolean found = false;

        for (Book book : bookCollection) {
            if (choice == 1 && book.getTitle().toLowerCase().contains(keyword)) {
                System.out.println("Намерена книга: " + book.getTitle() + " от " + book.getAuthor());
                found = true;
            } else if (choice == 2 && book.getAuthor().toLowerCase().contains(keyword)) {
                System.out.println("Намерена книга: " + book.getTitle() + " от " + book.getAuthor());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Няма намерени книги с тези критерии.");
        }
    }

}
