package cloud.ry.day1;

import java.util.Arrays;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// Related Topics 数组 哈希表 👍 13136 👎 0

// 排序 二分法遍历 时间复杂度 nlogn
public class num1TwoSumNLogN {
    public static void main(String[] args) {
        Solution solution = new num1TwoSumNLogN().new Solution();
        //System.out.println(solution.twoSum(new int[]{2,5,5,11}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[2];
            int[] sortedArray = nums.clone();
            // n logn
            Arrays.sort(sortedArray);

            for (int i = 0; i < sortedArray.length; i++) {
                int index = binarySearchSortedArray(sortedArray, i + 1, target - sortedArray[i]);
                if (index != -1) {
                    ret[0] = getNumberIndex(nums, sortedArray[i], -1);
                    ret[1] = getNumberIndex(nums, sortedArray[index], ret[0]);
                    return ret;
                }
            }

            return ret;
        }

        // 时间复杂度 n
        public int getNumberIndex(int[] nums, int num, int forbiddenIndex) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num && i != forbiddenIndex) {
                    return i;
                }
            }
            return -1;
        }

        // 时间复杂度 logn
        public int binarySearchSortedArray(int[] sortedNums, int startIndex, int num) {
            int index = -1;
            int leftIndex = startIndex;
            int rightIndex = sortedNums.length - 1;
            while (leftIndex <= rightIndex) {
                int midIndex = (rightIndex + leftIndex) / 2;
                if (sortedNums[midIndex] == num) {
                    return midIndex;
                } else if (sortedNums[midIndex] > num) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}