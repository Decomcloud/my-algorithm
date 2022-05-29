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

public class num75SortColors_multiColor {
    public static void main(String[] args) {
        Solution solution = new num75SortColors_multiColor().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 多色排序
        public void sortColors(int[] nums) {
            sortMultiColors(nums, 3);
        }

        // typeNums => {0, 1, 2, 3}, 默认为从0开始连续的数
        private void sortMultiColors(int[] nums, int typeNums) {
            sort(nums, 0, typeNums - 1, 0, nums.length - 1);
        }

        private void sort(int[] nums, int fromColorNum, int toColorNum, int indexFrom, int indexTo) {
            if (fromColorNum == toColorNum || indexFrom == indexTo) {
                return;
            }
            int colorNum = fromColorNum + (toColorNum - fromColorNum) / 2;
            int left = indexFrom;
            int right = indexTo;
            while (left <= right) {
                // 0,1,2,3  0 + 3 /2 = 1, 所以为了均匀分布, 左面应该<=
                while (left <= right && nums[left] <= colorNum) {
                    left++;
                }
                while (left <= right && nums[right] > colorNum) {
                    right--;
                }
                if (left <= right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                    right--;
                }
            }
            sort(nums, fromColorNum, colorNum, indexFrom, right);
            sort(nums, colorNum + 1, toColorNum, left, indexTo);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}