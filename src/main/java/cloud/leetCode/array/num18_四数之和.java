package cloud.leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num18_四数之和 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length - 1 ;
        for (int i = 0; i < len - 2; i++) {
            if (i>0&&nums[i] == nums[i-1]) continue;
            int sum = target - nums[i];
            int min1=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min1>target){
                break;
            }
            int max1=nums[i]+nums[len]+nums[len-1]+nums[len-2];
            if(max1<target){
                continue;
            }
            for (int j = i+1; j < len - 1; j++) {
                if (j!=i+1&&nums[j] == nums[j-1]) continue;
                int lef = j + 1;
                int right = len;
                int min=nums[i]+nums[j]+nums[lef]+nums[lef+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[i]+nums[j]+nums[right]+nums[right-1];
                if(max<target){
                    continue;
                }
                while (lef<right){
                    int total = nums[j] + nums[lef] + nums[right];
                    if(total == sum){
                        list.add(Arrays.asList(nums[i], nums[j], nums[lef], nums[right]));
                        while (lef<right && nums[lef] == nums[lef + 1]) lef++;
                        while (lef<right && nums[right] == nums[right-1]) right--;
                        right--;
                        lef++;
                    }else if (total>sum){
                        right--;
                    }else {
                        lef++;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println((fourSum(nums1, 0)));

        int[] nums2 = new int[]{-1,0,1,2,-1,-4};
        System.out.println((fourSum(nums2, -1)));
    }
}
