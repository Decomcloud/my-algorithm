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

public class num28ImplementStrstr_BM {
    public static void main(String[] args) {
        Solution solution = new num28ImplementStrstr_BM().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            } else if (haystack.length() < needle.length()) {
                return -1;
            }
            char[] mainChar = haystack.toCharArray();
            char[] patternChar = needle.toCharArray();
            int mainCharCurPosition = patternChar.length - 1;
            int x = patternChar.length - 1;
            int y = patternChar.length - 1;
            String goodTail = "";
            while (y >= 0 && x < mainChar.length) {
                //相同则移动
                if (mainChar[x] == patternChar[y]) {
                    goodTail = mainChar[x] + goodTail;
                    x--;
                    y--;
                } else {
                    //右侧第一个就是坏字符
                    if (goodTail.length() == 0) {
                        int offSet = movePatternByBadChar(patternChar, mainChar[x]);
                        mainCharCurPosition += offSet;
                        x = mainCharCurPosition;
                        y = patternChar.length - 1;
                    } else {
                        int offSet = movePatternByGoodTail(patternChar, goodTail);
                        mainCharCurPosition += offSet;
                        x = mainCharCurPosition;
                        y = patternChar.length - 1;
                        goodTail = "";
                    }
                }
            }

            if (y < 0) {
                return x + 1;
            } else {
                return -1;
            }
        }

        public int movePatternByBadChar(char[] patternChar, char badChar) {
            for (int i = patternChar.length - 2; i >= 0; i--) {
                if (patternChar[i] == badChar) {
                    return patternChar.length - 1 - i;
                }
            }
            return patternChar.length;
        }

        public int movePatternByGoodTail(char[] patternChar, String goodTail) {
            for (int i = patternChar.length - 2; i >= 0; i--) {
                if (ifMapped(patternChar, goodTail, i)) {
                    return patternChar.length - 1 - i;
                }
            }
            return patternChar.length;
        }

        public boolean ifMapped(char[] patternChar, String goodTail, int end) {
            char[] goodChars = goodTail.toCharArray();
            for (int i = end, x = goodChars.length - 1; i >= 0 && x >= 0; i--, x--) {
                if (!(patternChar[i] == goodChars[x])) {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}