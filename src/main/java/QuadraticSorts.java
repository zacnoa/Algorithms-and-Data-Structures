
import java.util.Comparator;
import java.util.List;

public class QuadraticSorts {


    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *
     */



    static public <T>  void bubbleSort(List<T> list, Comparator<T> comparator)
    {
        Boolean flag=false;
        for(Integer i = 0; i< list.size()-1; i++)
        {

            for(Integer j = 0; j< list.size()-i-1; j++)
            {
                if(comparator.compare(list.get(j), list.get(j+1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    flag = true;

                }
            }
            if(!flag)
            {
                break;
            }
        }
    }
    static public <T>  void quickSort(List<T> list, Comparator<T> comparator)
    {
        for(Integer i=0;i<list.size()-2;i++)
        {
            Integer outlier=i;
            for(Integer j=i+1;j<list.size()-1;j++)
            {
                if(comparator.compare(list.get(outlier), list.get(j)) > 0)
                {
                    outlier=j;
                }
            }
            if(i!=outlier)
            {
                T temp = list.get(i);
                list.set(i, list.get(outlier));
                list.set(outlier, temp);
            }
        }
    }

    static public <T> void insertionSort(List<T> list, Comparator<T> comparator)
    {
        for(Integer i=1;i<list.size()-1;i++)
        {
            T current=list.get(i);
            Integer j=i-1;
            while(j>=0 && comparator.compare(list.get(j),current) > 0)
            {
                list.set(j+1,list.get(j));
            }
            list.set(j+1,current);
        }
    }
}
