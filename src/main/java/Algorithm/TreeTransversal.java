package Algorithm;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.awt.*;
import java.util.*;
import java.util.Queue;

public class TreeTransversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(null, 4, null), 2, null),
                1,
                new TreeNode(new TreeNode(null, 5, null), 3, new TreeNode(null, 6, null))
        );
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);

        System.out.println();


//          1
//        4  5
//        Deque<TreeNode> deque=new ArrayDeque<>();
//        TreeNode pointer=root;//走一圈，先向左
//        while (pointer!=null || !deque.isEmpty()){//整个就是preorder 中左右
//            if(pointer!=null) {
//                colorPrintln("forward: "+pointer.value + " ",32);//注释这行就是inorder，左中右
//                deque.push(pointer);
//                pointer = pointer.left;
//            }else {
//                TreeNode peek=deque.peek();
//                Algorithm.TreeNode t =deque.poll();
//                colorPrintln("back: "+t.value+" ",33);
//                pointer=t.right;//make when deque is empty, pointer is not null, so the while loop can work continually    FANTASTIC!!!!!!
//            }
//        }

//        //postorder 左右中
//        Deque<TreeNode> deque=new ArrayDeque<>();
//        TreeNode pointer=root;//走一圈，先向左
//        TreeNode t=null;
//        while (pointer!=null || !deque.isEmpty()){
//            if(pointer!=null) {
//                deque.push(pointer);
//                pointer = pointer.left;
//            }else {
//                TreeNode peek=deque.peek();
//                if(peek.right==null || peek.right==t){
//                    t =deque.poll();
//                    colorPrintln("back: "+t.value+" ",33);
//                }else{
//                    pointer=peek.right;
//                }
//            }
//        }


    }

    // min depth
    public int minDepth(TreeNode root) {
//        if(root==null) return 0;
//        if(root.left==null) return 1 + minDepth(root.right);
//        if(root.right==null) return 1 + minDepth(root.left);
//        return Math.min(1+minDepth(root.left),1+minDepth(root.right));

        //层序遍历
        if (root == null) return 0;
        Deque<TreeNode> d = new ArrayDeque<>();
        d.offer(root);
        int deepth = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            deepth++;
            for (int i = 0; i < size; i++) {
                TreeNode t = d.poll();
                if (t.left == null && t.right == null) return deepth;
                if (t.left != null) d.offer(t.left);
                if (t.right != null) d.offer(t.right);
            }
        }
        return deepth;
    }

    //invert the tree
    public static TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = r;
        root.right = l;
        invert(root.left);
        invert(root.right);
        return root;
    }


    // max deepth  层序遍历
    public int maxDepth(TreeNode root) { // hard!!!
        // if(root==null) return 0;
        // return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
        if (root == null) return 0;
        Deque<TreeNode> d = new ArrayDeque<>();
        d.offer(root);
        int deepth = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = d.poll();
                if (t.left != null) d.offer(t.left);
                if (t.right != null) d.offer(t.right);
            }
            deepth++;
        }
        return deepth;
    }


    // judge if the tree is Symmetric??
    public static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (right == null || left == null) return false;
        if (left.value != right.value) return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }


    private static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }

    public static void preorder(TreeNode root) {//recursion iterate the 二叉树
        if (root == null) return;
        System.out.print(root.value + "\t");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.value + "\t");
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.right);
        System.out.print(root.value + "\t");
        postorder(root.left);
    }


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

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ListNode pointer = head;
            ListNode result = null;
            while (pointer != null) {
                result = new ListNode(pointer.val, result);
                pointer = pointer.next;
            }
            return result;
        }

    }


}
