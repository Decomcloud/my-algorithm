package cloud.lintcode.twoPointer;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 👍 1606 👎 0

public class num283MoveZeroes_noOrder {
    public static void main(String[] args) {
        Solution solution = new num283MoveZeroes_noOrder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                while (left < right && nums[left] != 0) {
                    left++;
                }
                while (left < right && nums[right] == 0) {
                    right--;
                }
                if (left < right) {
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}