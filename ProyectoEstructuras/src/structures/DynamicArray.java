package structures;

import java.util.Comparator;


//Clase Arreglo Dinámico
public class DynamicArray<T> {

   
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
        array[pos] = array[size--];       
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
        for (int i=0;i<size;i++) {
            System.out.print(array[i].toString()+" ");
        }
        System.out.println();
    }
    
    /**
     * Sobrecarga del metodo toString
     * @return retorna un string con los elementos del arreglo separados por ", "
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T x : array) {
            sb.append(x.toString());
            sb.append(", ");
        }
        return sb.toString();
    }
    
    /**
     * Ordena el arreglo de menor a mayor
     * @param comparator forma de comparar los elementos
     */
    public void sort(Comparator comparator) {
        sort(0,size-1,comparator);
    }
    
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
    }
}
