import java.util.Scanner;
public class Stack {
    public static void main(String[] args) {
        Stack pila = new Stack();
        Scanner solicitar = new Scanner(System.in);
        int datos = solicitar.nextInt();

        for(int i = 0; i< datos; i++){
            int cargar = solicitar.nextInt();
            pila.push(cargar);
        }
        System.out.println(pila.mejor());

    }
    private static final int N = 10000000;
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

    public float mejor(){
        for(int i = 0; i < top; i++){
            if (pila[i]  > pila[i + 1]){
                float guardar = pila[i];
                pila[i] = pila[i + 1];
                pila[i + 1] = guardar;
            }
        }
        return pila[top];
    }


}
