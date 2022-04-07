package cloud.leetCode.array;

import java.util.Arrays;

public class num16_最接近的三数之和 {
    public static int threeSumClosest2(int[] nums, int target) {
        int len = nums.length - 1;
        if (len < 2) return 0;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int last = j + 1;
                while (last <= len) {
                    int sum = nums[j] + nums[last] + nums[i];
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                        if (Math.abs(res - target) == 0) {
                            return res;
                        }
                    }
                    last++;
                }
            }
        }
        return res;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        if (len < 2) return 0;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 1; i++) {
            int left = i + 1;
            int right = len;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if(sum > target){
                    right --;
                }else if (sum < target){
                    left ++;
                }else {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*int[] nums1 = new int[]{-1,2, 1, -4};
        System.out.println(threeSumClosest(nums1, 1));

        int[] nums2 = new int[]{0,0, 0};
        System.out.println(threeSumClosest(nums2, 1));*/

        int[] nums3 = new int[]{1, 1, -1, -1, 3};
        System.out.println(threeSumClosest(nums3, -1));
    }
}
