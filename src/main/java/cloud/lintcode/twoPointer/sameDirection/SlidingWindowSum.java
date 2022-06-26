package cloud.lintcode.twoPointer.sameDirection;
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口
//
// 返回 滑动窗口中的和。

public class SlidingWindowSum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int j = 0;
            int[] res = new int[nums.length - k + 1];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                while (j < nums.length && j - i < k) {
                    sum += nums[j];
                    j++;
                }
                if (j - i == k) {
                    res[i] = sum;
                }
                sum = sum - nums[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}