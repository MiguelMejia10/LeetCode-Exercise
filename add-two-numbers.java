class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    // Helper method to convert an integer into a linked list
    public ListNode intToList(int num) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (num > 0) {
            int digit = num % 10;
            current.next = new ListNode(digit);
            current = current.next;
            num /= 10;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = solution.intToList(342); // Convert integer to linked list
        ListNode l2 = solution.intToList(465);

        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }
}
