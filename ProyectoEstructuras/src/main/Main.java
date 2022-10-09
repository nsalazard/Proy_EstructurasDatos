/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import structures.DynamicArray;
import structures.OrderedLinkedList;
import structures.OrderedDoublyLinkedList;
import java.util.Comparator;
/**
 *
 * @author Usuario
 */
public class Main {
    
    public static final Comparator<Integer> comp = new ByValue();

    private static class ByValue implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return x - y;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        /*
        DynamicArray<Integer> a = new DynamicArray<>();
        a.pushBack(3);
        a.pushBack(-5);
        a.pushBack(8);
        a.pushBack(4);
        a.pushBack(2);
        a.pushBack(7);
        a.pushBack(9);
        a.pushBack(30);
        a.pushBack(-25);
        a.sort(comp);
        a.showArray();
        */
        OrderedDoublyLinkedList<Integer> a = new OrderedDoublyLinkedList<>(comp);
        a.push(3);
        a.push(4);
        a.push(5);
        a.push(-1);
        a.push(1);
        a.push(-4);
        a.push(-5);
        a.showList();
        a.pop(10);
        a.showList();
    }
    
}
