package cloud.lintcode.hash;

import java.util.*;
//给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 
//blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。 
//
// 优化你的算法，使它最小化调用语言 内置 随机函数的次数。 
//
// 实现 Solution 类: 
//
// 
// Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数 
// int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
//[[7, [2, 3, 5]], [], [], [], [], [], [], []]
//输出
//[null, 0, 4, 1, 6, 1, 0, 4]
//
//解释
//Solution solution = new Solution(7, [2, 3, 5]);
//solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
//                 // 0、1、4和6的返回概率必须相等(即概率为1/4)。
//solution.pick(); // 返回 4
//solution.pick(); // 返回 1
//solution.pick(); // 返回 6
//solution.pick(); // 返回 1
//solution.pick(); // 返回 0
//solution.pick(); // 返回 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁹ 
// 0 <= blacklist.length <= min(10⁵, n - 1) 
// 0 <= blacklist[i] < n 
// blacklist 中所有值都 不同 
// pick 最多被调用 2 * 10⁴ 次 
// 
// Related Topics 哈希表 数学 二分查找 排序 随机化 👍 144 👎 0

public class num710RandomPickWithBlacklist {
    public static void main(String[] args) {
        //Solution solution = new num710RandomPickWithBlacklist().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Random rd = new Random();
        int bound;
        Map<Integer, Integer> b2w = new HashMap<>();
        // 如果用例的黑名单非常庞大，
        // 随机生成的数字非常容易落入黑名单的范围。
        // 这也是问题描述中「对它进行优化使其尽量少调用系统方法 Math.random() 」一句的潜在含义。
        //
        // 黑名单不行，白名单总行吧？
        // 生成一个不包含所有黑名单元素的数组，然后随机生成索引，
        // 再用该索引访问数组，得到结果。遗憾的是，答案是否。
        // 因为有一个测试用例的n为1000000000，当生成这么长的一个数组时，内存会溢出

        public Solution(int n, int[] blacklist) {
            int m = blacklist.length;
            bound = n - m;
            Set<Integer> black = new HashSet<Integer>();
            // 超出n - m的黑名单数, 加入black
            for (int b : blacklist) {
                if (b >= bound) {
                    black.add(b);
                }
            }

            int w = bound;
            // 找到小于bound的黑名单节点, 映射到超出bound的白名单节点
            for (int b : blacklist) {
                if (b < bound) {
                    while (black.contains(w)) {
                        w++;
                    }
                    b2w.put(b, w);
                    w++;
                }
            }
        }

        public int pick() {
            int x = rd.nextInt(bound);
            return b2w.getOrDefault(x, x);
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}