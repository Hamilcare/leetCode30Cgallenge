package leetcode30Challenge.week2;


public class MiddleLinkedList {

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ln1.next = ln2;
		ListNode ln3 = new ListNode(3);
		ln2.next = ln3;
		ListNode ln4 = new ListNode(4);
		ln3.next=ln4;
		ListNode ln5 = new ListNode(5);
		ln4.next=ln5;
//		ListNode ln6 = new ListNode(6);
//		ln5.next = ln6;
		Solution s = new Solution();
		ListNode ans =  s.middleNode(ln1);
		System.out.println(ans.val);
	}

}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode middleNode(ListNode head) {
		int cpt = 1;
		ListNode next = head.next;
		while (next != null) {
			cpt++;
			next=next.next;
		}
		int middle = cpt / 2;
		while (middle >= 1) {
			head = head.next;
			middle--;
		}
		return head;
	}
}