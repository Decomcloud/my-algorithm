package cloud.ry.day7;

import java.util.Arrays;
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 👍 1408 👎 0

public class num169MajorityElement_recursion {
	public static void main(String[] args) {
		Solution solution = new num169MajorityElement_recursion().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		return subArrayMajority(nums, 0, nums.length - 1);
    }

	public int subArrayMajority(int[] nums, int startIndex, int endIndex){
		int arrayLength = endIndex - startIndex + 1;
		int midIndex = (startIndex + endIndex)/2;
		if(arrayLength <= 9){
			Arrays.sort(nums, startIndex, endIndex+1);
			return nums[midIndex];
		}

		int leftMajor = subArrayMajority(nums, startIndex, midIndex);
		if(isMajor(nums, startIndex, endIndex, leftMajor)){
			return leftMajor;
		}else {
			return subArrayMajority(nums, midIndex + 1, endIndex);
		}
	}

	public boolean isMajor(int[] nums, int startIndex, int endIndex, int keyNumber){
		int cnt = 0;
		int halfLen = (endIndex-startIndex+1) /2;
		for(int i = startIndex ;i <= endIndex; i++){
			if(nums[i] == keyNumber){
				cnt++;
				if(cnt > halfLen){
					return true;
				}
			}
		}
		return false;
	}



}
//leetcode submit region end(Prohibit modification and deletion)

}