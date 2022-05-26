package cloud.lintcode;

/**
 * @author Yunfeng Sun
 * @date 2022/5/26 20:21
 */
public class QuickSort {
    public void sortInteger(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[(start + end) / 2];
        int left = start;
        int right = end;
        // <会导致Left和right相等, 会有一个值永远都在排序, 最后溢出
        while (left <= right) {
            // 如果是<= pivot, 当数组都是相同数时, 会导致left一直移动到最右,
            // 下次取值也会移动到最右面, 导致溢出
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
        quickSort(array, start, right);
        quickSort(array, left, end);
    }
}
