package cloud.ry.day3num53;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4769 👎 0

import java.util.StringJoiner;

public class num53MaximumSubarrayMerge2 {
	public static void main(String[] args) {
		Solution solution = new num53MaximumSubarrayMerge2().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
		// 合并, 正数合并, 负数也合并, 如果需要一个负数,那么和它相连的下一个负数肯定也需要
		int max = bothNegative(nums);
		if (max <= 0) {
			return max;
		}
		int[] mergeArray = mergeArray(nums);
		int sum = Integer.MIN_VALUE;
		for (int i = 0; i< mergeArray.length; i++) {
			int cur = mergeArray[i];
			if (cur > sum) {
				sum = cur;
			}
			for (int j = i + 1; j < mergeArray.length; j ++) {
				cur += mergeArray[j];
				if (cur > sum) {
					sum = cur;
				}
			}
		}
		return sum;
    }

	public int bothNegative(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i ++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max;
	}

	public int[] mergeArray(int[] nums) {
		boolean positive = nums[0] > 0;
		StringJoiner sj = new StringJoiner(";");
		int sum = nums[0];
		for (int i = 1; i < nums.length; i ++) {
			if (nums[i] > 0 == positive) {
				sum+= nums[i];
			} else {
				sj.add(String.valueOf(sum));
				sum = nums[i];
				positive = nums[i] > 0;
			}
		}
		sj.add(String.valueOf(sum));
		String[] numberList = sj.toString().split(";");
		int[] mergeArray = new int[numberList.length];
		for (int i = 0; i < mergeArray.length; i++) {
			mergeArray[i] = Integer.parseInt(numberList[i]);
		}
		return mergeArray;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}