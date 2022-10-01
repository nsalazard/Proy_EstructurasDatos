package dynamic_arrays;

public class DynamicArray {

    private float[] array = new float[2];
    private int capacity = 2;
    private int size = 0;

    public DynamicArray() {

    }

    // este método mete en el array el valor que se le pase de manera que los valores quedan organizados de menor a mayor
    public void PushIn(float value) {

        if (size >= capacity) {
            float[] newArray = new float[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = array[i];
            }
            capacity *= 2;
            array = newArray;
        }
        boolean flag = false;

        for (int i = 0; i < size; i++) {
            if (array[i] >= value) {
                flag = true;
                for (int j = size; j >i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = value;
                break;
            }
        }
        if (flag == false) {
            array[size] = value;
        } 
        size++;

        

    }

    public void PushBack(float val) {
        if (size < capacity) {
            array[size] = val;
            size++;
        } else {
            float[] newArray = new float[2 * capacity];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = array[i];
            }
            capacity *= 2;
            array = newArray;
            array[size] = val;
            size++;
        }
    }
    //devuelve el valor en el array más grande
    public float getBestOne(){
        return array[size-1];
    }

    public float get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new RuntimeException("ERROR: index out of range");
            //System.out.println("ERROR: index out of range");
        } else {
            return array[pos];
        }
    }

    public void set(int pos, float value) {
        if (pos < 0 || pos >= size) {
            throw new RuntimeException("ERROR: index out of range");
        } else {
            array[pos] = value;
        }
    }

    public void Remove(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("ERROR: index out of range ");
        } else {
            for (int i = pos; i <= size - 1; i++) {
                array[i] = array[i + 1];
            }
            size -= 1;
        }

    }

    public int Size() {
        return size;
    }

    public void showArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
