import java.lang.reflect.Array;

public class HashTable <V>{

     MapItem<V>[] table;
    public HashTable(int nMax){
        table = (MapItem<V>[]) Array.newInstance(MapItem.class, nMax * 10);
    }

    public V find(String key){
        int index = (int) MapItem.F(key) % table.length;
        System.out.println("Index: " + index);
        if(table[index] == null){
            return null;
        }
        while(table[index] != null && !table[index].key.equals(key)){
            index = (index+1) % table.length;
        }
        return table[index] == null ? null : table[index].value;
    }

    public V insert(String key, V value){
        if(isFull() && !containsKey(key)){
            return null;
        }
        int index = (int) MapItem.F(key);
        System.out.println(index);
        index %= table.length;
        System.out.println(index);
        for(; ; ){
            if(table[index] == null){
                table[index] = new MapItem<V>(key, value);
                return table[index].value;
            }else if(table[index].key.equals(key)){
                V tmp = table[index].value;
                table[index].value = value;
                return tmp;
            }index = (++index) % table.length;
        }
    }
    public boolean isFull(){
        for(MapItem<V> MI : table){
            if(MI == null)
                return false;
        }
        return true;
    }

    public boolean containsKey(String key){
        for(MapItem<V> MI : table){
            if(MI.key.equals(key))
                return true;
        }
        return false;
    }
}
