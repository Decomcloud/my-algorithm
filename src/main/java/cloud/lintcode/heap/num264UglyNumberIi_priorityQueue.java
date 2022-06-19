package cloud.lintcode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 921 👎 0

public class num264UglyNumberIi_priorityQueue {
    public static void main(String[] args) {
        Solution solution = new num264UglyNumberIi_priorityQueue().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> heap = new PriorityQueue<>();
            heap.add(1L);
            Set<Long> set = new HashSet<>();
            set.add(1L);
            int[] factors = new int[]{2, 3, 5};
            long currUgly = 1;
            long newUgly;
            for (int i = 0; i < n; i++) {
                currUgly = heap.poll();
                for (int factor : factors) {
                    newUgly = currUgly * factor;
                    if (!set.contains(newUgly)) {
                        set.add(newUgly);
                        heap.add(newUgly);
                    }
                }
            }
            return (int) currUgly;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}