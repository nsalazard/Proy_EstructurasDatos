package dynamic_arrays;

public class MainClass {

    public static void main(String[] args) {
        DynamicArray midDArray = new DynamicArray();
        midDArray.PushBack(1);
        midDArray.PushBack(2);
        midDArray.PushBack(3);

        midDArray.showArray();
        System.out.println();

        midDArray.Remove(1);

        midDArray.showArray();
        System.out.println();

        System.out.println(midDArray.get(1));
        System.out.println();

        midDArray.PushBack((float) 9.3);
        midDArray.PushBack(3);

        midDArray.showArray();
        System.out.println();

        midDArray.set(2, 0);
        midDArray.showArray();
        System.out.println();

        midDArray.PushBack(0);
        midDArray.showArray();
        System.out.println();

        midDArray.set(0, 1);
        midDArray.set(1, 2);
        midDArray.set(2, 3);
        midDArray.set(3, 4);
        midDArray.set(4, 5);
        midDArray.PushBack(6);
        midDArray.PushBack(7);
//        midDArray.PushBack(8
        midDArray.PushIn((float) 2.5);

        midDArray.showArray();
        System.out.println();

        DynamicArray miArr2 = new DynamicArray();
        miArr2.PushIn(2);
        miArr2.PushIn(4);
        miArr2.PushIn(1);
        miArr2.PushIn((float)1.5);
        miArr2.PushIn(3);
        miArr2.PushIn(7);
        miArr2.PushIn((float)3.4);
        miArr2.PushIn(7);
        miArr2.PushIn((float) 9.8);
        miArr2.showArray();
        System.out.println(miArr2.getBestOne());
        
        
        
        
        /*int[] a= new int[2];
        int[] b= new int[4];
        
        a[0]=1;
        a[1]=2;
        
        b[0]=1;
        b[1]=2;
        
        a= b; 
                
        a[2]=3;
        a[3]=4;
        
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        
        
        
//        DArray2 miArr2 = new DArray2();
//        miArr2.PushBack(33);
        
         */
    }
}
