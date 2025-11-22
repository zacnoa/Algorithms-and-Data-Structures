package Strukture;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T extends Comparable<T>> {



    private List<T> heapList;
    Comparator<T> comparator;

    public Heap(List<T> listToHeapify, Comparator<T> comparator)
    {
        this.heapList = new ArrayList<>(listToHeapify);
        this.comparator=comparator;
        buildMaxHeap();

    }


    private Integer leftChild(Integer index)
    {
        return index*2+1;
    }
    private Integer rightChild(Integer index)
    {
        return index*2+2;
    }
    private Integer parent(Integer index)
    {
        return (index-1)/2;
    }

    private Boolean compareKeys(T a,T b)
    {
        return comparator.compare(a,b)>0;
    }

    private void swapValues(Integer a,Integer b)
    {
        T temp= heapList.get(a);
        heapList.set(a, heapList.get(b));
        heapList.set(b,temp);
    }

     protected void heapify(Integer nodeIndex) {
        Integer leftChildIndex = leftChild(nodeIndex);
        Integer rightChildIndex = rightChild(nodeIndex);
        Integer childIndexToSwap=nodeIndex;
        if (leftChildIndex < heapList.size() && compareKeys(heapList.get(leftChildIndex), heapList.get(nodeIndex)))
        {
            childIndexToSwap=leftChildIndex;
        }
        if(rightChildIndex< heapList.size() && compareKeys(heapList.get(rightChildIndex), heapList.get(childIndexToSwap)))
        {
            childIndexToSwap=rightChildIndex;
        }
        if(!childIndexToSwap.equals(nodeIndex))
        {
            swapValues(nodeIndex,childIndexToSwap);
            heapify(childIndexToSwap);
        }

    }
    protected void buildMaxHeap()
    {

        for(Integer i = heapList.size()/2-1; i>=0; i--)
        {
            heapify(i);
        }

    }
      public List<T> heapSort()
    {
        List<T> sortedList=new ArrayList<>();
        List<T> tempHeapList=new ArrayList<>(this.heapList);
        for(int i=tempHeapList.size()/2-1;i>=1;i--)
        {
            sortedList.addLast(tempHeapList.getFirst());
            swapValues(0, heapList.size()-1);
            tempHeapList.removeLast();

            heapify(0);
        }
        return sortedList;
    }
    public T getTop()
    {
        return heapList.getFirst();
    }



}
