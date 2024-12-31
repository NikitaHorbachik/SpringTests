package lec4.FriutCase;

import java.util.ArrayList;

public class FruitBox <T extends Fruit> {
    ArrayList<T> fruits = new ArrayList<>();
    double getWeight() {
        if (!fruits.isEmpty()) {
            if (fruits.getFirst().getClass() == Apple.class) {
                return fruits.size() * 1.0;
            }
            if (fruits.getFirst().getClass() == Orange.class) {
                return fruits.size() * 1.5;
            }
        }
        return 0;
    }
    boolean compare(FruitBox<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.00001;
    }

    void changeBox(FruitBox<T> another) {
        another.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    void addFruit(T t) {
        fruits.add(t);
    }
}
