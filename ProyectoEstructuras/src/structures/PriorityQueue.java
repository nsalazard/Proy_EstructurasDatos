/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
/**
 *
 * @author Juan carlos
 */
public class PriorityQueue {
    private DynamicArray<Double> arr;
    
    public PriorityQueue() {
        arr = new DynamicArray();
        arr.pushBack(-1.0);
    }
    
    public void push(double x) {
        //System.out.printf("{%f}\n",x);
        arr.pushBack(x);
        swift(arr.getSize()-1);
    }
    
    public int getSize() {
        return arr.getSize()-1;
    }
    
    private void swap(int i, int j) {
        Double aux = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, aux);
    }
    
    private void swift(int i) {
        while (i>1 && arr.get(i) > arr.get(i/2)) {
           // System.out.printf("{%f,%f}\n",arr.get(i),arr.get(i/2));
            swap(i,i/2);
            i /= 2;
        }
    }
        
    private void sink() {
        int i = 1;
        while ((i*2) < arr.getSize()) {
            int j = (i*2);
            if (j+1 < arr.getSize() && arr.get(j) < arr.get(j+1)) {
                j++;
            }
            if (arr.get(i) < arr.get(j)) {
                swap(i,j);
            }
            else {
                break;
            }
            i = j;
        }
    }
    
    public Double pop() {
        if (arr.getSize() > 1) {
            Double aux = arr.get(1);
            swap(1,arr.getSize()-1);
            arr.popBack();
            sink();
            return aux;
        }
        return -1.0;
    }
    
    public boolean empty() {
        return getSize() <= 0; 
    }
    
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        int n = 8;
        long start = System.nanoTime();
        for (int i=0;i<n;i++) {
            pq.push(Math.random()*5);
        }
        
        while (!pq.empty()) {
            System.out.println(Double.toString(pq.pop())+" ");
            //pq.arr.showArray();
        }
        long end = System.nanoTime();
        System.out.println((end - start)*1e-9);
    }
}
