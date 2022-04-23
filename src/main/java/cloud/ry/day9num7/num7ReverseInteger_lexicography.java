package cloud.ry.day9num7;
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3491 👎 0

public class num7ReverseInteger_lexicography {
	public static void main(String[] args) {
		Solution solution = new num7ReverseInteger_lexicography().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
		String MAX_VALUE = "2147483647";
		String MIN_VALUE = "2147483648";
		String rev = reverseNum(Math.abs(x));
		// 长度不相等
		if (rev.length() < MAX_VALUE.length()) {
			if (x >= 0 ) {
				return Integer.parseInt(rev);
			} else {
				return -Integer.parseInt(rev);
			}
		}
		if (x > 0) {
			if (lexicographyLarge(rev, MAX_VALUE)) {
				return 0;
			}
			return Integer.parseInt(rev);
		} else {
			if (lexicographyLarge(rev, MIN_VALUE)) {
				return 0;
			}
			return -Integer.parseInt(rev);
		}
    }

	private boolean lexicographyLarge(String x, String y) {
		for (int i = 0; i < x.length(); i++) {
			int num = Integer.parseInt(String.valueOf(x.charAt(i)));
			int compare = Integer.parseInt(String.valueOf(y.charAt(i)));
			if (num < compare) {
				return false;
			} else if (num > compare) {
				return true;
			}
		}
		return false;
	}
	private String reverseNum(int x) {
		String number = String.valueOf(x);
		char[] chars = number.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = chars.length - 1; i >= 0; i--) {
			sb.append(chars[i]);
		}
		return sb.toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}