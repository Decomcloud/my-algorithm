package cloud.ry.day24num28;
//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
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
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1432 👎 0

public class num28ImplementStrstr_hash {
    public static void main(String[] args) {
        Solution solution = new num28ImplementStrstr_hash().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {

            if (haystack == null || needle == null) {
                return -1;
            }
            int BASE = 1000000;
            int m = needle.length();
            if (m == 0) {
                return 0;
            }

            int power = 1;
            for (int i = 0; i < m; i++) {
                power = (power * 31) % BASE;
            }

            int needleCode = 0;
            for (int i = 0; i < m; i++) {
                needleCode = (needleCode * 31 + needle.charAt(i)) % BASE;
            }

            int hashCode = 0;
            for (int i = 0; i < haystack.length(); i++) {
                hashCode = (hashCode * 31 + haystack.charAt(i)) % BASE;
                if (i < m - 1) {
                    continue;
                }
                if (i >= m) {
                    // 移除第一位
                    hashCode = hashCode - (haystack.charAt(i - m) * power) % BASE;
                    if (hashCode < 0) {
                        hashCode += BASE;
                    }
                }

                if (hashCode == needleCode) {
                    if (haystack.substring(i - m + 1, i + 1).equals(needle)) {
                        return i - m + 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}