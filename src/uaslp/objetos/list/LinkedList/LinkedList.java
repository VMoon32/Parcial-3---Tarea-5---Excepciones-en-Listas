package uaslp.objetos.list.LinkedList;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void addAtTail(T data) throws NullNotAllowedException
    {
        if(data == null)
        {
            throw new NullNotAllowedException();
        }

        Node<T> node=new Node<>(data);

        //node.data=data;
        if(size==0)
        {
            head=node;
        }else{
            tail.next=node;
            node.previous=tail;
        }
        tail = node;
        size++;
    }

    @Override
    public void addAtFront(T data) throws NullNotAllowedException
    {
        if(data == null)
        {
            throw new NullNotAllowedException();
        }

        Node<T> node = new Node<>(data);

        if (size == 0) {
            tail = node;
        } else {
            head.previous = node;
        }
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public boolean remove(int index) throws WrongIndexException
    {
        Node<T> node = findNode(index);

        /*if(index < 0 || index>=size){
            return false;
        }*/

        if(size == 1){
            head = null;
            tail = null;
        } else if(node == head){
            head = node.next;
            if(head != null){
                head.previous = null;
            }
        } else if(node == tail){
            tail = node.previous;
            if(tail != null){
                tail.next = null;
            }
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;

        return true;
    }

    @Override
    public void removeAll(){
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public T getAt(int index) throws WrongIndexException
    {
        Node<T> node = findNode(index);

        return node == null ? null : node.data;
    }

    @Override
    public boolean setAt(int index,T data) throws WrongIndexException, NullNotAllowedException
    {
        if(data == null)
        {
            throw new NullNotAllowedException();
        }

        if(index<0||index>=size)
        {
            throw new WrongIndexException(index);
        }

        Node<T> node = findNode(index);

        node.data=data;

        return true;
    }
    private Node<T> findNode(int index) throws WrongIndexException
    {
        if(index < 0 || index >= size){
            throw new WrongIndexException(index);
        }
        Node<T> node = head;
        int currentIndex = 0;
        while (currentIndex != index) {
            currentIndex++;
            node = node.next;
        }
        return node;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public LinkedListIterator<T> getIterator(){
        //return  null;
        return new LinkedListIterator<>();
    }

    public static class Node<T>{
        Node<T> next;
        Node<T> previous;
        T data;
        public Node(T data) {
            this.data = data;
        }
    }

    public class LinkedListIterator<T> implements Iterator<T> {

        private Node<T> currentNode;

        LinkedListIterator()
        {
            currentNode= (Node<T>) head;
        }

        @Override
        public boolean hasNext(){
            return currentNode != null;
        }

        @Override
        public T next(){
            T data= currentNode.data;
            currentNode=currentNode.next;
            return data;
        }
    }

}


