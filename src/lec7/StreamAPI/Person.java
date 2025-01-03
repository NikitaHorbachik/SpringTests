package lec7.StreamAPI;

class Person {
    private String name;
    private int age;
    private int sellary;

    public Person(String name, int age, int sellary) {
        this.name = name;
        this.age = age;
        this.sellary = sellary;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSellary() {
        return sellary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sellary=" + sellary +
                '}';
    }
}