import java.util.Random;

public class Main {

    public static void main(String args []){
        InsertSort is = new InsertSort();
        MergeSort ms = new MergeSort();

        double unsortedVector[] = randomVector(100000);

        //printVector(unsortedVector);

        double IsortedVector[] = is.sort(unsortedVector);
        double MsortedVector[] = ms.sort(unsortedVector);

        //printVector(IsortedVector);
        //printVector(MsortedVector);

        System.out.println("Test InsertSort: ");
        insertSortTest(unsortedVector);
        System.out.println("Test MergeSort: ");
        mergeSortTest(unsortedVector);
    }

    public static double[] randomVector(int n){
        double v[] = new double[n];
        Random generator = new Random();

        for (int i=0; i<n; i++){
            v[i] = generator.nextDouble()%100;
        }
        return v;
    }

    public static void printVector(double[] v){

        System.out.print("Wektor = [");
        for (int i = 0; i < v.length; i++)
            System.out.print(v[i] + ",  ");
        System.out.print("]\n");
    }

    public static void insertSortTest( double[] v){
        InsertSort is = new InsertSort();

        long start = System.nanoTime();
        is.sort(v);
        long time = System.nanoTime() - start;
        System.out.println(time);
    }

    public static void mergeSortTest( double[] v){
        MergeSort ms = new MergeSort();

        long start = System.nanoTime();
        ms.sort(v);
        long time = System.nanoTime() - start;
        System.out.println(time);
    }
}
