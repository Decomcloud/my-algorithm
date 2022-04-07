package cloud.leetCode.latest;

/**
 * @author Yunfeng Sun
 * @date 2020/7/23 20:25
 */
public class num238 {
    public static void moveZeroes(int[] nums){
        // 用于记录0的位置
        int pos = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                //如果i 和 pos相等, 说明之前都是非0, 直接后移动
                if (i != pos){
                    nums[pos] = nums[i];
                    // 移动后需要将该位置变成0
                    nums[i] = 0;
                }
                pos++;

            }
        }
        nums[pos] = 0;
    }

    public static void printArray(int[] nums){
        for (int t: nums){
            System.out.print(t + ", ") ;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0, 1, 4, 2, 0, 3, 4, 0};
        printArray(nums1);
        moveZeroes(nums1);
        printArray(nums1);
        System.out.println("-----");

        int[] nums2 = {2, 0, 0, 1, 4, 2, 0, 3, 4, 0};
        printArray(nums2);
        moveZeroes(nums2);
        printArray(nums2);
        System.out.println("-----");

        int[] nums3 = {2, 1, 1, 4, 2, 0, 3, 4, 0};
        printArray(nums3);
        moveZeroes(nums3);
        printArray(nums3);
    }
}
