package lec6;



public class Main {

    static final int SIZE = 10000000 ;
    static final int HALF = SIZE / 2 ;

    public static void main(String[] args) {
            new Thread(Main::SingleThreadMethod).start();
            new Thread(Main::MultiThreadMethod).start();
    }


    public static void SingleThreadMethod() {
        float [] arr = new float [SIZE];
        fillWithOnes(arr);
        long startTime = System.currentTimeMillis();
        fillWithMath(arr);
        System.out.println("SingleMethod time = " + (System.currentTimeMillis() - startTime));
    }

    private static void fillWithMath(float[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math. sin( 0.2f + (double) i / 5) * Math. cos(0.2f + (double) i / 5) *
            Math.cos( 0.4f + (double) i / 2 ));
        }
    }

    public static void fillWithOnes(float[] arr) {
        for(float el: arr) {
            el = 1;
        }
    }

    public static void MultiThreadMethod(){
        float [] arr = new float [SIZE];
        float [] arr1 = new float [HALF];
        float [] arr2 = new float [HALF];

        try {
            Thread first = new Thread(() -> fillWithOnes(arr1));
            Thread second = new Thread(() -> fillWithOnes(arr2));
            first.start();
            second.start();
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        long startTime = System.currentTimeMillis();

        try {
            Thread first = new Thread(() -> fillWithMath(arr1));
            Thread second = new Thread(() -> fillWithMath(arr2));
            first.start();
            second.start();
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println("MultiMethod time = " + (System.currentTimeMillis() - startTime));
    }
    
}
