package oom;

import javax.swing.*;
import javax.xml.transform.Source;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;

class test1 {
    public int a=1;
//    test1(int a){
//        this.a=a;
//    }
    public void print() {
        System.out.println("test1");
    }
}

class test2 extends test1 {
    public int a=2;
    public void print() {
        System.out.println("test2");
    }
}

public class TEST {
    static void main(String[] args) {
//        print(1, 2);
//        Integer v=null;
//        int x=v;
//        Long L = 5L; Integer I = 5;
//        System.out.println(L==I);
//        test1 t1=new test1();
//        test1 t11=new test1();
//        test2 t2=new test2();
//        System.out.println(t1==t11);

        Double x=1.0;
        x++;
        System.out.println(x);

        test1 t1 =new test1();
        test1 t2 =new test2();
        System.out.println(t1.a+" "+t2.a);//instance field do not have dynamic binding


        int[] arr={2,3,6,1,6,21,4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void print(int... nums) {
        System.out.println("java");
    }

    public static void print(Integer x, Integer y) {
        System.out.println("python");
    }

    public static void print(long x, long y) {
        System.out.println("julia");
    }

}

