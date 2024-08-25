//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。 
//
// 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。 
//
// 返回被除数 dividend 除以除数 divisor 得到的 商 。 
//
// 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2³¹, 231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 2
//31 − 1 ；如果商 严格小于 -2³¹ ，则返回 -2³¹ 。 
//
// 
//
// 示例 1: 
//
// 
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = 3.33333.. ，向零截断后得到 3 。 
//
// 示例 2: 
//
// 
//输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= dividend, divisor <= 2³¹ - 1 
// divisor != 0 
// 
//
// Related Topics 位运算 数学 👍 1236 👎 0


package leetcode.editor.cn;
//Java：两数相除
public class T29_DivideTwoIntegers{
    public static void main(String[] args) {
        Solution solution = new T29_DivideTwoIntegers().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            boolean sign = (dividend > 0) ^ (divisor > 0);
            int result = 0;
            if(dividend>0) {
                dividend = -dividend;
            }
            if(divisor>0) divisor = -divisor;
            while(dividend <= divisor) {
                int temp_result = -1;
                int temp_divisor = divisor;
                while(dividend <= (temp_divisor << 1)) {
                    if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                    temp_result = temp_result << 1;
                    temp_divisor = temp_divisor << 1;
                }
                dividend = dividend - temp_divisor;
                result += temp_result;
            }
            if(!sign) {
                if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
                result = - result;
            }
            return result;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
