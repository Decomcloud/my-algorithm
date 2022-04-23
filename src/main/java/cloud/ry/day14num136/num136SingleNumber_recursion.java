package cloud.ry.day14num136;

import java.util.*;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2376 👎 0

public class num136SingleNumber_recursion {
    public static void main(String[] args) {
        Solution solution = new num136SingleNumber_recursion().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            return getSingleNumber(nums, 0, nums.length - 1);
        }

        private int getSingleNumber(int[] nums, int startIndex, int endIndex) {
            int pIndex = partition(nums, startIndex, endIndex);
            int length = endIndex - startIndex + 1;
            if (length <= 3) {
                return getSingleNumberBySet(nums, startIndex, endIndex);
            }
            if ((pIndex - startIndex) % 2 == 0) {
                // 后半段, 并不知道和nums[pIndex]在哪里
                return getSingleNumber(nums, pIndex, endIndex);
            } else {
                // 前半段
                return getSingleNumber(nums, startIndex, pIndex - 1);
            }
        }

        private int getSingleNumberBySet(int[] nums, int startIndex, int endIndex) {
            long sum = 0;
            Set<Integer> uniqueEle = new HashSet<>();
            for (int i = startIndex; i <= endIndex; i++) {
                sum += nums[i];
                uniqueEle.add(nums[i]);
            }
            long uniqueSum = 0;
            for (int n : uniqueEle) {
                uniqueSum += n;
            }
            return (int) (2 * uniqueSum - sum);
        }

        private int partition(int[] nums, int startIndex, int endIndex) {
            int pivot = randomPick(nums, startIndex, endIndex);
            int pivotIndex = startIndex;
            for (int i = startIndex; i <= endIndex; i++) {
                if (nums[i] == pivot) {
                    pivotIndex = i;
                    break;
                }
            }
            //交换哨兵位置
            swap(nums, pivotIndex, endIndex);

            int smallerIndex = startIndex - 1;
            for (int j = startIndex; j < endIndex; j++) {
                if (nums[j] < pivot) {
                    smallerIndex++;
                    swap(nums, j, smallerIndex);
                }
            }
            //让pivot回到正确的位置
            swap(nums, endIndex, ++smallerIndex);
            return smallerIndex;
        }

        private int randomPick(int[] nums, int startIndex, int endIndex) {
            Random r = new Random();
            Set<Integer> set = new LinkedHashSet<>();
            if (endIndex - startIndex + 1 < 22) {
                // toIndex, 不包含
                Arrays.sort(nums, startIndex, endIndex + 1);
                return nums[(endIndex + startIndex) / 2];
            }
            while (set.size() < 11) {
                int offset = r.nextInt(endIndex - startIndex + 1);
                set.add(offset);
            }
            int[] x = new int[11];
            Object[] indexArray = set.toArray();
            for (int i = 0; i < indexArray.length; i++) {
                x[i] = nums[(Integer) indexArray[i] + startIndex];
            }
            Arrays.sort(x);
            return x[5];
        }

        public void swap(int[] a, int i, int j) {
            if (a[i] != a[j]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}