/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import structures.DynamicArray;
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
    }
    
}
