package Algorithm;

public class DynamicPlan {

    //198. 打家劫舍
    class Solution1 {
        public int rob(int[] nums) {
            if(nums==null || nums.length==0) return 0;
            if(nums.length==1) return nums[0];
            int p1=0;
            int p2=0;
            for(int x:nums){
                int max=Math.max(p1,p2+x);
                p2=p1;
                p1=max;
            }
            return p1;
        }
    }












}
