package cloud.lintcode.twoPointer;
//这是一个交互问题。
//
// 您有一个升序整数数组，其长度未知。您没有访问数组的权限，但是可以使用 ArrayReader 接口访问它。你可以调用 ArrayReader.get(i)
//: 
//
// 
// 
// 返回数组第iᵗʰ个索引(0-indexed)处的值(即secret[i])，或者 
// 
// 
// 如果 i 超出了数组的边界，则返回 2³¹ - 1 
// 
// 
//
// 你也会得到一个整数 target。 
//
// 如果存在secret[k] == target，请返回索引 k 的值；否则返回 -1 
//
// 你必须写一个时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入: secret = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 存在在 nums 中，下标为 4
// 
//
// 示例 2： 
//
// 
//输入: secret = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不在数组中所以返回 -1 
//
// 
//
// 提示： 
//
// 
// 1 <= secret.length <= 10⁴ 
// -10⁴ <= secret[i], target <= 10⁴ 
// secret 严格递增 
// 
// Related Topics 数组 二分查找 交互 👍 54 👎 0

public class num702SearchInASortedArrayOfUnknownSize {
    public static void main(String[] args) {
        Solution solution = new num702SearchInASortedArrayOfUnknownSize().new Solution();
    }

    class ArrayReader {
        int get(int index) {
            return 0;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     * public int get(int index) {}
     * }
     */

    class Solution {

        public int search(ArrayReader reader, int target) {
            int range = 1;
            // 倍增法
            while (reader.get(range - 1) < target) {
                range = range * 2;
            }
            int start = 0;
            int end = range - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (reader.get(mid) < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (reader.get(start) == target) {
                return start;
            }
            if (reader.get(end) == target) {
                return end;
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}