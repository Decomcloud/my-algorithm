package cloud.ry.day25num680;
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 👍 496 👎 0

public class num680ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new num680ValidPalindromeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            if (s == null) {
                return false;
            }

            int left = 0;
            int right = s.length() - 1;
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left++;
                right--;
            }

            if (left >= right) {
                return true;
            }

            return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}