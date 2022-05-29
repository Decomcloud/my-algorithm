package cloud.lintcode.twoPointer;

/*
 * 给出一个包含正数和负数的数组, 重新排列为一个正负数交替的数组
 *
 * */
public class InterleavingPositiveNegative {
    public static void main(String[] args) {
        Solution solution = new InterleavingPositiveNegative().new Solution();
    }

    class Solution {
        public void reRange(int[] nums) {
            int pos = 0;
            int neg = 0;
            for (int num : nums) {
                if (num > 0) {
                    pos++;
                } else {
                    neg++;
                }
            }
            // 分组, 多的在左面, 少的在右面
            partion(nums, pos > neg);
            interleave(nums, pos == neg);
        }

        private void interleave(int[] nums, boolean hasSameLength) {
            // 因为左面可能多, 所以左面从1开始
            int left = 1;
            int right = nums.length - 1;
            // 当数目相等时, 右面第一个不需要交换, 直接交换第二个
            if (hasSameLength) {
                right = nums.length - 2;
            }
            while (left < right) {
                swap(nums, left, right);
                left = left + 2;
                right = right - 2;
            }
        }

        private void partion(int[] nums, boolean startPositive) {
            int flag = 1;
            if (!startPositive) {
                flag = -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                while (left <= right && nums[left] * flag > 0) {
                    left++;
                }
                while (left <= right && nums[right] * flag < 0) {
                    right--;
                }
                if (left <= right) {
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

}