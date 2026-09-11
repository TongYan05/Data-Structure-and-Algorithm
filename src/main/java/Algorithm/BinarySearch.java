package Algorithm;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.swing.text.html.HTML;
import java.security.Principal;

public class BinarySearch {
    public static void main(String[] args) {
        double x = (0 + 9) >>> 1;
        double y = (0 + 9.0) / 2;
        System.out.println(x + " " + y);
    }

    public static int BinarySearchTargetbasic(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;//无符号移位->移动二进制位向右一位
            if (a[mid] == target) return mid;
            else if (a[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public static int BinarySearchTargetbalance(int[] a, int target) {
        if (a.length == 0) return -1;
        int i = 0;
        int j = a.length;
        while (j - i > 1) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (a[i] == target) return i;
        else return -1;
    }


    //binary search return the left most repetitive element's index and also right most
    public static int BinarySearchTargetleftmost(int[] a, int target) {//求排名 +1 索引从0开始
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (a[m] < target) {
                i = m + 1;
            } else if (a[m] > target) {
                j = m - 1;
            } else {
                j = m - 1;
            }
        }
        return i; //元素存在就返回最左的索引，元素不存在就返回该插入的索引位
    }

    public static int BinarySearchTargetrightmost(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (a[mid] > target) {
                j = mid - 1;
            } else if (a[mid] < target) {
                i = mid + 1;
            } else {
                i = mid + 1;
            }
        }
        return i - 1;// 元素存在就返回最右边的元素索引，元素不存在就返回前任
    }

//    4 分钟前
//34. 在排序数组中查找元素的第一个和最后一个位置
//            中等
//    通过
//4
//        1 小时前
//35. 搜索插入位置
//            简单
//    通过
//4
//        2 小时前
//704. 二分查找
//            简单
//    通过
//1


}
