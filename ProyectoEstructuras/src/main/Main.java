/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProyectoEstructuras.src.main;

import ProyectoEstructuras.src.structures.DynamicArray;
import ProyectoEstructuras.src.structures.OrderedLinkedList;

import structures.OrderedDoublyLinkedList;
import java.util.Comparator;
/**
 *
 * @author Usuario
 */
public class Main {
    
    public static final Comparator<Float> comp = new ByValue();

    private static class ByValue implements Comparator<Float> {
        @Override
        public int compare(Float x, Float y) {
            return x - y < 0 ? -1:1 ;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        OrderedDoublyLinkedList<Integer> a = new OrderedDoublyLinkedList<>(comp);
        int n = 100000;
        OrderedDoublyLinkedList <Float> contador = new OrderedDoublyLinkedList<Float>(comp);
        long tiempo = System.nanoTime();
        for(int i = 0; i < n; i++){
            contador.push((float) (Math.random()*(n)));
        }
        contador.showList();
        long tiempo1 = System.nanoTime();
        System.out.println(tiempo1 - tiempo);

    }
    
}
