package cloud.lintcode.binary;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1718 👎 0

public class num34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new num34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int[] ret = new int[2];
            int start = 0;
            int end = nums.length - 1;
            while (start + 1 < end) {
                // 当start + end 可能超过整数的最大值
                //int mid = (start + end) / 2;
                int mid = start + (end - start) / 2;
                // 当只有2个数时, 会无限卡在这里[1, 1] target =1;
                if (nums[mid] == target) {
                    // 从右半部分继续寻找, 要包括当前这个
                    end = mid;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // 先判断前一个是否相等
            if (nums[start] == target) {
                ret[0] = start;
            } else if (nums[end] == target) {
                ret[0] = end;
            } else {
                ret[0] = -1;
                ret[1] = -1;
                return ret;
            }

            start = 0;
            end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    // 从左半部分继续寻找, 要包括当前这个
                    start = mid;
                } else if (nums[mid] > target) {
                    // 不进行 +1 -1, 也不会报错
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (nums[end] == target) {
                ret[1] = end;
            } else if (nums[start] == target) {
                ret[1] = start;
            }
            return ret;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}