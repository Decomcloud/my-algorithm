package cloud.leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num15_三数之和 {
    public static List<List<Integer>> threeSumoff(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len - 2; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 最小的已经大于0了,直接退出
            if (nums[i] + nums[i+1] + nums[i + 2] > 0){
                break;
            }
            // 最大的小于0,直接退出
            if (nums[i] + nums[len - 1] + nums[len - 2] < 0){
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 去重
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                    // 小于0 最小的指针向右移动
                } else if (sum < 0) {
                    L++;
                }
                // 大于0, 最大的向左移动
                else {
                    R--;
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = 0 - nums[i] - nums[j];
                int search = Arrays.binarySearch(Arrays.copyOfRange(nums, j + 1, nums.length), target);
                if (search >= 0) {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(nums[i]);
                    innerList.add(nums[j]);
                    innerList.add(nums[search + j + 1]);
                    list.add(innerList);
                }
                while (j != nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i != nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return list;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (nums[i] + nums[i+1] + nums[i + 2] > 0){
                break;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0){
                continue;
            }
            if(i > 0 &&nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[j],nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }else if(sum > 0){
                    k--;
                }else {
                    j++;
                }
            }

        }
        return list;
    }

    public static void printList(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums1));

        int[] nums2 = new int[]{0, 0, 0, 0, 0, 0};
        System.out.println(threeSum(nums2));

        int[] nums3 = new int[]{1, -1, -1, 0};
        System.out.println(threeSum(nums3));

        int[] nums4 = new int[]{3, 0, -2, -1, 1, 2};
        System.out.println(threeSum(nums4));
    }
}
