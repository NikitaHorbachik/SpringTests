package lec4;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToArrayList<T> {
    ArrayList<T> getArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>(array.length);
        arrayList.addAll(Arrays.asList(array));
        return arrayList;
    }

}
