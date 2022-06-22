package cloud.lintcode.dp;

import java.util.*;
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

public class num368LargestDivisibleSubset_factor {
    public static void main(String[] args) {
        Solution solution = new num368LargestDivisibleSubset_factor().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, Integer> dp = new HashMap<>();
            Map<Integer, Integer> prev = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                dp.put(nums[i], 1);
                prev.put(nums[i], -1);
            }

            int lastNum = nums[0];
            for (int num : nums) {
                for (Integer factor : getFactors(num)) {
                    if (!dp.containsKey(factor)) {
                        continue;
                    }

                    if (dp.get(factor) + 1 > dp.get(num)) {
                        dp.put(num, dp.get(factor) + 1);
                        prev.put(num, factor);
                    }
                }
                if (dp.get(num) > dp.get(lastNum)) {
                    lastNum = num;
                }
            }
            return getPath(prev, lastNum);
        }

        private List<Integer> getPath(Map<Integer, Integer> prev, int lastNum) {
            List<Integer> path = new ArrayList<>();
            while (lastNum != -1) {
                path.add(lastNum);
                lastNum = prev.get(lastNum);
            }
            Collections.reverse(path);
            return path;
        }

        private Set<Integer> getFactors(int num) {
            Set<Integer> factors = new HashSet<>();
            if (num == 1) {
                return factors;
            }
            int factor = 1;
            while (factor * factor <= num) {
                if (num % factor == 0) {
                    factors.add(factor);
                    if (factor != 1 && factor * factor != num) {
                        factors.add(num / factor);
                    }
                }
                factor++;
            }
            return factors;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}