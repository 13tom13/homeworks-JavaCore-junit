package phone;

import java.util.*;

public class PhoneBook {

    private Map<String, HashMap<String, Contact>> book = new HashMap<>();

    public Map<String, HashMap<String, Contact>> getBook() {
        return book;
    }

    public Contact creatContact(String name, String number) {
        return new Contact(name, number);
    }

    public void addGroup(String group) {
        book.put(group, new HashMap<String, Contact>());
    }

    public void addContact(Contact contact, String... groups) {
        for (String group : groups) {
            book.get(group).put(contact.phoneNumber, contact);
        }
    }

    public Contact[] getСontacts(String group) {
        if (book.containsKey(group)) {
            System.out.printf("Группа \"%s\": ", group);
            HashMap<String, Contact> groupForGet = book.get(group);
            return groupForGet.values().toArray(new Contact[groupForGet.size()]);
        } else {
            System.out.printf("Группа \"%s\" в телефонной книге не найдено.", group);
            return null;
        }
    }

    public Contact getСontactByPhone(String phone) {
        for (HashMap<String, Contact> kv : book.values()) {
            return kv.get(phone);
        }
        return new Contact("Неизвестный номер", phone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" Телефонная книга: \n");
        for (Map.Entry<String, HashMap<String, Contact>> s : book.entrySet()) {
            sb.append(String.format("%-14s: %s %n", s.getKey(), s.getValue().values()));
        }
        return sb.toString();
    }
}
