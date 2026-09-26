package Algorithm;

import java.util.*;

public class Array {
    static void main(String[] args) {
        //56. 合并区间
        class Solution1 {
            public int[][] merge(int[][] intervals) {
                if(intervals.length==0) return new int[0][0];
                Arrays.sort(intervals,(k, v)->k[0]-v[0]);
                List<int[]> list=new ArrayList<>();
                for(int[] x : intervals){
                    if(list.isEmpty() || list.get(list.size()-1)[1]<x[0]){
                        list.add(x);
                    }
                    if(list.get(list.size()-1)[1]>=x[0]){
                        list.get(list.size()-1)[1]=Math.max(x[1],list.get(list.size()-1)[1]);
                    }
                }
                return list.toArray(new int[list.size()][]);
            }
        }



        //238. 除了自身以外数组的乘积
        class Solution2 {
            public int[] productExceptSelf(int[] nums) {
                if(nums.length==0) return new int[0];
                int[] result=new int[nums.length];
                result[0]=1;
                for(int i=1;i<nums.length;i++){
                    result[i]=result[i-1]*nums[i-1];
                }
                int right=1;
                for(int i=nums.length-1;i>=0;i--){
                    result[i]=result[i]*right;
                    right=right*nums[i];
                }
                return result;
            }
        }


        // 104. 二叉树的最大深度
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
            public int maxDepth(TreeNode root) {
                if(root==null) return 0;
                return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
            }
        }
/*
        if(root==null) return 0;
        Deque<TreeNode> d=new ArrayDeque<>();
        d.offer(root);
        int deepth=0;
        while(!d.isEmpty()){
            int size=d.size();
            for(int i=0;i<size;i++){
                TreeNode t=d.poll();
                if(t.left!=null) d.offer(t.left);
                if(t.right!=null) d.offer(t.right);
            }
            deepth++;
        }
        return deepth;
        */






        //543. 二叉树的直径
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
        class Solution3 {
            private int d;
            public int diameterOfBinaryTree(TreeNode root) {
                diameter(root);
                return d;
            }
            private int diameter(TreeNode root){
                if(root==null) return 0;
                int leftdepth=diameter(root.left);
                int rightdepth=diameter(root.right);
                d=Math.max(d,leftdepth+rightdepth);
                return Math.max(leftdepth,rightdepth)+1;
            }
        }


        //41. 缺失的第一个正数
        class Solution4 {
            public int firstMissingPositive(int[] nums) {
                Set<Integer> set=new TreeSet<>();
                for(int i=0;i<nums.length;i++){
                    if(nums[i]<=0) continue;
                    set.add(nums[i]);
                }
                int acc=1;
                for(int x : set){
                    if(x==acc){
                        acc++;
                    }
                    else break;
                }
                return acc;
            }
        }









    }
}

/*
git add .
git commit -m "Array"
git push

 */