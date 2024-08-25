//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2552 👎 0


package leetcode.editor.cn;
//Java：最长有效括号
public class T32_LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new T32_LongestValidParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int maxAns=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //哨兵
        for( int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxAns=Math.max(maxAns, i-stack.peek());  //stack.peek()返回栈顶元素
                }
            }
        }
        return maxAns;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
