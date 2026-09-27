package Algorithm;

public class Listnode {


    //      Definition for singly-linked list.
    public class ListNode {
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

    //206. 反转链表
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            // if(head==null) return null;
            // ListNode pointer=head;
            // ListNode result=null;
            // while(pointer!=null){
            //     result=new ListNode(pointer.val,result);
            //     pointer=pointer.next;
            // }
            // return result;


            //头插法
            if (head == null) return null;
            ListNode front = head;
            ListNode current = head.next;
            front.next = null;
            while (current != null) {
                ListNode temp = current.next;
                current.next = front;
                front = current;
                current = temp;
            }
            return front;

        }

    }


    //25. K 个一组翻转链表
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
    class Solution2 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head==null) return null;
            ListNode dummy=new ListNode(-1,head);
            ListNode pre=dummy;
            ListNode front=head;
            ListNode aft=head;
            while(aft!=null){
                for(int i=0;i<k-1 && aft!=null;i++){
                    aft=aft.next;
                }
                if(aft==null) break;
                ListNode nextHead=aft.next;
                aft.next=null;
                pre.next=reverseListNode(front);
                front.next=nextHead;
                pre=front;
                aft=nextHead;
                front=nextHead;
            }
            return dummy.next;
        }
        private ListNode reverseListNode(ListNode head){
            if(head==null) return null;
            ListNode front=head;
            ListNode current=head.next;
            front.next=null;
            while(current!=null){
                ListNode temp=current.next;
                current.next=front;
                front=current;
                current=temp;
            }
            return front;
        }
    }








}
/*
git add .
git commit -m "hard"
git push
 */