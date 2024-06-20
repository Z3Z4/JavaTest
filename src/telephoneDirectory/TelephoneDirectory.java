package telephoneDirectory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TelephoneDirectory {
    private static Map<String, String> phonebook;

    public TelephoneDirectory() {
        phonebook = new HashMap<>();
    }
    public static void add(String lastname, String phone) {
        phonebook.put(phone, lastname);

    }
    public static void get(String lastname) {
        if (phonebook.containsValue(lastname)) {
            Set<Map.Entry<String, String>> set = phonebook.entrySet();
            for (Map.Entry<String, String> temp : set) {
                if (temp.getValue().equals(lastname)) {
                    System.out.println(temp.getValue() + " : " + temp.getKey());
                }


             }
        }
    }
}

