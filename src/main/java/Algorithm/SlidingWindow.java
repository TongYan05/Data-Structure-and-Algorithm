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


    //      Definition for singly-linked list. 142. 环形链表 II
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

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


    }
}
/*
git add .
git commit -m "algorithm"
git push
 */