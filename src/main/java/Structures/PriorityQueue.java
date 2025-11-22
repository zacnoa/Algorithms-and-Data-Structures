package Structures;

import Interfaces.ChangeableKey;

import java.util.Comparator;
import java.util.List;

public class PriorityQueue<E extends ChangeableKey<T>, T> {

    Heap<E> heap;

    public PriorityQueue(List<E> collection, Comparator<E> comparator)
    {
        heap=new Heap<>(collection, comparator);
    }



    public E getTop()
    {
        return heap.heapList.get(0);
    }

    public E removeTop()
    {
        E top=heap.heapList.get(0);
        heap.swapValues(0,heap.heapList.size()-1);
        heap.heapList.removeLast();
        heap.heapify(0);
        return top;
    }

    public  void changeKey(E element, T newValue )
    {
        Integer index=heap.heapList.indexOf(element);
        if(index!=-1)
        {
            element.changeKey(newValue);
            heap.heapify(0);
        }
        else
        {
            System.out.println("nema tog elementa");
        }

    }
    public void add(E element)
    {
        heap.heapList.add(element);
        heap.heapify(0);

    }


}

