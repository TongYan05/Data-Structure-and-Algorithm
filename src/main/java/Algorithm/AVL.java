package Algorithm;

import javax.swing.text.StyledEditorKit;

public class AVL {//自平衡的二叉搜索树

    static class AVLnode {
        int key;
        Object value;
        AVLnode left;
        AVLnode right;
        int height = 1;

        public AVLnode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLnode(int key) {
            this.key = key;
        }

        public AVLnode(int key, Object value, AVLnode left, AVLnode right, int height) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    private int height(AVLnode node) {
        if (node == null) return 0;//如果传入的是null，那么高度就是0
        return node.height;
    }

    //update the node's height 子树中的最大高度加一就是母节点的高度
    private void heightUpdate(AVLnode node) {
        int leftheight = height(node.left);//左孩子的高度
        int rightheight = height(node.right);//右孩子的高度
        node.height = Math.max(leftheight, rightheight) + 1;//母节点=子节点高度最大值+1
    }

    //balance factor -> 左子树高度-右子树高度     0 1 -1 balanced   <-1 >1 unbalanced
    private int ifBalanced(AVLnode node) {
        int leftheight = height(node.left);
        int rightheight = height(node.right);
        return leftheight - rightheight;
    }


}
