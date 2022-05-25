package cloud.ry.day24num28;
//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1423 👎 0

public class num28ImplementStrstr_kmp {
    public static void main(String[] args) {
        Solution solution = new num28ImplementStrstr_kmp().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // on+m
        public int strStr(String haystack, String needle) {
            if (haystack.startsWith(needle)) {
                return 0;
            }
            int[] next = next(needle);
            // j代表了目前多少位相等
            int j = 0;
            // o(n + m)
            for (int i = 0; i < haystack.length(); i++) {
                // 不相等就把目标串缩短, 直到相等
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i - j + 1;
                }
            }

            return -1;
        }

        // 找到目标串前后相同的字符串的数量
        // abeab
        // 00012
        // Om
        public int[] next(String pattern) {
            char[] p = pattern.toCharArray();
            int[] next = new int[p.length];
            next[0] = 0;
            for (int i = 1; i < p.length; i++) {
                if (p[i] == p[next[i - 1]]) {
                    //next[i-1], 是i-1对应的字符的下一个字符
                    next[i] = next[i - 1] + 1;
                } else {
                    //i-1下一个候选位置，相似位置
                    int j = next[i - 1] - 1;
                    while (j > 0) {
                        if (p[i] == p[next[j]]) {
                            next[i] = next[j] + 1;
                            break;
                        } else {
                            j = next[j] - 1;
                        }
                    }
                    if (j <= 0) {
                        if (p[i] == p[0]) {
                            next[i] = next[j] + 1;
                        } else {
                            next[i] = 0;
                        }
                    }
                }
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}