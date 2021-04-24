package com.leetcode.qa_148;


import com.leetcode.qa_147.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：(快速排序和堆排序)
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ebao
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (null == head) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode head1 = sortList(head, slow);
        ListNode head2 = sortList(slow, tail);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode listNode = new ListNode();
        ListNode tmp = listNode;
        while (null != head1 && null != head2) {
            if (head1.val <= head2.val) {
                tmp.next = head1;
                head1 = head1.next;
            } else {
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        if (null != head1) {
            tmp.next = head1;
        } else if (null != head2) {
            tmp.next = head2;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        ListNode node5 = new ListNode(2);
//        ListNode node4 = new ListNode(3, null);
        ListNode node3 = new ListNode(1, null);
        ListNode node2 = new ListNode(4, node3);
        ListNode head = new ListNode(3, node2);
        ListNode result = solution.sortList(head);
        while(null != result) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
