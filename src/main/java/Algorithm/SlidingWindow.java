package Algorithm;

import jdk.dynalink.linker.GuardedInvocationTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindow {

    //leetcode 438. 找到字符串中所有字母异位词
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s.length() < p.length()) return res;

            int[] pCount = new int[26]; // p 的字符频率
            int[] sCount = new int[26]; // 窗口内的字符频率

            // 初始化：统计 p 和 s 前 p.length() 个字符的频率
            for (int i = 0; i < p.length(); i++) {
                pCount[p.charAt(i) - 'a']++;//出现频率，就看相同的数字有几个
                sCount[s.charAt(i) - 'a']++;
            }

            // 检查第一个窗口
            if (Arrays.equals(pCount, sCount)) {//两个数组完全相同才返回true
                res.add(0);//如果完全相同，先记录最开始的0索引
            }

            // 滑动窗口：每次右移一位
            for (int i = p.length(); i < s.length(); i++) {
                sCount[s.charAt(i) - 'a']++;           // 新字符入窗口
                sCount[s.charAt(i - p.length()) - 'a']--; // 老字符出窗口
                if (Arrays.equals(pCount, sCount)) {
                    res.add(i - p.length() + 1);
                }
            }

            return res;
        }
    }


//    //      Definition for singly-linked list. 142. 环形链表 II

    public class Solution2 {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode i = head;
            ListNode j = head;
            do {
                j = j.next;
                j = j.next;
                if (j == null || j.next == null) return null;
                i = i.next;
            } while (i != j);
            i = head;
            while (i != j) {
                j = j.next;
                i = i.next;
            }
            return i;
        }
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
// 160. 相交链表
    public class Solution3 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode pa = headA;
            ListNode pb = headB;
            while (pa != pb) {
                if (pa != null) pa = pa.next;
                else pa = headB;
                if (pb != null) pb = pb.next;
                else pb = headA;
            }
            return pa;
        }
    }

    // 2. 两数相加

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution5 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode i = l1;
            ListNode j = l2;
            ListNode result = null;
            int add = 0;

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (i != null && j != null) {
                int sum = i.val + j.val + add;
                add = sum / 10;
                tail.next = new ListNode(sum % 10);
                tail = tail.next;

                i = i.next;
                j = j.next;
            }

            ListNode rest = (i != null) ? i : j;
            while (rest != null) {
                int sum = rest.val + add;
                add = sum / 10;
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
                rest = rest.next;
            }
            if (add > 0) {
                tail.next = new ListNode(add);
            }
            return dummy.next;
        }
    }


    //     Definition for singly-linked list.
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

    //24. 两两交换链表中的节点
    class Solution7 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;//排除少于2个节点的情况
            ListNode pre = new ListNode(-1, head);
            ListNode pointer = pre;
            while (pointer.next != null && pointer.next.next != null) {
                ListNode i = pointer.next;
                ListNode j = i.next;
                ListNode k = j.next;
                i.next = k;
                j.next = i;
                pointer.next = j;
                pointer = i;
                //相当于有四个节点
            }
            return pre.next;
        }
    }



    // 33. 搜索旋转排序数组
    class Solution8 {
        public int search(int[] nums, int target) {
            if(nums.length==0) return -1;
            int i=0;
            int j=nums.length-1;
            while(i<=j){
                int m=(i+j)>>>1;
                if (nums[m]==target){
                    return m;
                }
                else if(nums[m]<nums[i]){
                    //m左边是无序的，右边是有序的
                    if(target>nums[m] && target<=nums[j]) i=m+1;
                    else j=m-1;
                }else if(nums[m]>=nums[i]){
                    //m左边是有序的
                    if(target>=nums[i] && target<nums[m]) j=m-1;
                    else i=m+1;
                }
            }
            return -1;
        }
    }

}
/*
git add .
git commit -m "algorithm"
git push
 */