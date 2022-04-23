package cloud.ry.day12num69;
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 991 👎 0

public class num69Sqrtx_binary {
    public static void main(String[] args) {
        Solution solution = new num69Sqrtx_binary().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            long leftNum = 0;
            long rightNum = x;
            long mid = 0;
            while (leftNum <= rightNum) {
                mid = (leftNum + rightNum) / 2;
                int res = ifClose(x, mid);
                if (res == 0) {
                    break;
                } else if (res == 1) {
                    leftNum = mid + 1;
                } else {
                    rightNum = mid - 1;
                }
            }
            return (int) mid;
        }

        private int ifClose(int x, long mid) {
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return 0;
            } else if (mid * mid < x) {
                return 1;
            } else {
                return 2;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}