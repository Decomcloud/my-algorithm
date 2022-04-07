package cloud.ry.day1;

import java.util.HashMap;
import java.util.Map;
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

// 哈希表 n
public class num1TwoSumN {
    public static void main(String[] args) {
        Solution solution = new num1TwoSumN().new Solution();
        //System.out.println(solution.twoSum(new int[]{2,5,5,11}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                // 考虑相同数, 后面会覆盖前面的, 对本题无影响
                // 1 数组遍历是从前面遍历, 所以不影响,
                // 2 不要求顺序,就算返回一个最大下标, 一个最小下标也可以
                //if (map.containsKey(nums[i])) {
                //	if (nums[i] * 2 == target) {
                //		ret[0] = i;
                //		ret[1] = map.get(nums[i]);
                //		return ret;
                //	}
                //}
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                }
            }
            return ret;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}