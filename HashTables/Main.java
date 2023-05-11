import java.lang.reflect.Array;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args){
        MapItem<String>[] str1 = (MapItem<String>[]) Array.newInstance(MapItem.class, 10);

        BigInteger bi = new BigInteger(String.valueOf(123131312093891204L));
        System.out.println();
        HashTable<String> table1 = new HashTable<>(13);
        table1.insert("apple", "Apfel");
        table1.insert("orange", "Orange");
        table1.insert("pear", "Birne");
        table1.insert("banana", "Banane");
        table1.insert("apricot", "Aprikose");
        table1.insert("plum", "Pflaume");
        table1.insert("peach", "Pfirsich");
        table1.insert("lemon", "Zitrone");

        for(MapItem<String> MI : table1.table){
            if(MI != null){
                System.out.println("Key: " + MI.key);
                System.out.println("Value: " + MI.value);
            }
        }
        System.out.println(-981 % 24);
        System.out.println(Math.floorMod(-981, 24));
        bsp<String, Integer> ex1 = new bsp<>("Bsp", 1);
        ex1.createArray();

    }


}
