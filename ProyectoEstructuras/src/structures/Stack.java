package structures;
import java.util.Arrays;
public class Stack {
    public static void main(String[] args) {

        Stack pila = new Stack();

        int max = 10000;
        long contador = System.nanoTime();

        for(int i = 0; i < max; i++) {
            int getRandomValue = (int) (Math.random()*(max));
            pila.push(getRandomValue);

        }

        pila.datos();
        long contador1 = System.nanoTime();
        System.out.println(contador1 - contador);

    }
    private static final int N = 10000;
    private int top;
    public float[] pila;


    public Stack() {
        this(N);
    }

    public Stack(int n) {
        top = 0;
        pila =  new float[n];
    }
    public void push(float item) {
        if (top == N){
            throw new RuntimeException("La pila está llena");
        }
        pila[top] = item;
        top++;
    }
    public float pop() {
        float dato = pila[top];
        top--;
        return dato;
    }
    public void datos(){
        Arrays.parallelSort(pila,0,N);

        for(float x : pila){
            System.out.println(x);
        }
    }

}