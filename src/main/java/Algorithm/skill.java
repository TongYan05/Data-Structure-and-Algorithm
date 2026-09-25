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
    class Solution4 {
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

    //73. 矩阵置零
    class Solution5 {
        public void setZeroes(int[][] matrix) {
            boolean columnHasZero=false;
            boolean rowHasZero=false;
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][0]==0) columnHasZero=true;
            }
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[0][i]==0) rowHasZero=true;
            }
            for(int i=1;i<matrix.length;i++){
                for(int j=1;j<matrix[0].length;j++){
                    if(matrix[i][j]==0){
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                }
            }
            for(int i=1;i<matrix.length;i++){
                for(int j=1;j<matrix[0].length;j++){
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
            if(columnHasZero){
                for(int i=0;i<matrix.length;i++){
                    matrix[i][0]=0;
                }
            }
            if(rowHasZero){
                for(int i=0;i<matrix[0].length;i++){
                    matrix[0][i]=0;
                }
            }
        }
    }



}
/*
git add .
git commit -m "skill"
git push
 */