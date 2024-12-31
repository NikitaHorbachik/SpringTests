package lec5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"a", "b", "c" , "d" ,"e" ,"f" , "e", "g", "s", "z", "m" ,"q", "z", "s"};
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        System.out.println(set);

        ArrayList<String> wordsArray = new ArrayList<>(Arrays.asList(words));
        Iterator<String> iter = wordsArray.iterator();
        Map<String, Integer> map = new HashMap<>();
        while(iter.hasNext()) {
            String el = iter.next();
            if(map.containsKey(el)) {
                map.put(el, map.get(el) + 1);
            }
            else {
                map.put(el, 1);
            }
        }
        System.out.println(map);

        PhoneTable phoneTable = new PhoneTable();

        phoneTable.add("Smith", "123-456-7890");
        phoneTable.add("Johnson", "234-567-8901");
        phoneTable.add("Williams", "345-678-9012");
        phoneTable.add("Jones", "456-789-0123");
        phoneTable.add("Brown", "567-890-1234");
        phoneTable.add("Davis", "678-901-2345");
        phoneTable.add("Miller", "789-012-3456");
        phoneTable.add("Wilson", "890-123-4567");
        phoneTable.add("Moore", "901-234-5678");
        phoneTable.add("Smith", "012-345-6789");
        phoneTable.add("Anderson", "123-456-7891");
        phoneTable.add("Thomas", "234-567-8902");
        phoneTable.add("Jackson", "345-678-9013");
        phoneTable.add("White", "456-789-0124");
        phoneTable.add("Smith", "567-890-1235");
        phoneTable.add("Martin", "678-901-2346");
        phoneTable.add("Thompson", "789-012-3457");
        phoneTable.add("Garcia", "890-123-4568");
        phoneTable.add("Martinez", "901-234-5679");
        phoneTable.add("Robinson", "012-345-6790");
        phoneTable.add("Smith", "111-222-3333");
        phoneTable.add("Johnson", "222-333-4444");

        System.out.println(phoneTable);



    }
}
