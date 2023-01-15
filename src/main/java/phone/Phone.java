package phone;

import static phone.MissedCalls.missedCallAmount;

public class Phone {
    private PhoneBook phoneBook = new PhoneBook();
    private MissedCalls missedCalls = new MissedCalls();

    public static int callAmount;

    public Phone() {
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    public MissedCalls getMissedCalls() {
        return missedCalls;
    }

    public void fillingPhoneBook() {
        phoneBook.addGroup("Друзья");
        phoneBook.addGroup("Работа");
        phoneBook.addGroup("Одноклассники");
        phoneBook.addGroup("Семья");
        phoneBook.addContact(phoneBook.creatContact("Михалыч", "+79113330301"), "Друзья");
        phoneBook.addContact(phoneBook.creatContact("Иван", "+79110788806"), "Друзья", "Работа", "Одноклассники");
        phoneBook.addContact(phoneBook.creatContact("Даша", "+79110722554"), "Семья", "Работа");
        phoneBook.addContact(phoneBook.creatContact("Лиза", "+79110740965"), "Семья");
    }


    public void call(String number) {
        System.out.printf("Входящий вызов: %s%n", number);
        callAmount++;
        int timeout = (int) (Math.random() * 3);
        if (timeout != 0) {
            missedCalls.missedCall(number, phoneBook);
            System.out.printf("Вызво пропущен.(%d)%n", missedCallAmount);
        } else {
            System.out.println("Разговор...");
        }
    }

    public void showMissedCallList() {
        missedCalls.missedCallList(phoneBook);
    }
}
