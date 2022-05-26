package cloud.lintcode;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1686 👎 0

public class num215KthLargestElementInAnArray_quickSort {
    public static void main(String[] args) {
        Solution solution = new num215KthLargestElementInAnArray_quickSort().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if (nums == null) {
                return -1;
            }
            return quickSelect(nums, 0, nums.length - 1, k);
        }

        private int quickSelect(int[] nums, int start, int end, int k) {
            if (start == end) {
                return nums[start];
            }
            int left = start;
            int right = end;
            int pivot = nums[(start + end) / 2];
            // 反向 从大到下排序
            while (left <= right) {
                while (left <= right && nums[left] > pivot) {
                    left++;
                }
                while (left <= right && nums[right] < pivot) {
                    right--;
                }
                if (left <= right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                    right--;
                }
            }
            // x现在left在右面, rigth在左面
            if (k + start - 1 <= right) {
                return quickSelect(nums, start, right, k);
            }

            if (k + start - 1 >= left) {
                return quickSelect(nums, left, end, k + start - left);
            }
            // left 和 right中间可能还有一个数
            return nums[right + 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}