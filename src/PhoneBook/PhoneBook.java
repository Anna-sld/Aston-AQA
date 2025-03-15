package PhoneBook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        phoneBook.computeIfAbsent(lastName, k -> new HashSet<>()).add(phoneNumber);
    }

    public Set<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new HashSet<>());
    }

    public void printAll() {
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


