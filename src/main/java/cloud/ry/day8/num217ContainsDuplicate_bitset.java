package cloud.ry.day8;

import java.util.BitSet;
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

public class num217ContainsDuplicate_bitset {
	public static void main(String[] args) {
		Solution solution = new num217ContainsDuplicate_bitset().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
		// n 是nums的长度, m是元素的大小, m在bitset中为logM, 所以时间复杂度为n*logM, 空间为M
		BitSet bitSet = new BitSet();
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			min = Math.min(min, num);
		}
		for (int num : nums) {
			// bitSet.size()是最后一位为1的位置, 如果都比差值小, 那么肯定没有这个元素
			if (bitSet.size() > num - min && bitSet.get(num - min)) {
				return true;
			}
			bitSet.set(num - min);
		}
		return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}