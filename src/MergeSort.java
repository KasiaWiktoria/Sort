public class MergeSort implements SortingAlgorithm
{
    @Override
    public double[] sort(double[] unsortedVector) {

        double[] sortedVector = new double[unsortedVector.length];
        for(int i = 0; i< unsortedVector.length; i++){
            sortedVector[i] = unsortedVector[i];
        }

        int left = 0;
        int right = sortedVector.length - 1;

        divide(sortedVector, left, right);
        return sortedVector;
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
        double[] tmp = new double[right-left+1];
        int p = 0;
        for (int k = left; k <= right; k++) {
            if(i <= middle) {
                if(j <= right) {
                    if (v[j] < v[i]) {
                        tmp[p++] = v[j++];
                    } else {
                        tmp[p++] = v[i++];
                    }
                }
                else {
                    tmp[p++] = v[i++];
                }
            }else {
                tmp[p++] = v[j++];
            }
        }

        p = 0;
        for(int w=left; w<=right; w++){
            v[w] = tmp[p++];
        }
    }
}