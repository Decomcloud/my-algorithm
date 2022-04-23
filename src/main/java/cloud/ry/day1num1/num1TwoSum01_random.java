package cloud.ry.day1num1;

import java.util.Random;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 

// 暴力求解法, 10 * len * len 次数能找到答案
//如果一次求解的概率为$1/n$, 那么只需要重复10n * n 次，就“可以”得到问题的答案。
// 时间复杂度 n2
public class num1TwoSum01_random {
    public static void main(String[] args) {
        Solution solution = new num1TwoSum01_random().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[2];
            Random r = new Random();
            int len = nums.length;
            for (int count = 0; count <= 10 * len * len; count++) {
                int i = r.nextInt(len);
                int j;
                do {
                    j = r.nextInt(len);
                } while (i == j);

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}