//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2771 👎 0


package leetcode.editor.cn;
//Java：在排序数组中查找元素的第一个和最后一个位置
public class T34_FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new T34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int leftLimit = Integer.MAX_VALUE;;
            int rightLimit = Integer.MIN_VALUE;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    leftLimit = Math.min(leftLimit, mid);
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            left = 0;
            right = nums.length - 1;
            while(left <= right) {
                int mid = left + (right - left)/2;
                if (nums[mid] == target) {
                    rightLimit = Math.max(mid, rightLimit);
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int[] ret = new int[2];
            ret[0] = -1;
            ret[1] = -1;
            if (leftLimit <= rightLimit) {
                ret[0] = leftLimit;
                ret[1] = rightLimit;
            }
            return ret;
        }

        private int binarySearch(int[] nums, int l, int r, int target) {
            while(l <= r) {
                int mid = l + (r - l)/2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
