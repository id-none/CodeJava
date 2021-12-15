package company;

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
}

public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int num = 0;
        ListNode first = head;
        while (first != null) {
            ++num;
            first = first.next;
        }
        ListNode[] ans = new ListNode[k];
        if (num == 0) return ans;
        if (num / k == 0) {
            int n = 0;
            while (num != 0) {
                first = head;
                --num;
                head = head.next;
                first.next = null;
                ans[n++] = first;
            }
        }
        if (num % k == 0) {
            int i = 0;
            int j = num / k;
            while (num != 0) {
                int n = j;
                first = head;
                --num;
                while (n != 0) {
                    head = head.next;
                    n--;
                }
                first.next = null;
                ans[i++] = first;
            }
        } else {
            int h = num % k;
            int i = 0;
            int j = num / k;
            while (num != 0){
                int n = j;
                first = head;
                --num;
                while (n != 0){
                    head = head.next;
                    n--;
                    if(h == 1){
                        n++;
                        head = head.next;
                        h = 0;
                    }
                    if(h == j - 1){
                        n--;
                        h = 0;
                    }
                    first.next = null;
                    ans[i++] = first;
                }
            }
        }
        return ans;
    }
}
