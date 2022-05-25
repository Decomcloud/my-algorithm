package cloud.ry.day25num125;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 530 👎 0

public class num125ValidPalindrome_doublePointer {
    public static void main(String[] args) {
        Solution solution = new num125ValidPalindrome_doublePointer().new Solution();
        solution.isPalindrome(" ");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // o1
        public boolean isPalindrome(String s) {
            if (s == null) {
                return false;
            }
            if (s.length() == 0) {
                return true;
            }
            char[] array = s.toCharArray();
            int start = 0;
            int end = array.length - 1;
            while (start <= end) {
                while (start <= end && !Character.isLetterOrDigit(array[start])) {
                    start++;
                }
                while (start <= end && !Character.isLetterOrDigit(array[end])) {
                    end--;
                }
                if (start <= end) {
                    if ((String.valueOf(array[start])).equalsIgnoreCase(String.valueOf(array[end]))) {
                        start++;
                        end--;
                    } else {
                        return false;
                    }
                }
            }
            return true;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}