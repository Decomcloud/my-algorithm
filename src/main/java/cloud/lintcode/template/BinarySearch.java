package cloud.lintcode.template;

/**
 * @author Yunfeng Sun
 * @date 2022/5/30 7:44
 */
public class BinarySearch {

    // key words: array, target, sorted, equal, close to target, NlogN -> N次二分
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        // 用start + 1 < end 而不是 start < end是为了避免出现死循环
        // 在first position of target 情况下不会出现死循环,
        // 但是在last position of target的情况下会出现死循环
        // eg: [1, 1]
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                // start = mid + 1也是正确的, 这样写是为了不会不小心写成 mid - 1
                start = mid;
            } else if (nums[mid] == target) {
                end = mid;
            } else {
                // end = mid - 1也是正确的, 这样写是为了不会不小心写成 mid + 1
                end = mid;
            }
        }
        // 这里的退出条件为start, end是相邻关系, 需要单独判断哪个相等
        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
