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





}
/*
git add .
git commit -m "skill"
git push
 */