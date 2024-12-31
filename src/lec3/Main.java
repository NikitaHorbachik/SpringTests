package lec3;

public class Main {
    public static void main(String[] args) {

        String[][] correctNums = {{"1", "2", "3", "4" }, {"5", "6", "7", "8" }, {"9", "10", "11", "12" }, {"13", "14", "15", "16" }
        };
        String[][] incorrectNumsSize = {{"1", "2", "3", "4" },{"9", "10", "11" }, {"9", "10", "11", "12" }, {"13", "14", "15", "16" }
        };
        String[][] incorrectNums = {{"1", "СКОВОРОДА", "3", "4" }, {"5", "6", "7", "8" }, {"9", "10", "11", "12" }, {"13", "14", "15", "16" }
        };
        System.out.println(getNumbersSum(correctNums));
        try {
            System.out.println(getNumbersSum(incorrectNumsSize));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(getNumbersSum(incorrectNums));
        } catch (MyDataArrayException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getNumbersSum(String[][] array) throws MyDataArrayException, MyArraySizeException {

        if (array.length != 4) {
            throw new MyArraySizeException("Массив неверного размера!");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Строка массива неверного размера!");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                        throw new MyDataArrayException(i, j);
                }
            }
        }
        return sum;
    }

}