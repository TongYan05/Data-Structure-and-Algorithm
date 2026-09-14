package Algorithm;

import javax.annotation.processing.RoundEnvironment;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class recursion {

    public recursion() {

    }


    public int factorial(int value) throws IllegalAccessException {
        if (value <= 1 && value >= 0) return 1;//0!=1
        else if (value < 0) {
            throw new IllegalAccessException(String.format("it cannot be negative number!!"));
        } else {
            return value * factorial(value - 1);
        }
    }

    public String reverselyPrintString(String string) {
        if (string == null || string.length() == 1) {
            return string;
        }
        int n = string.length() - 1;
        char lastletter = string.charAt(n);
        return lastletter + reverselyPrintString(string.substring(0, n));
    }

    public int binarysearch(int[] nums, int Target, int i, int j) throws IllegalAccessException {
        int m = (i + j) >>> 1;
        if (i <= j) {
            if (nums[m] == Target) {
                return m;
            } else if (nums[m] < Target) {
                return binarysearch(nums, Target, m + 1, j);
            } else {
                return binarysearch(nums, Target, i, m - 1);
            }
        }
        throw new IllegalAccessException(String.format("target %d out of the array!", Target));
    }

    public void bubblesort(int[] nums, int j) {
        if (j == 0) return;
        for (int i = 0; i < j; i++) {
            if (nums[i] > nums[j]) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        bubblesort(nums, j - 1);
    }


    public void insertion(int[] a, int pointer) {
        if (pointer >= a.length) return;
        int i = pointer - 1;
        int pointervalue = a[pointer];
        while (i >= 0 && a[i] > pointervalue) {
            a[pointer] = a[i];
            a[i] = pointervalue;
            i--;
        }
        a[i + 1] = pointervalue;
        pointer++;
        insertion(a, pointer);
    }

    public void sort(int[] a) {
        insertion(a, 1);
    }


    //递归调用次数2*fibonacci(n+1)-1   时间复杂度O(1.618^n)  rabbit problem-> a classic problem
    public int Fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //optimization
    public static int Cache(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return Fibonacci1(n, cache);
    }

    private static int Fibonacci1(int n, int[] cache) {
//        if (n == 1) return 0;
//        if (n == 2) return 1;
        if (cache[n] != -1) {
            return cache[n];
        }
        cache[n] = Fibonacci1(n - 1, cache) + Fibonacci1(n - 2, cache);
        return cache[n];
    }


    public int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n - 1);
    }


    //Tower of Hanol
    public static void Hanol() {

    }

//    //杨辉三角
//    public int yanghui(int i, int j) {
//        if (i == j || j == 1 || i == 1) return 1;
//        return yanghui(i - 1, j - 1) + yanghui(i - 1, j);
//    }
//
//    public void printYangHuiTriangle(int rows) {
//        for (int i = 1; i <= rows; i++) {
//            for (int k = 1; k <= 2 * (rows - i); k++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= i; j++) {
//                System.out.printf("%-4d", yanghui(i, j));//-代表左对齐
//            }
//            System.out.println();
//        }
//    }

//    //杨辉三角-optimization
//    public int yanghui(int[][] triangle,int i, int j) {
//        if (i == j || j == 0 || i == 0) return 1;
//        if(triangle[i][j]!=0){
//            return triangle[i][j];
//        }
//        triangle[i][j]=yanghui(triangle,i - 1, j - 1) + yanghui(triangle,i - 1, j);
//        return triangle[i][j];
//    }
//
//    public void printYangHuiTriangle(int rows) {
//        int[][] triangle=new int[rows][rows];
//        for (int i = 0; i < rows; i++) {
//            for (int k = 0; k < 2 * (rows - i); k++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < i; j++) {
//                System.out.printf("%-4d", yanghui(triangle,i, j));//-代表左对齐
//            }
//            System.out.println();
//        }
//    }


    //    杨辉三角- optimize more
    public int yanghui(int[] triangle, int i, int j) {
        if (i == j || j == 0 || i == 0) return 1;
        if (triangle[i] != 0) {
            return triangle[i];
        }
        triangle[j] = yanghui(triangle, i,j - 1) + yanghui(triangle, i, j);
        return triangle[i];
    }

    public void printYangHuiTriangle(int rows) {
        int[] triangle = new int[rows];
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < 2 * (rows - i); k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.printf("%-4d", yanghui(triangle, i, j));//-代表左对齐
            }
            System.out.println();
        }
    }

    //82!!!!!!!!!!difficult!!!


}
