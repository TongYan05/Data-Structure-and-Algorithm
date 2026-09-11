import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class test {

    @Test
    public void binarysearch(){
        int[] a={1,20,30,40,50,60,70,80,90};
        int key=36;
        int insertindex=Arrays.binarySearch(a,key);
        System.out.println(insertindex);//return value=-(insertion point -1) -1 -> insertion point = 3
    }


    @Test
    public void arraycopy(){
        int[] a={1,20,30,40,50,60,70,80,90};
        int key=36;
        int insertindex=4;
        int[] b=new int[a.length+1];
        System.arraycopy(a,0,b,0,insertindex);
        System.out.println(Arrays.toString(b));
        b[insertindex]=key;
        System.arraycopy(a,insertindex,b,insertindex+1,a.length-insertindex);
        System.out.println(Arrays.toString(b));
    }



}
