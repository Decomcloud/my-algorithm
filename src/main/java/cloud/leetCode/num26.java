package cloud.leetCode;

public class num26 {
    public static int removeDuplicates(int[] nums) {

        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int i = 0,j =1;
        while (j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return ++i;
    }

    public static void main(String[] args) {
        int i = removeDuplicates(new int[]{1, 1, 2});
        System.out.println(i);
    }
}
