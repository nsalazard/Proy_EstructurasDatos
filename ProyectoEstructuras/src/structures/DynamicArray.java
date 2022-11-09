package structures;

import java.util.Arrays;
import java.util.Comparator;


//Clase Arreglo Dinámico
public class DynamicArray<T> {
    public static void main(String[] args) {
        DynamicArray<Integer> Listado = new DynamicArray<>();
        // Pruebas método verificar

        System.out.println(Listado.verificar(4));
        System.out.println(Listado.verificar(4));
        System.out.println(Listado.verificar(5));
        System.out.println(Listado.verificar(5));
        System.out.println(Listado.verificar(5));
        System.out.println(Listado.verificar(2));
        System.out.println(Listado.verificar(2));
        System.out.println(Listado.verificar(3));
        System.out.println(Listado.verificar(2));
        System.out.println(Listado.verificar(1));
        System.out.println(Listado.getSize());
        System.out.println(Listado.get(4));





    }

    private T[] array;//Arreglo
    private int capacity = 2; //Capacidad actual
    private int size = 0; //Numero de elementos actual

    /**
     * Constructor por defecto
     */
    public DynamicArray() {
        array = (T[]) new Object[2];

    }



    /**
     * Agrega un elemento al final del arreglo
     * @param val Elemento a agregar
     */
    public void pushBack(T val) {
        if (size < capacity) {
            array[size++] = val;
        } else {
            T[] newArray = (T[])(new Object[2 * capacity]);
            System.arraycopy(array,0,newArray,0,capacity);
            capacity *= 2;
            array = newArray;
            array[size++] = val;
        }
    }

    // Método para que el usuario no pueda ingresar materias en la misma franja horaria
    public String verificar(T n) {
        String Valor = "";
        for(int j = 0; j < array.length; j++) {
            if (n == array[j]) {
                Valor = "Franja Llena, por favor seleccionar otro horario";
                break;
            }
            else if (n != array[j] && j == array.length -1){
                pushBack(n);
                Valor = "Materia y grupo guardados";
            }

        }
        return Valor;
    }

    /**
     * Obtiene un elemento del arreglo
     * @param pos posicion del elemento a retornar
     * @return elemento de la posicion
     */
    public T get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
            //System.out.println("ERROR: index out of range");
        }
        return array[pos];
    }

    /**
     * Inserta un elemento en una posicion especificada
     * @param pos Posicion en el arreglo
     * @param value Elemento a insertar
     */
    public void set(int pos, T value) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[pos] = value;
    }

    /**
     * Elimina un elemento del arreglo
     * @param pos posicion del elemento
     */
    public void remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[pos] = array[--size];
    }

    public void popBack() {
        size--;
    }

    /**
     * Cantidad de elementos
     * @return retorna cantidad de elementos actual en el arreglo
     */
    public int getSize() {
        return size;
    }

    /**
     * Muestra el arreglo por consola
     */
    public void showArray() {
        System.out.println(toString());
    }

    /**
     * Sobrecarga del metodo toString
     * @return retorna un string con los elementos del arreglo separados por ", "
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<size;i++) {
            sb.append(array[i].toString());
            sb.append(", ");
        }
        return sb.toString();
    }

    /**
     * Ordena el arreglo de menor a mayor
     * @param comparator forma de comparar los elementos
     */
    public void sort(Comparator comparator) {
        Arrays.parallelSort(array,0,size,comparator);
    }
    /*
    private void sort(int beg, int las,Comparator comparator){
        if (beg < las) {
            int mid = (beg+las)>>1;
            sort(beg,mid,comparator);
            sort(mid+1,las,comparator);
            merge(beg,mid,las,comparator);
        }
    }

    private void merge(int beg,int mid,int las,Comparator comparator) {
        T[] auxArray = (T[])(new Object[array.length]);
        System.arraycopy(array,beg,auxArray,beg,las-beg+1);
        int idx = beg;
        int idx1 = beg;
        int idx2 = mid+1;
        while (idx1 <= mid || idx2 <= las) {
            if (idx1 > mid) {
                array[idx++] = auxArray[idx2++];
            }
            else if (idx2 > las) {
                array[idx++] = auxArray[idx1++];
            }
            else {
                array[idx++] = comparator.compare(auxArray[idx1], auxArray[idx2]) <= 0 ? auxArray[idx1++] : auxArray[idx2++];
            }
        }
    }*/
}