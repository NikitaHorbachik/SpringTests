package lec4.FriutCase;

public class Main {
    public static void main(String[] args) {
        FruitBox<Apple> AppleBox1 = new FruitBox<>();
        FruitBox<Orange> OrangeBox = new FruitBox<>();
        FruitBox<Apple> AppleBox2 = new FruitBox<>();
        for(int i = 0; i < 5; i++) {
            Apple apple = new Apple();
            AppleBox1.addFruit(apple);
        }
        for(int i = 0; i < 10; i++) {
            Apple apple = new Apple();
            AppleBox2.addFruit(apple);
        }
        for(int i = 0; i < 10; i++) {
            Orange Orange = new Orange();
            OrangeBox.addFruit(Orange);
        }

        System.out.println(AppleBox1.getWeight());
        System.out.println(AppleBox2.getWeight());
        System.out.println(OrangeBox.getWeight());
        System.out.println(AppleBox1.compare(AppleBox2));
        AppleBox2.changeBox(AppleBox1);
        System.out.println(AppleBox1.getWeight());
        System.out.println(AppleBox2.getWeight());
    }
}
