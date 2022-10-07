public class Stack {
    public static void main(String[] args) {
        Stack pila = new Stack();
        pila.push(10);
        pila.push(5);
        pila.push(7);
        pila.push(3);
        pila.push(11);
        pila.push(19);


        System.out.println(pila.mejor());
        System.out.println(pila.pop());

    }
    private static final int N = 7;
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
        if (top == 6){
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
