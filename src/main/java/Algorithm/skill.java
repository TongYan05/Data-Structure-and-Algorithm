package Algorithm;

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



}
/*
git add .
git commit -m "skill"
git push
 */