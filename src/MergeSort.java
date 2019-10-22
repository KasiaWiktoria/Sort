import java.util.ArrayList;

public class MergeSort implements SortingAlgorithm
{
    @Override
    public double[] sort(double[] unsortedVector) {
        double[] sortedVector = new double[unsortedVector.length];

        int left = 0;
        int right = unsortedVector.length;
        int middle = (left + right)/2;

        merge(unsortedVector, left, middle, right);

        return unsortedVector;
    }

    public void divide(double v[], int left, int right){

        if(right <= left){
            return;
        }

        int middle = (left + right)/2;

        divide(v, left, middle);
        divide(v, middle+1, right);

        merge(v, left, middle, right);
    }

    public void merge(double v[], int left, int middle, int right){
        int i = left;
        int j = middle+1;
        ArrayList<Double> tmp = new ArrayList();

        for (; i <= right; i++) {
            tmp.add(i,v[i]);
        }

        for (int k = left; k <= right; k++) {
            if(i <= middle) {
                if(j <= right) {
                    if (tmp.get(i) < tmp.get(j)) {
                        v[k] = tmp.get(i++);
                    } else {
                        v[k] = tmp.get(j++);
                    }
                }
                else {
                    v[k] = tmp.get(i++);
                }
            }else {
                v[k] = tmp.get(j++);
            }
        }
    }
}
