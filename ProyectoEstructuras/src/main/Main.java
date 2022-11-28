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
        /*
        OrderedDoublyLinkedList<Integer> a = new OrderedDoublyLinkedList<>(comp);
        int n = 1000;
        OrderedDoublyLinkedList <Float> contador = new OrderedDoublyLinkedList<Float>(comp);
        long tiempo = System.nanoTime();
        for(int i = 0; i < n; i++){
            contador.push((float) (Math.random()*(n)));
        }
        contador.showList();
        long tiempo1 = System.nanoTime();
        System.out.println(tiempo1 - tiempo);
        */
        
        //.....000110000000000000000
        Course course = new Course("Calc",new Schedule(98304,0,98304,0,0,0,0));
        course.append(new Group(new Professor("David",5f),20,new Schedule(1,1,1,1,1,1,1),"Calc"));
        course.append(new Group(new Professor("Alberto",4.8f),20,new Schedule(98304,0,98304,0,0,0,0),"Calc"));
        course.append(new Group(new Professor("Herrera",5f),10,new Schedule(2,2,0,2,2,2,2),"Calc"));
        
        course.sort();
        System.out.println(course.getName());
        course.getGroups().showArray();
    }
    /*
    {
    Curso: {Coursename: String, Dias: 0-2, Hora: 9-11},
    Grupos: [
    {Profesor: Nombre, Score: cali, Cupos: Int, Días: 0-2,Hora: 9-11},
    {...},
    {...},
    ]
    }
    */
    
}
