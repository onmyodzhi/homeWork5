import java.util.*;

public class HomeWork5 {
    public static void main(String[] args) {
        createPhoneNotes();
    }

    public static void createPhoneNotes() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        char choiceOperation;
        do {
            System.out.println("Enter operation");
            System.out.println("1 - add contact");
            System.out.println("2 - print all");
            System.out.println("3 - exit");

            System.out.println("choose the operation");
            choiceOperation = scanner.nextLine().charAt(0);
            switch (choiceOperation) {
                case '1':
                    addContact(scanner, phoneBook);
                    break;
                case '2':
                    printlnPhoneBook(phoneBook);
                    break;
                case '3':
                    System.out.println("game over");
                    break;
                default:
                    System.out.println("input exception");
                    break;
            }
            System.out.println();
        } while (choiceOperation != '3');

        scanner.close();
    }

    public static void printlnPhoneBook(HashMap<String, List<String>> phoneBook) {
        if (phoneBook.isEmpty()) {
            System.out.println("Phone bool is empty");
            return;
        }
        List<Map.Entry<String, List<String>>> sortPhoneBook = new ArrayList<>(phoneBook.entrySet());
        sortPhoneBook.sort(Comparator.comparing(e -> e.getValue().size()));
        Collections.reverse(sortPhoneBook);
        System.out.println("phoneBook: ");
        for (Map.Entry<String, List<String>> entry : sortPhoneBook) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void addContact(Scanner scanner, HashMap<String, List<String>> contact) {
        System.out.println("Enter name of your contact");
        String nameContact = scanner.nextLine();
        System.out.println("enter a phone number");
        String phoneNumber = scanner.nextLine();
        if (contact.containsKey(nameContact)) {
            List<String> addPhoneNumber = contact.get(nameContact);
            addPhoneNumber.add(phoneNumber);
        } else {
            List<String> addPhoneNumber = new ArrayList<>();
            addPhoneNumber.add(phoneNumber);
            contact.put(nameContact, addPhoneNumber);
        }
    }
}
