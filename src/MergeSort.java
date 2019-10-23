import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MergeSort implements SortingAlgorithm
{
    @Override
    public double[] sort(double[] unsortedVector) {

        int left = 0;
        int right = unsortedVector.length - 1;

        divide(unsortedVector, left, right);

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
        int l = left;
        int j = middle+1;
        HashMap<Integer,Double> tmp = new HashMap<>();

        for (; l <= right; l++) {
            tmp.put(l,v[l]);
        }

        for (int k = left; k <= right; k++) {
            if(i <= middle) {
                if(j <= right) {
                    if (tmp.get(j) < tmp.get(i)) {
                        v[k] = tmp.get(j++);
                    } else {
                        v[k] = tmp.get(i++);
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
