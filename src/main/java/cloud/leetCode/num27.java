package cloud.leetCode;

import java.util.Arrays;

public class num27 {
    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = nums.length ;
        while (i < j){
            if(nums[i] == val){
                if(nums[j -1] != val){
                    nums[i]  = nums[j - 1];
                    j--;
                }else {
                    j--;
                    continue;
                }
            }
            i ++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{0,1,2,2,3,0,4,2};
        int i1 = removeElement(array1, 2);
        System.out.println(i1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = new int[]{1};
        int i2 = removeElement(array2, 1);
        System.out.println(i2);
        System.out.println(Arrays.toString(array2));
    }
}
