package cloud.lintcode.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4824 👎 0

public class num15ThreeSum_sortThreePointer {
    public static void main(String[] args) {
        Solution solution = new num15ThreeSum_sortThreePointer().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> results = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                findTwoSum(nums, i, results);
            }
            return results;
        }

        private void findTwoSum(int[] nums, int index, List<List<Integer>> results) {
            int left = index + 1;
            int right = nums.length - 1;
            int targetNum = -nums[index];
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum > targetNum) {
                    right--;
                } else if (twoSum < targetNum) {
                    left++;
                } else {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[index]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    results.add(res);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && right != nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}