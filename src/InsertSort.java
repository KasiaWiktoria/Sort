public class InsertSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        double[] tmpArray = new double[unsortedVector.length];
        for(int i = 0; i< unsortedVector.length; i++){
            tmpArray[i] = unsortedVector[i];
        }
        for (int i = 1; i < tmpArray.length; i++) {
            double tmp = tmpArray[i];
            for (int j = i-1; j >= 0 && tmp < tmpArray[j]; j--) {
                tmpArray[j+1] = tmpArray[j];
                tmpArray[j] = tmp;
            }
        }
        return tmpArray;
    }
}
