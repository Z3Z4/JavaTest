import java.util.*;
import telephoneDirectory.TelephoneDirectory;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Cat", "Dog", "Word", "Flight", "Song", "Cat", "Cat", "Word", "Brother", "Dance", "Song"};
        ArrayList arrayList = new ArrayList<String>(Arrays.asList(words));
        Set<String> uniqueWords = new HashSet<>(arrayList);
        System.out.println("Unique words: ");
        for (String element : uniqueWords) {
            System.out.println(element);
        }
        Map<String, Integer> wordCountMap = new HashMap<>();
        arrayList.toArray();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("\nHow much times every word entries ");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println(" ");

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        TelephoneDirectory.add("Kotin","+85395293529");
        TelephoneDirectory.add("Ivanov","+8534184529");
        TelephoneDirectory.add("Sidorov","+853341493529");
        TelephoneDirectory.add("Ivanov","+851111233529");
        TelephoneDirectory.add("Sedov","+8539321346729");
        TelephoneDirectory.get("Ivanov");
        TelephoneDirectory.get("Sedov");



    }
}





