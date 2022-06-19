package cloud.lintcode.template;

/**
 * @author Yunfeng Sun
 * @date 2022/5/26 20:21
 */
public class MergeSort {
    public void sortInteger(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1, tmp);
    }

    private void mergeSort(int[] array, int start, int end, int[] tmp) {
        if (start >= end) {
            return;
        }
        int pivot = (start + end) / 2;
        mergeSort(array, start, pivot, tmp);
        mergeSort(array, pivot + 1, end, tmp);
        merge(array, start, end, tmp);
    }

    private void merge(int[] array, int start, int end, int[] tmp) {
        int mid = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        while (leftIndex <= mid && rightIndex <= end) {
            if (array[leftIndex] < array[rightIndex]) {
                tmp[index++] = array[leftIndex++];
            } else {
                tmp[index++] = array[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            tmp[index++] = array[leftIndex++];
        }
        while (rightIndex <= end) {
            tmp[index++] = array[rightIndex++];
        }
        for (int i = start; i <= end; i++) {
            array[i] = tmp[i];
        }
    }
}
