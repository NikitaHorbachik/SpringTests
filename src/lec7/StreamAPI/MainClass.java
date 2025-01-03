package lec7.StreamAPI;

import java.util.Arrays;
import java.util.*;
import java.util.stream.*;

public class MainClass {

    public static void main(String[] args) {
        String[] words = {
                "stream", "java", "filter", "java", "reduce",
                "filter", "map", "stream", "collect", "java",
                "reduce", "lambda", "map", "stream", "distinct",
                "filter", "java", "reduce", "parallel", "stream"
        };

        String mostFrequentWord = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())) // Считаем вхождения
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()) // Ищем максимум по значению
                .map(Map.Entry::getKey) // Берем ключ (слово)
                .orElse(null); // Если ничего не найдено, возвращаем null
        System.out.println("Слово - " + mostFrequentWord);





        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("MsPoh1", 35, 6),
                new Person("MsPoh2", 44, 8),
                new Person("MsPoh3", 25, 1),
                new Person("MsPoh4", 42, 2),
                new Person("MsPoh5", 55, 3),
                new Person("MsPoh6", 19, 4),
                new Person("MsPoh7", 33, 5),
                new Person("MsPoh8", 37, 7)));

        Stream<Person> avgSalaryStream = persons.stream();

        Double avgSalary = avgSalaryStream.collect(Collectors.averagingInt(Person::getSellary));
        System.out.println("avg = " + avgSalary);

        getNWorkers(3, persons);

    }


    static void getNWorkers(int N, List<Person> personList) {
        Stream<Person> printStream = personList.stream();
        printStream.sorted((o1, o2) -> o2.getAge() - o1.getAge()).limit(N).forEach(System.out::println);
    }

}
