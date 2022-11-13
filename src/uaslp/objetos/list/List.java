package uaslp.objetos.list;

import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;
public interface List<T>{

    void addAtTail(T data) throws NullNotAllowedException;
    void addAtFront(T data) throws NullNotAllowedException;
    void removeAll();
    boolean remove(int index) throws WrongIndexException;
    //void removeAllWithValue(T data);
    boolean setAt(int index,T data) throws WrongIndexException, NullNotAllowedException;
    T getAt(int index) throws WrongIndexException;
    Iterator<T> getIterator();
    int getSize();
}


