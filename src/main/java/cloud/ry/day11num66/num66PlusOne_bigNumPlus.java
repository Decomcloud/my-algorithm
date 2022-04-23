package cloud.ry.day11num66;
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 数学 👍 996 👎 0

import java.util.LinkedList;
import java.util.List;

public class num66PlusOne_bigNumPlus {
    public static void main(String[] args) {
        Solution solution = new num66PlusOne_bigNumPlus().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int[] one = new int[]{1};
            return bigNumPlus(digits, one);
        }

        private int[] bigNumPlus(int[] numOne, int[] numTwo) {
            List<Integer> reverseSum = new LinkedList<>();
            int i = numOne.length - 1;
            int j = numTwo.length - 1;
            int carry = 0;
            while (i >= 0 || j >= 0) {
                int localSum = (i >= 0 ? numOne[i] : 0) + (j >= 0 ? numTwo[j] : 0) + carry;
                reverseSum.add(localSum % 10);
                carry = localSum / 10;
                if (j >= 0) {
                    j--;
                }
                if (i >= 0) {
                    i--;
                }
            }
            if (carry > 0) {
                reverseSum.add(carry);
            }
            int retLen = reverseSum.size();
            int[] ret = new int[retLen];
            for (int k = retLen - 1; k >= 0; k--) {
                ret[retLen - k - 1] = reverseSum.get(k);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}