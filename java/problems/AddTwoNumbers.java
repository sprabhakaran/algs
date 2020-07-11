package problems;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1size = nodeSize(l1);
        int l2size = nodeSize(l2);
        if(l1size < l2size){
            ListNode tmpNode = l1;
            l1 = l2;
            l2 = tmpNode;
        }

        int leadNum = 0;
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode firstNode = null;
        ListNode lastNode = null;
        do {

            int n1Val = n1 == null ? 0 : n1.val;
            int n2Val = n2 == null ? 0 : n2.val;

            int res = n1Val + n2Val + leadNum;
            leadNum = 0;

            leadNum = res / 10;
            System.out.println("result " + res + "  lead number :: " + leadNum);
            res = res >= 10 ? res % 10 : res;

            if (firstNode == null) {
                firstNode = new ListNode(res);
                lastNode = firstNode;
            } else {
                lastNode.next = new ListNode(res);
                lastNode = lastNode.next;
            }

            if (n1 != null) {
                n1 = n1.next;
            }

            if (n2 != null) {
                n2 = n2.next;
            }
            if (n1 == null) {
                if (leadNum != 0) {
                    lastNode.next = new ListNode(leadNum);
                }
                break;
            }

        } while (true);

        return firstNode;
    }

    private static int nodeSize(ListNode n) {
        int i = 0;
        do{
            i++;
            n = n.next;
        }while (n != null);
        return i;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(8));
        ListNode l2 = new ListNode(0);
        ListNode res = addTwoNumbers(l2, l1);

        System.out.println(res);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        String s = "";
        if (this.next != null) {
            s = this.next.toString();
        }
        return this.val + " " + s;

    }
}