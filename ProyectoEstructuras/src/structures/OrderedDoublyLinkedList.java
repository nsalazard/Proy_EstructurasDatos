/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import java.util.Comparator;

/**
 *
 * @author Usuario
 * @param <T> Tipo de dato de la lista
 */
public class OrderedDoublyLinkedList<T> {
    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;
        
        public Node() {
            data = null;
            next = null;
            prev = null;
        }
        
        public Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }   
        
        public Node<T> getPrev() {
            return prev;
        }
        
        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private Comparator comparator;
    
    public OrderedDoublyLinkedList(Comparator comparator) {
        head = null;
        tail = null;
        size = 0;
        this.comparator = comparator;
    }
    
    public int getSize() {
        return size;
    }    
    
    public void push (T data) {
        Node<T> aux1 = head;
        Node<T> aux2 = head;
        while (aux1 != null && comparator.compare(data,aux1.getData()) > 0) {
            aux2 = aux1;
            aux1 = aux1.getNext();
        }
        Node<T> nnode = new Node<>(data);
        if (head == null) {
            head = nnode;
            tail = nnode;
        }
        else if (aux1 == head) {
            nnode.setNext(head);
            head.setPrev(nnode);
            head = nnode;
        }
        else if (aux1 == null) {
            nnode.setPrev(aux2);
            aux2.setNext(nnode);
            tail = nnode;
        }
        else {
            nnode.setNext(aux1);
            Node<T> aux = aux1.getPrev();
            aux.setNext(nnode);
            aux1.setPrev(nnode);
            nnode.setPrev(aux);
        }
    }
    
    public void pop(T data) {
        Node<T> aux1 = head;
        Node<T> aux2 = head;
        while (aux1 != null && !aux1.getData().equals(data)) {
            aux2 = aux1;
            aux1 = aux1.getNext();
        }
        if (aux1 == head) {
            head = head.getNext();
        }
        else if (aux1 != null){
            aux2.setNext(aux1.getNext());
        }
    }
    
    public T get(int pos) {
        Node<T> aux = head;
        while (pos-->0) {
            aux = aux.getNext();
        }
        T info = aux.getData();
        return info;
    }
    
    public T popFront() {
        if (head == null) {
            return null;
        }
        T info = head.getData();
        head = head.getNext();
        return info;
    }
    
    public T popBack() {        
        if (head == null) {
            return null;
        }
        T info = tail.getData();
        tail = tail.getPrev();
        return info;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> aux = head;
        while (aux != null) {
            sb.append(aux.getData().toString());
            sb.append(", ");
            aux = aux.getNext();
        }
        return sb.toString();
    }
    
    public void showList() {
        System.out.println(toString());
    }
}
