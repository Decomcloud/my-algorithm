package cloud.ry.day13num70;

import java.util.LinkedList;
import java.util.List;
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

public class num70ClimbingStairs_fibonacci {
    public static void main(String[] args) {
        Solution solution = new num70ClimbingStairs_fibonacci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            List<Integer> list = new LinkedList<>();
            list.add(1);
            list.add(2);

            for (int i = 2; i < n; i++) {
                list.add(list.get(i - 1) + list.get(i - 2));
            }
            return list.get(n - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}