package cloud.lintcode.twoPointer.sameDirection;

/**
 * 描述
 * 给定一个排序后的整数数组，找到两个数的 差 等于目标值。
 * 你需要返回一个包含两个数字的列表 [num1, num2], 使得 num1 与 num2 的差为 target，同时 num1 必须小于 num2。
 * 保证只有一个答案。
 * 注意：要求用O(1)空间复杂度完成。
 * <p>
 * 样例
 * 例1:
 * 输入: nums = [2, 7, 15, 24], target = 5
 * 输出: [2, 7]
 * 解释:
 * (7 - 2 = 5)
 * <p>
 * 例2:
 * 输入: nums = [1, 1], target = 0
 * 输出: [1, 1]
 * 解释:
 * (1 - 1 = 0)
 */
public class twoDifference_binarySearch {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int smaller = nums[i];
            int larger = binarySearch(nums, i + 1, nums.length - 1, smaller + Math.abs(target));
            if (larger != -1) {
                return new int[]{smaller, nums[larger]};
            }
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        if (start == target) {
            return start;
        }
        if (end == target) {
            return end;
        }
        return -1;


    }


}
