class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        return dummy.next;
    }
}