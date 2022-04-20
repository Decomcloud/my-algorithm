package cloud.ry.day5;
//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
// Related Topics 数组 动态规划 👍 2297 👎 0

public class num121BestTimeToBuyAndSellStock_recursion {
	public static void main(String[] args) {
		Solution solution = new num121BestTimeToBuyAndSellStock_recursion().new Solution();
		int max = solution.maxProfit(new int[] {7, 6, 4, 3, 1});
		System.out.println(max);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
		return getMax(prices, 0, prices.length -1);
    }

	private int getMax(int[] prices, int left, int right) {
		int length = right - left + 1;
		if (length <= 3) {
			int max = 0;
			for (int i = left; i < right; i++) {
				for (int j = i + 1; j <= right; j ++) {
					max =  Math.max(max, prices[j] - prices[i]);
				}
			}
			return max;
		}
		int mid = (left + right)/2;
		int leftMax = getMax(prices,left, mid);
		int rightMax = getMax(prices, mid +1, right);
		int midMax = getMaxBetweenMid(prices, left, right, mid);
		return Math.max(leftMax, Math.max(rightMax, midMax));
	}

	private int getMaxBetweenMid(int[] prices, int left, int right, int mid) {
		int leftMin = Integer.MAX_VALUE;
		int rightMax = Integer.MIN_VALUE;
		for (int i = left; i < mid + 1; i ++) {
			leftMin = Math.min(leftMin, prices[i]);
		}
		for (int i = mid + 1; i <= right; i ++) {
			rightMax = Math.max(rightMax, prices[i]);
		}
		return rightMax - leftMin;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}