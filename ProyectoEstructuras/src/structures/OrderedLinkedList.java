/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoEstructuras.src.structures;

import java.util.Comparator;

/**
 *
 * @author Usuario
 * @param <T> tipo de dato
 */
public class OrderedLinkedList<T> {
    private class Node<T> {
        private T data;
        private Node<T> next;
        
        public Node() {
            data = null;
            next = null;
        }
        
        public Node(T data) {
            this.data = data;
            next = null;
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
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private Comparator comparator;
    
    public OrderedLinkedList(Comparator comparator) {
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
            head = nnode;
        }
        else if (aux1 == null) {
            aux2.setNext(nnode);
            tail = nnode;
        }
        else {
            aux2.setNext(nnode);
            nnode.setNext(aux1);
        }
        size++;
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
            size--;
        }
        else if (aux1 != null){
            aux2.setNext(aux1.getNext());
            size--;
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
            return  null;
        }
        T info = head.getData();
        head = head.getNext();              
        return info;
    }
    
    public T popBack() {
        if (head == null) {
            return null;
        }
        Node<T> aux1 = head;
        Node<T> aux2 = head;
        T info;
        while (aux1.getNext() != null) {
            aux2 = aux1;
            aux1 = aux1.getNext();
        }
        if (aux1 == head) {
            info = aux1.getData();
            head = null;
        }
        else {
            info = aux1.getData();
            aux2.setNext(null);
        }   
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
