import java.util.List;

public class MyArrayList<E> implements MyList<E> {
private int INIT_SIZE = 16;
private Object[] ArrList = new Object[INIT_SIZE];
private int point = 0; //size ArrayList


    @Override
    public void add(E element) {
    if(point == ArrList.length){
        resize(ArrList.length * 2);
    }
        ArrList[point++] = element;
    }

    public void add(int index, E element){
        if(point == ArrList.length){
            resize(ArrList.length * 2);
        }

        System.arraycopy(ArrList, index, ArrList, index + 1, point - index);
        ArrList[index] = element;
        point++;

    }

    public int size(){
        return point;
    }

    private void resize(int length){
        Object[] ArrayList = new Object[length];
        System.arraycopy(ArrList, 0, ArrayList, 0, ArrList.length);
        ArrList = ArrayList;
    }

    public Object get(int index){
        return ArrList[index];
    }

    public void remove(int index){
       for(int i = index; i < point; i++){
           ArrList[i] = ArrList[i+1];
       }
       ArrList[point] = null;
       point--;
    }

    public void remove(E element){
        for(int i = 0; i < point; i++){
            if(element.equals(ArrList[i])){
                ArrList[i] = null;
                System.arraycopy(ArrList, i+1, ArrList, i, point - i);
            }
        }
        point--;
    }

    public boolean isEmpty(){
        return point == 0;

    }

    public boolean contains(E element){
        if(element == null) {
            for (int i = 0; i < point; i++) {
                ArrList[i] = null;
                return true;

            }
        }
        else {
          for(int i = 0; i < point; i++)  {
              if(element.equals(ArrList[i]))
                  return true;
          }
        }
    return false;
    }

    public void clear(){
        for(int i = 0; i < point; i++) {
            ArrList[i] = null;

        }
        point = 0;
    }

public int indexOf(E element){
        if(element == null){
            for(int i = 0; i < point; i++){
                ArrList[i] = null;
                return i;
            }

        }
        else {
            for(int i = 0; i < point; i++){
                if(element.equals(ArrList[i])){
                    return i;
                }
            }
        }
        return -1;
}

public void set(int index, E element){
        for(int i = 0; i < point; i++){
            if(i == index){
                ArrList[i] = element;
            }
        }
}
}

