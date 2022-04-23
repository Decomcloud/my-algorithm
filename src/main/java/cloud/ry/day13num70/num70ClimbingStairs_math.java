package cloud.ry.day13num70;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2382 👎 0

public class num70ClimbingStairs_math {
    public static void main(String[] args) {
        Solution solution = new num70ClimbingStairs_math().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            // f(n) = f(n-2) + f(n-1)
            // f(n) + af(n-1) = b(f(n-1) + af(n-2))
            // a2 + a - 1 =0 b2 - b +1 =0
            // ax2 + bx +c =0  x = (-b +- 根号(b2 - 4ac))/2a
            // f0 = f2 - f1 = 1  a +1 = b
            // f(n) + af(n-1) = b n-1 (f(1) + af(0) ) =bn
            // f(n) = -af(n-1) + bn
            // 改成等比 f(n) + c * b n+1 = -a(f(n-1) + c * b n)
            // c = -1/(a+b)
            // f(n) + c * b n+1 = -a n (1 + cb) 带入c
            // f(n) = (b n+1 - (-a) n+1) / (a+b)
            double sqrt5 = Math.pow(5, 0.5);
            double leftN = Math.pow((1.0 + sqrt5) / 2.0, n + 1);
            double rightN = Math.pow((1.0 - sqrt5) / 2.0, n + 1);
            double above = leftN - rightN;
            return (int) Math.round(above / sqrt5);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}