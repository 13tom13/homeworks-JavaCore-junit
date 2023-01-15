package phone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    public static int missedCallAmount;
    private static final DateTimeFormatter FORMAT_OF_DATE = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void missedCall(String number, PhoneBook phoneBook) {
        LocalDateTime timeOfCall = LocalDateTime.now().plusMinutes(Phone.callAmount);
        missedCalls.put(timeOfCall, number);
        missedCallAmount++;
    }

    public void missedCallList(PhoneBook phoneBook) {
        StringBuilder sb = new StringBuilder(" Пропущенные вызовы(" + missedCallAmount + "):\n");
        for (Map.Entry<LocalDateTime, String> s : missedCalls.entrySet()) {
            if (phoneBook.getСontactByPhone(s.getValue()) != null) {
                sb.append(String.format("Абонент: %-12s (Время: %s).%n",
                        phoneBook.getСontactByPhone(s.getValue()).name, s.getKey().format(FORMAT_OF_DATE)));
            } else {
                sb.append(String.format("Абонент: %-12s (Время: %s).%n",
                        s.getValue(), s.getKey().format(FORMAT_OF_DATE)));
            }
        }
        System.out.println(sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" Пропущенные вызовы(" + missedCallAmount + "):\n");
        for (Map.Entry<LocalDateTime, String> s : missedCalls.entrySet()) {
            sb.append(String.format("Время: %s Абонент: %s.%n", s.getKey().format(FORMAT_OF_DATE), s.getValue()));
        }
        return sb.toString();
    }
}
