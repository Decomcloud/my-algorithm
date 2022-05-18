package cloud.ry.day23num20;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3246 👎 0

public class num20ValidParentheses_recursion {
    public static void main(String[] args) {
        Solution solution = new num20ValidParentheses_recursion().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] brackets = s.toCharArray();
            String stack = subStrIsValid(brackets, 0, brackets.length - 1);
            return !(stack.length() > 0);
        }

        public String subStrIsValid(char[] brackets, int start, int end) {
            //4可以进行修改，这个地方是递归出口，可以是2，3等等
            if (end - start <= 4) {
                //整个的递归出口的实现和stack方法一致
                StringBuilder sb = new StringBuilder();
                for (int i = start; i <= end; i++) {
                    char charIn = brackets[i];
                    char charTop = sb.length() > 0 ? sb.charAt(sb.length() - 1) : ' ';
                    if (("" + charTop + charIn).equals("{}") || ("" + charTop + charIn).equals("[]") || ("" + charTop + charIn).equals("()")) {
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    } else {
                        sb.append(charIn);
                    }
                }
                return sb.toString();
            }
            //子问题的切割，从中间分开string
            int mid = (end - start) / 2 + start;
            String leftBrackets = subStrIsValid(brackets, start, mid);
            String rightBrackets = subStrIsValid(brackets, mid + 1, end);
            //父问题的解，等同于将左右子问题返回的string进行二次括号匹配。
            return combinedTwoParts(leftBrackets, rightBrackets);
        }

        public String combinedTwoParts(String left, String right) {
            char[] leftBrackets = left.toCharArray();
            char[] rightBrackets = right.toCharArray();
            if (left.length() == 0) {
                return right;
            } else if (right.length() == 0) {
                return left;
            }
            StringBuilder str = new StringBuilder();
            //i是左子问题的遍历指针，应从最后向前遍历
            int i = leftBrackets.length - 1;
            //j是右子问题的遍历指针，应从最前向后遍历
            int j = 0;
            while (i >= 0 && j < rightBrackets.length) {
                String s = "" + leftBrackets[i] + rightBrackets[j];
                //左右子问题的返回中不一定都是未匹配的左右括号。可能都含有
                if (!(s.equals("{}") || s.equals("[]") || s.equals("()"))) {
                    str = new StringBuilder(leftBrackets[i] + str.toString() + rightBrackets[j]);
                }
                j++;
                i--;
            }
            if (i >= 0) {
                for (; i >= 0; i--) {
                    str = new StringBuilder(leftBrackets[i] + str.toString());
                }
            } else if (j < rightBrackets.length) {
                for (; j < rightBrackets.length; j++) {
                    str.append(rightBrackets[j]);
                }
            }
            return str.toString();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}