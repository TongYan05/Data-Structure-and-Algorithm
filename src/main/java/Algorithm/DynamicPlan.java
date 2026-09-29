package Algorithm;

import java.util.Arrays;

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


    //322. 零钱兑换
    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            int[] eachAmount=new int[amount+1];
            Arrays.fill(eachAmount,amount+1);
            eachAmount[0]=0;
            for(int i=1;i<amount+1;i++){
                for(int x : coins){
                    if(x <= i){
                        eachAmount[i]=Math.min(eachAmount[i],eachAmount[i-x]+1);
                    }
                }
            }
            return eachAmount[amount]>amount ? -1 : eachAmount[amount];
        }
    }











}
/*
git add .
git commit -m "dynamic plan"
git push
 */