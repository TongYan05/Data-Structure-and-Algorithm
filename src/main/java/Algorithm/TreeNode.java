package Algorithm;

import java.util.*;
import java.util.Queue;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    private Integer val;

    TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode left, int value, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );

        // 创建一个空队列，元素类型为 TreeNode，用来暂存"已发现但还没被访问"的节点
        LinkedListQueue<TreeNode> llq = new LinkedListQueue<>();
        // 把根节点 root 入队，它是层序遍历唯一的起点
        llq.offer(root);// root is just an element, it is TreeNode type
        // 只要队列里还有没访问过的节点，循环就继续；队列空即整棵树访问完毕
        int nextlevel = 0;
        int refresh = 1;
        while (!llq.isEmpty()) {
            for (int i = 0; i < refresh; i++) {
                // 从队头取出并移除一个节点，记为 head，它就是本轮要访问的节点
                TreeNode head = llq.poll();//in llq, have root the single element. llq.poll return root's value
                // 访问 head：打印它的值（print 会经 toString 得到 value，后面补一个空格）
                System.out.print(head + " ");
                // 判断 head 有没有左孩子
                if (head.left != null) {// if has left
                    // 有就把左孩子入队，等轮到它时再被访问
                    llq.offer(head.left);// add left TreeNode into the linkedlist
                    nextlevel++;
                }
                // 判断 head 有没有右孩子
                if (head.right != null) {//if has right
                    // 有就把右孩子入队，顺序排在刚才的左孩子后面
                    llq.offer(head.right);
                    nextlevel++;
                }
                // 本轮结束：head 的孩子已按"先左后右"追加到队尾；
                // 队列先进先出，保证同一层节点一定比下一层节点先出队，这就是层序遍历
            }
            System.out.println();
            refresh = nextlevel;
            nextlevel = 0;   // 关键: 每层结束把计数器清零, 否则它跨层累加, 下一轮会多 poll 出 null
            // 循环结束时每个节点恰好被入队、出队、打印各一次，输出顺序即层序遍历结果
        }



        //199. 二叉树的右视图
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode() {}
         *     TreeNode(int val) { this.val = val; }
         *     TreeNode(int val, TreeNode left, TreeNode right) {
         *         this.val = val;
         *         this.left = left;
         *         this.right = right;
         *     }
         * }
         */
        class Solution {
            public List<Integer> rightSideView(TreeNode root) {
                if(root==null) return new ArrayList<>();
                List<Integer> list=new ArrayList<>();
                Queue<TreeNode> q=new LinkedList<>();
                q.offer(root);
                while(!q.isEmpty()){
                    int size=q.size();
                    TreeNode t=null;
                    for(int i=0;i<size;i++){
                        t=q.poll();
                        if(i==size-1){
                            list.add(t.val);
                        }
                        if(t.left!=null) q.offer(t.left);
                        if(t.right!=null) q.offer(t.right);
                    }
                }
                return list;
            }
        }



        //hard 114. 二叉树展开为链表
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode() {}
         *     TreeNode(int val) { this.val = val; }
         *     TreeNode(int val, TreeNode left, TreeNode right) {
         *         this.val = val;
         *         this.left = left;
         *         this.right = right;
         *     }
         * }
         */
        class Solution7 {
            public void flatten(TreeNode root) {
                if(root==null) return;
                TreeNode pointer=root;
                Deque<TreeNode> d=new ArrayDeque<>();
                TreeNode result=null;
                d.push(root);
                while(!d.isEmpty()){
                    TreeNode node=d.pop();
                    if(result!=null){
                        result.right=node;
                        result.left=null;
                    }
                    if(node.right!=null) d.push(node.right);
                    if(node.left!=null) d.push(node.left);
                    result=node;
                }
            }
        }





        //236. 二叉树的最近公共祖先
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode(int x) { val = x; }
         * }
         */
        class Solution6 {
            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                if(root == null || root == p || root == q) return root;
                TreeNode left=lowestCommonAncestor(root.left,p,q);
                TreeNode right=lowestCommonAncestor(root.right,p,q);
                if(right!=null && left!=null){
                    return root;
                }else if(right==null && left!=null){
                    return left;
                }else{
                    return right;
                }

            }
        }





    }
}
/*
git add .
git commit -m "treenode"
git push

 */