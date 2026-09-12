package Algorithm;

import javax.swing.text.html.HTMLDocument;
import javax.tools.ForwardingFileObject;
import java.util.Arrays;
import java.util.Iterator;

public class main {
    static void main(String[] args) {
        int[] a=new int[100];
        for (int i = 0; i < 100; i++) {
            a[i]=i;
        }

        Iterator<Integer> iterator=new Iterator<Integer>() {
            int index=0;
            @Override
            public boolean hasNext() {// whether has next element
                return index<a.length;
            }
            @Override
            public Integer next() {//return current element and move to next element
                return a[index++];
            }
        };

    }
}
