public class InsertSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {

        for (int i = 1; i < unsortedVector.length; i++) {
            double tmp = unsortedVector[i];
            for (int j = i-1; j > 0 && tmp > unsortedVector[j]; j--) {
                unsortedVector[j+1] = unsortedVector[j];
                unsortedVector[j] = tmp;
            }
        }
        return unsortedVector;
    }
}
