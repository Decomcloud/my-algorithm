package cloud.lintcode.twoPointer;
//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库的sort函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1285 👎 0

public class num75SortColors {
    public static void main(String[] args) {
        Solution solution = new num75SortColors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            // 遇到0放到左面, 遇到2放到右面
            // 也可以用双指针, 一次排出, 0,1 和2, 在用双指针排序一次
            int left = 0;
            int index = 0;
            int right = nums.length - 1;
            while (index <= right) {
                if (nums[index] == 0) {
                    // 左面交换后, 当前交换过来的数只能是1, 因为left <= index, 所有左面的数只能是1
                    swap(nums, left, index);
                    left++;
                    index++;
                } else if (nums[index] == 2) {
                    // 右面的交换过来后, index 不需要++, 直接处理交换后的数就可以.\
                    swap(nums, index, right);
                    right--;
                } else {
                    index++;
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