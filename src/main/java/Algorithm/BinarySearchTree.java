package Algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinarySearchTree {
    BST root;

    static class BST {
        public int key;
        public Object value;
        public BST left;
        public BST right;

        public BST(int key) {
            this.key = key;
        }

        public BST(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BST(int key, Object value, BST left, BST right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public Object get(int key) {
        if (root == null) return null;
        BST pointer = root;
        while (key != pointer.key) {
            if (key < pointer.key) pointer = pointer.left;
            else if (key > pointer.key) pointer = pointer.right;
            if (pointer == null) return null;
        }
        return pointer.value;
    }

    public Object min() {
        if (root == null) return null;
        BST pointer = root;
        while (pointer.left != null) {
            pointer = pointer.left;
        }
        return pointer.value;
    }

    public Object max() {
        if (root == null) return null;
        BST pointer = root;
        while (pointer.right != null) {
            pointer = pointer.right;
        }
        return pointer.value;
    }

    public void put(int key, Object value) {
        if (root == null) root = new BST(key, value);
        BST pointer = root;
        while (pointer != null) {
            if (pointer.key > key && pointer.left != null) {
                pointer = pointer.left;
            } else if (pointer.key < key && pointer.right != null) {
                pointer = pointer.right;
            } else if (pointer.key > key && pointer.left == null) {
                pointer.left = new BST(key, value);
            } else if (pointer.key < key && pointer.right == null) {
                pointer.right = new BST(key, value);
            } else if (pointer.key == key) {
                pointer.value = value;
                return;//pointer did not move so if there is not return; it will be infinite
            }
        }
    }

    //inorder is low efficiency
    public Object successor(int key) {
        if (root == null) return null;
        BST pointer = root;
        Deque<BST> queue = new ArrayDeque<>();
        List<BST> list = new ArrayList<>();
        while (!queue.isEmpty() || pointer != null) {
            if (pointer != null) {
                queue.push(pointer);
                pointer = pointer.left;
            } else {
                BST bst = queue.pop();
                list.add(bst);
                pointer = bst.right;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).key == key) {
                return list.get(i + 1).value;
            }
        }
        return null;
    }

    public Object predecessor(int key) {
        if (root == null) return null;
        BST pointer = root;
        Deque<BST> queue = new ArrayDeque<>();
        List<BST> list = new ArrayList<>();
        while (!queue.isEmpty() || pointer != null) {
            if (pointer != null) {
                queue.push(pointer);
                pointer = pointer.left;
            } else {
                BST bst = queue.pop();
                list.add(bst);
                pointer = bst.right;
            }
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).key == key) {
                return list.get(i - 1).value;
            }
        }
        return null;
    }


    //so fucking complex 1.no left 2.no right -> shift method is important 3. no right and left 4. have right and left
    public Object delete(int key) {
        if (root == null) return null;
        BST pointer = root;
        BST father = null;
        while (pointer != null) {
            if (pointer.key > key) pointer = pointer.left;
            else if (pointer.key < key) {
                father = pointer;// before moving, record the father node
                pointer = pointer.right;
            } else break;
        }//find the target node
        if (pointer == null) return null;
        if (pointer.left == null/* && pointer.right != null*/) {//when 3: both of the two logic can work so there is a /**/
            shift(father,pointer,pointer.right);
        }else if (pointer.right == null /*&& pointer.left != null*/) {
            shift(father,pointer,pointer.left);
        }else {
            //1 找到后继节点
            BST b1=pointer.right;
            while (b1.left!=null){
                b1=b1.left;
            }
            // 2 处理后继节点的后面的节点
            // 3 后继节点取代被删除节点
        }
        return pointer.value;// return the value of removed node
    }

    private void shift(BST father, BST removed, BST son) {
        if (father == null) {//father is the null
            root=son;
        }else if(removed==father.left){// this can be understood
            son=father.left;
        }else if(removed==father.right){// this can be understood
            son=father.right;
        }
    }


}
