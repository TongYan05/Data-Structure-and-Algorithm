package Algorithm;

import java.util.Arrays;

public class skill {


    //136. 只出现一次的数字
    class Solution1 {
        public int singleNumber(int[] nums) {
            int result=0;
            for(int x :nums){
                result=result ^ x;
            }
            return result;
        }
    }


    //287. 寻找重复数
    class Solution2 {
        public int findDuplicate(int[] nums) {
            int slow=0;
            int fast=0;
            do{
                slow=nums[slow];
                fast=nums[nums[fast]];
            }while(slow!=fast);//slow == fast
            slow=0;
            while(slow!=fast){
                slow=nums[slow];
                fast=nums[fast];
            }
            return slow;
        }
    }



    //169. 多数元素
    class Solution3 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }


    //75. 颜色分类
    class Solution {
        public void sortColors(int[] nums) {
            int i=0;
            int j=0;
            int k=0;
            for(int x : nums) {
                if(x==0) i++;
                else if(x==1) j++;
                else k++;
            }
            for(int m=0;m<nums.length;m++){
                if(m >=0 && m<i) nums[m]=0;
                else if(m>=i && m<i+j) nums[m]=1;
                else nums[m]=2;
            }
        }
    }

}
/*
git add .
git commit -m "skill"
git push
 */