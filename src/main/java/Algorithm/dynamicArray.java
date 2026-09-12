package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class dynamicArray implements Iterable<Integer>{
    private int size=0;
    private int capacity=8;
    private int[] array={};

    //add to the last position
    public void add(int element){
        addwithindex(size,element);
    }
    //add to the assigned position
    public void addwithindex(int index,int element){
        capacitycheck();
        if(index>=0&&index<size){
            System.arraycopy(array,index,array,index+1,size-index);
        }
        array[index]=element;
        size++;
    }

    private void capacitycheck() {
        if(size==0){
            array=new int[capacity];
        }
        else if(size==capacity){
            capacity=capacity+(capacity>>1);
            int[] newarray=new int[capacity];
            System.arraycopy(array,0,newarray,0,size);
            array=newarray;
        }
    }

    //get value from index
    public int get(int index){
        if(index>=0&&index<size) return array[index];
        return -1;
    }

    //get current length of array
    public int getSize(){
        return size;
    }

    //consumer
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }


    //interator
    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iterator=new Iterator<Integer>() {
            int index=0;
            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public Integer next() {
                return array[index++];
            }
        };
        return iterator;
    }

    //stream
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }



    //remove
    public void remove(int index){
        System.arraycopy(array,index+1,array,index,size-(index+1));
        size--;
    }

    //










}
