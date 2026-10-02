package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    //240. 搜索二维矩阵 II
    class Solution1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row=matrix.length;
            int column=matrix[0].length;
            for(int i=0;i<row;i++){
                if(target>matrix[i][column-1]){
                    continue;
                }
                if(target >= matrix[i][0] && target<=matrix[i][column-1]){
                    int k=0;
                    int v=column-1;
                    while(k<=v){
                        int m=(k+v)>>>1;
                        if(matrix[i][m]>target){
                            v=m-1;
                        }else if(matrix[i][m]<target){
                            k=k+1;
                        }else{
                            return true;
                        }
                    }
                }
                if(target<matrix[i][0]){
                    break;
                }
            }
            return false;
        }
    }


    //54. 螺旋矩阵
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if(matrix==null || matrix.length==0 || matrix[0].length==0) return new ArrayList<>();
            int top=0;
            int bottom=matrix.length-1;
            int left=0;
            int right=matrix[0].length-1;
            List<Integer> list=new ArrayList<>();
            while(top<=bottom && left<=right){
                for(int i=left;i<=right;i++){
                    list.add(matrix[top][i]);
                }
                top++;
                for(int i=top;i<=bottom;i++){
                    list.add(matrix[i][right]);
                }
                right--;
                if(top<=bottom){
                    for(int i=right;i>=left;i--){
                        list.add(matrix[bottom][i]);
                    }
                    bottom--;
                }
                if(left<=right){
                    for(int i=bottom;i>=top;i--){
                        list.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return list;
        }
    }


}
/*
git add .
git commit -m "skill"
git push
 */