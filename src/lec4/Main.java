package lec4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main<T> {
    public static void main(String[] args) {
        String[] Strings = {"0", "1", "2", "3", "4"};
        System.out.println(Arrays.toString(Strings));
        Swapper<String> swapper = new Swapper<>();
        swapper.swapElements(Strings, 0, 4);
        System.out.println(Arrays.toString(Strings));

        ArrayToArrayList<String> Changer = new ArrayToArrayList<>();

        System.out.println(Changer.getArrayList(Strings));
    }

}
