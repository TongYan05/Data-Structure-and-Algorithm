import Algorithm.recursion;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;
import java.util.Scanner;

import static Algorithm.recursion.Cache;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class recursiontest {

    @Test
    public void factorial() throws IllegalAccessException {
        recursion r = new recursion();
        System.out.println(r.factorial(-10));
    }
    @Test
    public void reverselyPrintString() throws IllegalAccessException {
        recursion r = new recursion();
        System.out.println(r.reverselyPrintString("123456789"));
    }
    @Test
    public void binarysearch() throws IllegalAccessException {
        recursion r = new recursion();
        int[] a={1,2,3,4,5,6,7,8,9};
        System.out.println(r.binarysearch(a,30,0,8));
    }

    @Test
    public void test1() {
        recursion r = new recursion();
        assertEquals(1, Cache(2));
        assertEquals(2, Cache(3));
        assertEquals(3, Cache(4));
        assertEquals(5, Cache(5));
        assertEquals(8, Cache(6));
        assertEquals(13, Cache(7));
        assertEquals(21, Cache(8));
        assertEquals(34, Cache(9));
        assertEquals(55, Cache(10));
        assertEquals(89, Cache(11));
        assertEquals(144, Cache(12));
        assertEquals(233, Cache(13));
    }


    @Test
    public void test(){
        recursion r = new recursion();
        System.out.println(r.sum(1500000)); //stackOverFlowError 爆栈

    }


}
