package cloud.leetCode.qd.array;

import java.util.HashMap;
import java.util.Map;
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8749 👎 0

public class num1TwoSum{
	public static void main(String[] args) {
		Solution solution = new num1TwoSum().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++){
			if (map.containsKey(nums[i])){
				return new int[]{map.get(nums[i]), i};
			}
			map.put(target - nums[i], i);
		}
		return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}