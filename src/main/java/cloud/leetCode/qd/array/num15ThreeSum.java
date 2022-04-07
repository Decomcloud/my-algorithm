package cloud.leetCode.qd.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2419 👎 0

public class num15ThreeSum{
	public static void main(String[] args) {
		Solution solution = new num15ThreeSum().new Solution();
		//solution.threeSum(new int[]{-1,0,1,2,-1,-4});
		solution.threeSum(new int[]{0,0,0});
		//solution.threeSum(new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0});

	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// 长度小于3, 直接返回
		if (nums.length < 3){
			return list;
		}
		Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 2; i ++) {
    		// 去重
    		if (i > 0 && nums[i] == nums [i - 1]){
    			continue;
			}
    		// 定义左右指针
    		int left = i + 1;
    		int right = nums.length - 1;
    		int target = -nums[i];
    		// 已经大于0, 直接返回
			if (nums[i] + nums[left] > 0){
				break;
			}
    		while (left < right) {
				if (nums[left] + nums[right] == target){
					list.add(Arrays.asList(nums[i], nums[left] , nums[right]));
					right--; left++;
					// 去重
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
					// 去重
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
				} else if (nums[left] + nums[right] > target) {
					right--;
				} else {
					left++;
				}
			}

		}
		return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}