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

public class num28ImplementStrstr_Sunday {
    public static void main(String[] args) {
        Solution solution = new num28ImplementStrstr_Sunday().new Solution();
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
            int x = 0;
            int y = 0;
            while (y < patternChar.length && x < mainChar.length) {
                //相同则移动
                if (mainChar[x] == patternChar[y]) {
                    x++;
                    y++;
                } else {
                    //右侧第一个就是坏字符
                    int z = x + patternChar.length - y;
                    if (z >= mainChar.length) {
                        return -1;
                    }
                    int offSet = findCharInPattern(patternChar, mainChar[z]);
                    x = z - offSet;
                    y = 0;
                }
            }

            if (y == patternChar.length) {
                return x - y;
            } else {
                return -1;
            }
        }

        public int findCharInPattern(char[] patternChar, char badChar) {
            for (int i = patternChar.length - 1; i >= 0; i--) {
                if (patternChar[i] == badChar) {
                    return i;
                }
            }
            return 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}