package Algorithm;

import java.util.ArrayDeque;
import java.util.Currency;
import java.util.Deque;

public class TreeTransversal {
    static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(null,4,null),2,null),
                1,
                new TreeNode(new TreeNode(null,5,null),3,new TreeNode(null,6,null))
        );
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);

        System.out.println();

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

        //postorder 左右中
        Deque<TreeNode> deque=new ArrayDeque<>();
        TreeNode pointer=root;//走一圈，先向左
        TreeNode t=null;
        while (pointer!=null || !deque.isEmpty()){
            if(pointer!=null) {
                deque.push(pointer);
                pointer = pointer.left;
            }else {
                TreeNode peek=deque.peek();
                if(peek.right==null || peek.right==t){
                    t =deque.poll();
                    colorPrintln("back: "+t.value+" ",33);
                }else{
                    pointer=peek.right;
                }
            }
        }


    }
    private static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
    public static void preorder(TreeNode root){//recursion iterate the 二叉树
        if(root==null) return;
        System.out.print(root.value+ "\t");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.value+"\t");
        inorder(root.right);
    }
    public static void postorder(TreeNode root){
        if(root==null) return;
        postorder(root.right);
        System.out.print(root.value+"\t");
        postorder(root.left);
    }
}
