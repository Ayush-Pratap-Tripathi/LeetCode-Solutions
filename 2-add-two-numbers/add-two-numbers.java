class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode current1 = l1;
        ListNode current2 = l2;

        ListNode head = null;
        ListNode tail = null;

        int carry = 0;

        while (current1 != null || current2 != null || carry != 0) {

            int x = (current1 == null) ? 0 : current1.val;
            int y = (current2 == null) ? 0 : current2.val;

            int sum = x + y + carry;

            ListNode node = new ListNode(sum % 10);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

            carry = sum / 10;

            if (current1 != null)
                current1 = current1.next;

            if (current2 != null)
                current2 = current2.next;
        }

        return head;
    }
}