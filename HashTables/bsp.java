import java.lang.reflect.Array;

public class bsp<K, V>{
    K key;
    V value;
    public bsp(K key, V value){
        this.key = key;
        this.value = value;
    }
    public bsp<K, V>[] createArray(){
        bsp<String, Integer>[] arr = (bsp<String, Integer>[]) Array.newInstance(bsp.class, 10);
        arr[0] = new bsp<>("Hello", 11);
        bsp<String, Integer>[] arr2 = new bsp[10];
        arr2[0] = new bsp<>("Hi", 12);
        K[] arr3 = (K[]) new Object[10];
        //classCastException     bsp<String, Integer>[] arr4 = (bsp<String, Integer>[]) new Object[10];
        //classCastException     bsp<String, Integer>[] arr5 = (bsp[]) new Object[10];
        return null;
    }
}
