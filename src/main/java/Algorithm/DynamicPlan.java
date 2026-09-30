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


    //300. 最长递增子序列
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums==null || nums.length==0) return 0;
            int[] result=new int[nums.length];
            result[0]=1;
            int MaxLength=1;
            for(int i=0;i<nums.length;i++){
                result[i]=1;
                for(int j=0;j<i;j++){
                    if(nums[i]>nums[j]){
                        int max=Math.max(result[j]+1,result[i]);
                        result[i]=max;
                    }
                    MaxLength=Math.max(MaxLength,result[i]);
                }
            }
            return MaxLength;
        }
    }


    //152. 乘积最大子数组
    class Solution3 {
        public int maxProduct(int[] nums) {
            if(nums.length==1) return nums[0];
            int max=nums[0];
            int[] arrMax=new int[nums.length];
            int[] arrMin=new int[nums.length];
            arrMax[0]=nums[0];
            arrMin[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                int preMax=arrMax[i-1];
                int preMin=arrMin[i-1];
                arrMax[i]=Math.max(Math.max(nums[i],nums[i]*preMax),nums[i]*preMin);
                arrMin[i]=Math.min(Math.min(nums[i],nums[i]*preMax),nums[i]*preMin);
                max=Math.max(max,arrMax[i]);
            }
            return max;
        }
    }

    //279. 完全平方数 和零钱兑换一样的类型，得花时间搞懂
    class Solution4 {
        public int numSquares(int n) {
            int[] nums=new int[n+1];
            Arrays.fill(nums,n+1);
            nums[0]=0;
            int min=0;
            for(int i=0;i*i<n+1;i++){
                for(int j=i*i;j<n+1;j++){
                    nums[j]=Math.min(nums[j-i*i]+1,nums[j]);
                }
            }
            return nums[n];
        }
    }






}
/*
git add .
git commit -m "dynamic plan"
git push
 */