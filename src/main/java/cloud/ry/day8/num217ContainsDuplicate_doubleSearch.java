package cloud.ry.day8;

import java.util.Arrays;
//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,3,3,4,3,2,4,2]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 哈希表 排序 👍 711 👎 0

public class num217ContainsDuplicate_doubleSearch {
	public static void main(String[] args) {
		Solution solution = new num217ContainsDuplicate_doubleSearch().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i ++) {
			int j = nums.length - 1;
			if (nums[i] == nums[i+1] || nums[j] == nums[j-1]) {
				return true;
			}
		}
		return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}