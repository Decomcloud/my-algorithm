package cloud.leetCode.stack;
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 529 👎 0

public class num224BasicCalculator{
	public static void main(String[] args) {
		Solution solution = new num224BasicCalculator().new Solution();
		int res = solution.calculate("2147483647");
		System.out.println(res);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
    	int res = 0;
		char operator = '+';
		int length = s.length();
		for(int i = 0; i < length; i++) {
			char c = s.charAt(i);
    		if ('+' == c || '-' == c) {
    			operator = c;
			} else if ('(' == c || ')' == c || ' ' == c) {
    			continue;
			} else {
    			int current = i;
    			while (i != length - 1) {
					char b = s.charAt(i + 1);
					if ('+' == b || '-' == b || '(' == b || ')' == b || ' ' == b) {
						break;
					}
					i ++;
				}
    			String value = s.subSequence(current, i + 1).toString();
    			if (operator == '+') {
    				res += Integer.parseInt(value);
				} else {
					res -= Integer.parseInt(value);
				}
			}
		}
    	return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}