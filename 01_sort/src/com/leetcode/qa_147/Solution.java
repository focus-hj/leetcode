package com.leetcode.qa_147;

/**
 * 对链表进行插入排序。
 *  插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 *  每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  插入排序算法：
 *  插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *  每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 *  重复直到所有输入数据插入完为止。
 *   
 *  示例 1：
 *  输入: 4->2->1->3
 *  输出: 1->2->3->4
 *
 *  示例 2：
 *  输入: -1->5->3->4->0
 *  输出: -1->0->3->4->5
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/insertion-sort-list
 *  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author huangjian
 */

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode headNode = new ListNode();
        headNode.next = head;
        ListNode curNode = headNode;
        while (null != curNode.next) {
            ListNode insertNode = headNode;
            while (insertNode.next.val < curNode.next.val) {
                insertNode = insertNode.next;
            }
            if (insertNode == curNode) {
                curNode = curNode.next;
            } else {
                ListNode tmpNode = curNode.next;
                curNode.next = tmpNode.next;
                tmpNode.next = insertNode.next;
                insertNode.next = tmpNode;
            }
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node5 = new ListNode(2);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(4, node2);
        ListNode result = solution.insertionSortList(head);
        while(null != result) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
