//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2996 👎 0


package leetcode.editor.cn;
//Java：搜索旋转排序数组
public class T33_SearchInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new T33_SearchInRotatedSortedArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        return towSearch(nums, 0, nums.length-1, target);
    }
    public int towSearch(int[] nums, int start, int end, int target){
        int mid = (start+end)/2;
        if(nums[start] ==target){
            return start;
        }
        if(nums[end]==target){
            return end;
        }
        if(nums[mid]==target){
            return mid;
        }
        if(mid==start||mid==end){
            return -1;
        }
        boolean t1=target<nums[mid]&&nums[mid]>nums[0]&&target>nums[start];
        boolean t2=target<nums[mid]&&nums[mid]>nums[0]&&target<nums[start];
        boolean t3=target<nums[mid]&&nums[mid]<nums[0];

        boolean t4 = target > nums[mid] && nums[mid] < nums[nums.length - 1] && target > nums[nums.length - 1]; //左
        boolean t5 = target > nums[mid] && nums[mid] < nums[nums.length - 1] && target < nums[nums.length - 1]; //右
        boolean t6 = target > nums[mid] && nums[mid] > nums[nums.length - 1];//右
        if (t1 || t3 || t4) { return towSearch(nums, start, mid, target); } else if (t2 || t5 || t6) { return towSearch(nums, mid, end, target); } return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
