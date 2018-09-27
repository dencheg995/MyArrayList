import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E> {
private int INIT_SIZE = 20;
private Object[] ArrList = new Object[INIT_SIZE];
private int point = 0; //size ArrayList


    @Override
    public boolean add(E element) {
    if(point == ArrList.length){
        resize(ArrList.length * 2);
    }
        ArrList[point++] = element;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null) {
            for (int i = 0; i < point; i++) {
                if (ArrList[i] == null) {
                    System.arraycopy(ArrList, i + 1, ArrList, i, point - i);
                    ArrList[--point]=null;
                    return true;
                }
            }
        }
        else {
            for(int i = 0; i < point; i++){
                if(o.equals(ArrList[i])){
                    ArrList[i] = null;
                    System.arraycopy(ArrList, i+1, ArrList, i, point - i);
                    ArrList[--point]=null;
                    return true;
                }

            }
        }

        return false;
    }

    @Override
    public int indexOf(Object o) {
        if(o == null){
            for(int i = 0; i < point; i++){
                ArrList[i] = null;
                return i;
            }

        }
        else {
            for(int i = 0; i < point; i++){
                if(o.equals(ArrList[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int ind = 0;
        for(int i = 0; i < point; i++) {
            ind++;
            if(c.iterator().next().equals(ArrList[i]) & ind == point) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] tempArr = c.toArray();
        int length = tempArr.length;
        System.arraycopy(tempArr, 0, ArrList, point, length);
        point += length;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] tempArr = c.toArray();
        int length = tempArr.length;

        if(index == 0) {
            System.arraycopy(tempArr, 0, ArrList, point + length, length);
        }
        else {
            System.arraycopy(tempArr, index, ArrList, point + length, point - index);
        }
        point += length;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int w = 0;
        for(int i = 0; i < point; i++) {
            if (c.contains(ArrList[i])) {
                w++;
                System.arraycopy(ArrList, w , ArrList, i, point - i);
            }
            ArrList[point--] = null;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int w = 0;
        for(int i  = 0; i < point; i++) {
             if(!c.contains(ArrList[i])) {
                 if(i == 0) {
                    removeZero(0);
                 }

                 System.arraycopy(ArrList, i + 1, ArrList, i, point - i);
                 point--;
                 }


             }
        return true;
        }




    public int size(){
        return point;
    }

    private void resize(int length){
        Object[] ArrayList = new Object[length];
        System.arraycopy(ArrList, 0, ArrayList, 0, ArrList.length);
        ArrList = ArrayList;
    }

    public E get(int index){
        return (E) ArrList[index];
    }

    @Override
    public int lastIndexOf(Object o) {
        if(o == null) {
            for(int i = point -1 ; i < 0; i--) {
                if(ArrList[i] == null) {
                   return i;
                }
            }

        }
        else {
            for(int i = point - 1; i < 0; i--) {
                if(o.equals(ArrList[i])){
                   return i;
                }
            }

        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    public boolean isEmpty(){
        return point == 0;

    }

    @Override
    public boolean contains(Object o) {
        if(o == null) {
            for (int i = 0; i < point; i++) {
                if(ArrList[i] == null) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        else {
            for(int i = 0; i < point; i++)  {
                if(o.equals(ArrList[i]))
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[point];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        for(int i = 0; i < point; i++) {
      //      a[i] = ArrList[i];
        }

        return null;
    }


    public void clear(){
        for(int i = 0; i < point; i++) {
            ArrList[i] = null;

        }
        point = 0;
    }

    public E set(int index, E element){
        for(int i = 0; i < point; i++){
            if(i == index){
                ArrList[i] = element;
            }
        }
    return element;
}

    @Override
    public void add(int index, E element) {
        if(point == ArrList.length){
            resize(ArrList.length * 2);
        }

        System.arraycopy(ArrList, index, ArrList, index + 1, point - index);
        ArrList[index] = element;
        point++;

    }

    @Override
    public E remove(int index){
        E value = (E) ArrList[index];
        for(int i = index; i < point; i++){ //первая версия
            ArrList[i] = ArrList[i+1];
        }
      //  System.arraycopy(ArrList, index + 1, ArrList, index, point - index); // вторая версия
        ArrList[point--] = null;

        return value;
    }

    private void removeZero(int index) {
        for(int i = index; i < point; i++){ //первая версия
            ArrList[i] = ArrList[i+1];
        }
        ArrList[point--] = null;
    }

}

