package cloud.lintcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 10⁹ 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 数学 动态规划 排序 👍 450 👎 0

public class num368LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new num368LargestDivisibleSubset().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int[] dp = new int[nums.length];
            int[] prev = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                prev[i] = -1;
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && dp[j] + 1 >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }

            int pos = 0;
            int maxNumber = 1;
            for (int i = 0; i < nums.length; i++) {
                if (dp[i] > maxNumber) {
                    maxNumber = dp[i];
                    pos = i;
                }
            }
            List<Integer> res = new ArrayList<>();
            while (pos != -1) {
                res.add(nums[pos]);
                pos = prev[pos];
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}