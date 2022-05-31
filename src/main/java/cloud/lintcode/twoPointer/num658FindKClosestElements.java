package cloud.lintcode.twoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴ 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 325 👎 0

public class num658FindKClosestElements {
    public static void main(String[] args) {
        Solution solution = new num658FindKClosestElements().new Solution();
        solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int index = findFirstBiggerIndex(arr, x);
            System.out.println(index);
            if (index == -1) {
                return null;
            }
            List<Integer> res = new ArrayList<>();
            int left = index - 1;
            int right = index;
            for (int i = 0; i < k; i++) {
                if (isLeftCloser(arr, left, right, x)) {
                    res.add(arr[left]);
                    left--;
                } else {
                    res.add(arr[right]);
                    right++;
                }
            }
            Collections.sort(res);
            return res;
        }

        private boolean isLeftCloser(int[] arr, int left, int right, int target) {
            if (left < 0) {
                return false;
            }
            if (right > arr.length - 1) {
                return true;
            }

            return target - arr[left] <= arr[right] - target;
        }

        private int findFirstBiggerIndex(int[] arr, int target) {
            int start = 0;
            int end = arr.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (arr[start] >= target) {
                return start;
            }
            if (arr[end] >= target) {
                return end;
            }
            // 当最后找不到时, 说明都比该数小, 直接返回最后一位
            return arr.length - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}