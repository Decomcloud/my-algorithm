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
public class twoDifference_saneDirectionPointer {
    public static void main(String[] args) {

    }

    // 0n
    public int[] twoSum(int[] nums, int target) {
        target = Math.abs(target);
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            // j 必须要比i大
            j = Math.max(j, i + 1);
            // 差值 >= target, 才退出
            // 上次 i移动, 那么如果要找到差值>=target的值, j最少也要比现在靠后
            while (j < nums.length && nums[j] - nums[i] < target) {
                j++;
            }
            if (j >= nums.length) {
                break;
            }
            if (nums[j] - nums[i] == target) {
                return new int[]{nums[j], nums[i]};
            }
        }
        return new int[]{-1, -1};
    }


}
