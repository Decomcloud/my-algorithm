package cloud.ry.day3;
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

import javax.swing.*;

public class num53MaximumSubarrayRecursion5 {
	public static void main(String[] args) {
		Solution solution = new num53MaximumSubarrayRecursion5().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
		return maxSumSubArray(nums, 0, nums.length - 1);
    }

	public int maxSumSubArray(int[] nums, int leftIndex, int rightIndex) {
		int length = rightIndex - leftIndex + 1;
		if (length == 1) {
			return nums[leftIndex];
		}
		int mid = (rightIndex + leftIndex) /2;
		int rightMaxSub = maxSumSubArray(nums, mid + 1, rightIndex);
		int leftMaxSub = maxSumSubArray(nums, leftIndex, mid);
		int midMax = maxSumContainsMidIndex(nums, mid, leftIndex, rightIndex);
		return Math.max(rightMaxSub, Math.max(leftMaxSub, midMax));
	}

	// 计算出合并后的最大值
	private int maxSumContainsMidIndex(int[] nums, int mid, int leftIndex, int rightIndex) {
		int leftMax = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= leftIndex; i --) {
			sum += nums[i];
			if (sum> leftMax) {
				leftMax = sum;
			}
		}
		int rightMax = Integer.MIN_VALUE;
		sum = 0;
		for (int i = mid; i <= rightIndex; i ++) {
			sum += nums[i];
			if (sum> rightMax) {
				rightMax = sum;
			}
		}

		return leftMax + rightMax - nums[mid];
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}