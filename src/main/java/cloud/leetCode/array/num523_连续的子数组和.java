package cloud.leetCode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
* 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

示例 1:

输入: [23,2,4,6,7], k = 6
输出: True
解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
示例 2:

输入: [23,2,6,4,7], k = 6
输出: True
解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
说明:

数组的长度不会超过10,000。
你可以认为所有数字总和在 32 位有符号整数范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/continuous-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class num523_连续的子数组和 {
    public static boolean checkSubarraySum2(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        k = Math.abs(k);
        for (int i = 0; i < nums.length; i++) {
            sum = k==0?sum + nums[i]:(sum + nums[i])%k;
            if (list.indexOf(sum) != -1){
                return true;
            }
            list.add(sum);
        }
        return false;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 0};
        System.out.println(checkSubarraySum(nums1, 0));
    }
}
