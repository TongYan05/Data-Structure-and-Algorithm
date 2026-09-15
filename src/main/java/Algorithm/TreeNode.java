package Algorithm;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

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
        return String.valueOf(value);
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

        LinkedListQueue<TreeNode> llq = new LinkedListQueue<>();
        llq.offer(root);// root is just an element, it is TreeNode type
        while (!llq.isEmpty()){
            TreeNode head=llq.poll();//in llq, have root the single element. llq.poll return root's value
            System.out.println(head);
            if(head.left!=null){// if has left
                llq.offer(head.left);// add left TreeNode into the linkedlist
            }
            if(head.right!=null){//if has right
                llq.offer(head.right);
            }
        }
    }


}
