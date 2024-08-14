//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2863 👎 0


package src.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Java：合并 K 个升序链表
class T23_MergeKSortedLists{
    public static void main(String[] args) {
        //Solution solution = new T23_MergeKSortedLists().new Solution();
        // TO TEST
        // 创建一个Scanner对象用于从键盘获取输入
        Scanner scanner = new Scanner(System.in);

        // 创建一个外层列表用于存储内层列表
        List<List<Integer>> lists = new ArrayList<>();

        System.out.println("Enter the number of sublists: ");
        int numOfSublists = scanner.nextInt();  // 输入子列表的数量

        for (int i = 0; i < numOfSublists; i++) {
            // 创建一个内层列表用于存储每个子列表的元素
            List<Integer> sublist = new ArrayList<>();
            System.out.println("Enter the number of elements in sublist " + (i + 1) + ": ");
            int numOfElements = scanner.nextInt();  // 输入当前子列表中的元素数量

            System.out.println("Enter the elements of sublist " + (i + 1) + ": ");
            for (int j = 0; j < numOfElements; j++) {
                int element = scanner.nextInt();  // 逐个输入子列表的元素
                sublist.add(element);  // 将元素添加到子列表中
            }
            lists.add(sublist);  // 将子列表添加到外层列表中
        }

        // 打印嵌套列表
        System.out.println("The nested list is: " + lists);

        // 关闭Scanner
        scanner.close();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> firArr = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            for(int i = 0; i < lists.length; i++){
                if(lists[i] != null) firArr.offer(lists[i]);
            }
            ListNode head = new ListNode();
            ListNode r = head;
            while(!firArr.isEmpty()){
                ListNode temp = firArr.poll();
                if(temp.next != null) firArr.offer(temp.next);
                r.next = temp;
                r = r.next;
                r.next = null;
            }
            return head.next;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
