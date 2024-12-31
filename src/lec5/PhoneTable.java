package lec5;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneTable {
    HashMap<String, ArrayList<String>> phoneTable = new HashMap<>();

    void add(String surname, String phone) {
        if(!phoneTable.containsKey(surname)) {
            phoneTable.put(surname, new ArrayList<>());
        }
        phoneTable.get(surname).add(phone);
    }

    ArrayList<String> get(String surname) {
        if(phoneTable.containsKey(surname)) {
            return phoneTable.get(surname);
        }
        return null;
    }

    @Override
    public String toString() {
        return "PhoneTable{" +
                "phoneTable=" + phoneTable +
                '}';
    }
}
