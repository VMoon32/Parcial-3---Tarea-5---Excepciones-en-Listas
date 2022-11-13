package uaslp.objetos.list.ArrayList;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.NullNotAllowedException;

public class ArrayList<T> implements List<T> {

    private  static final int DEFAULT_SIZE = 5; //Primer tamaño del arreglo que crecera conforme se agreguen elementos
    private T[] array;
    private int size;

    public ArrayList(int size){
        array = (T[]) new Object[size];
    }

    public ArrayList(){
        array = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void addAtTail(T data) throws NullNotAllowedException
    {
        if(data == null)
        {
            throw new NullNotAllowedException();
        }

        if(size == array.length){
            increaseArrayList();
        }
        array[size]=data;
        size++;
    }

    @Override
    public void addAtFront(T data) throws NullNotAllowedException
    {
        if(data == null)
        {
            throw new NullNotAllowedException();
        }

        if(size == array.length)
        {
            increaseArrayList();
        }

        if (size >= 0) System.arraycopy(array, 0, array, 1, size);
        array[0]=data;
        size++;
    }

    @Override
    public boolean remove(int index)
    {
        if (index < 0 || index >= size)
        {
            return false;
        }

        if (size - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, size - 1 - index);

        array[size-1]=null;

        size--;

        return true;
    }

    @Override
    public void removeAll()
    {
        for(int i=0;i<size;i++)
        {
            array[i]=null;
        }
        size=0;
    }

    /*@Override
    public void removeAllWithValue(T data)
    {
        int index=0;

        while(index<size)
        {
            if(array[index].equals(data))
            {
                this.remove(index);
            }
            else
            {
                index++;
            }
        }
    }*/

    @Override
    public T getAt(int index)
    {
        return index >= 0 && index < size ? array[index] : null;
    }

    @Override
    public boolean setAt(int index,T data) throws NullNotAllowedException
    {
        if(data == null)
        {
            throw new NullNotAllowedException();
        }

        if(index >= 0 && index < size)
        {
            array[index]=data;
        }

        return true;
    }

    @Override
    public int getSize()
    {
        return size;
    }

    @Override
    public Iterator<T> getIterator() {
        return new Iterator<T>() { //Clase anónima de iterator
                      //También es una inner class no estática
            private int currentItem;

            @Override
            public boolean hasNext() {
                return currentItem < size;
            }

            @Override
            public T next() {
                return array[currentItem++];
            }
        };
    }

    private void increaseArrayList(){
        T []newArray = (T[])new Object[array.length * 2];

        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);

        array=newArray;
    }
}

