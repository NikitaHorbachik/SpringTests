package lec3;

public class MyDataArrayException extends RuntimeException{
    public MyDataArrayException(int index1, int index2) {
        super("Incorrect data in cell with indexes: " + index1 + " " + index2);
    }
}
