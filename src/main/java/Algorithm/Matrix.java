package Algorithm;

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



}
/*
git add .
git commit -m "skill"
git push
 */