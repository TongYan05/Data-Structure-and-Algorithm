import Algorithm.dynamicArray;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;
import java.sql.SQLOutput;
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


    @Test
    public void dynamicarray(){
        dynamicArray dynamicArray = new dynamicArray();
        for (int i = 1; i < 100; i*=3) {
            dynamicArray.add(i);
        }

        for (int i = 0; i < dynamicArray.getSize(); i++) {
            System.out.println(dynamicArray.get(i));
        }

        System.out.println("==================================");
        dynamicArray.addwithindex(3,1072);

        for (int i = 0; i < dynamicArray.getSize(); i++) {
            System.out.println(dynamicArray.get(i));
        }

        System.out.println("consumer=========================");

        dynamicArray.foreach(element-> System.out.println(element*8));

        System.out.println("iterator===================");
        for(int x: dynamicArray){
            System.out.println(x);
        }

        System.out.println("Instream========================");
        dynamicArray.stream().forEach(x-> System.out.println(x));

    }

    @Test
    public void remove(){
        int[] a={1,20,30,40,50,60,70,80,90,100,110,120};
        dynamicArray d=new dynamicArray();
        for (int i = 0; i <a.length ; i++) {
            d.addwithindex(i, a[i]);
        }
        d.remove(7);
        d.stream().forEach(x-> System.out.println(x));


    }





}
