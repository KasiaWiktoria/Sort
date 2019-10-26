import java.util.Random;

public class Main {

    public static void main(String args []){
        InsertSort is = new InsertSort();
        MergeSort ms = new MergeSort();

        double unsortedVector[] = randomVector(2000);

        printVector(unsortedVector);

        double IsortedVector[] = is.sort(unsortedVector);
        double MsortedVector[] = ms.sort(unsortedVector);
        double[] reverseVector = reverse(MsortedVector);

        //printVector(unsortedVector);
        printVector(IsortedVector);
        printVector(MsortedVector);
        printVector(reverseVector);

//        System.out.println("Test dla losowych danych: ");
//        System.out.println("Test InsertSort: ");
//        insertSortTest(unsortedVector);
//        System.out.println("Test MergeSort: ");
//        mergeSortTest(unsortedVector);

        System.out.println("Test dla optymistycznych danych: ");
        System.out.println("Test InsertSort: ");
        for (int i = 0; i < 100000; i+=1000) {
            double[] optV = sortedRandomVector(i);
            insertSortTest(optV);
        }
        System.out.println("Test MergeSort: ");
        for (int i = 0; i < 100000; i+=1000) {
            double[] optV = sortedRandomVector(i);
            mergeSortTest(optV);
        }

        System.out.println("Test dla pesymistycznych danych: ");
        System.out.println("Test InsertSort: ");
        for (int i = 0; i < 100000; i+=1000) {
            double[] pesV = reverse(sortedRandomVector(i));
            insertSortTest(pesV);
        }
        System.out.println("Test MergeSort: ");
        for (int i = 0; i < 100000; i+=1000) {
            double[] pesV = reverse(sortedRandomVector(i));
            mergeSortTest(pesV);
        }
    }

    public static double[] randomVector(int n){
        double v[] = new double[n];
        Random generator = new Random();

        for (int i=0; i<n; i++){
            v[i] = generator.nextDouble();
        }
        return v;
    }

    public static double[] sortedRandomVector(int n){
        double v[] = new double[n];
        Random generator = new Random();

        for (int i=0; i<n; i++){
            v[i] = generator.nextDouble();
        }
        MergeSort ms = new MergeSort();
        double[] sv = ms.sort(v);
        return sv;
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

    public static double[] reverse(double[] v){
        double [] v1 = new double[v.length];
        for (int i = 0; i < v.length ; i++)
            v1[v.length-i-1] = v[i];
        return v1;
    }
}
