import java.math.BigInteger;
import java.util.Random;

public class MapItem <V>{
    String key;
    V value;
    public MapItem(String key, V value){
        if (key == null) {
            throw new NullPointerException("Key is null!");
        }
        this.key = key;
        this.value = value;
    }

    public static long F(String key){
        long accu = 0;
        for(int i=0; i < key.length(); i++){
            BigInteger P = BigInteger.probablePrime(20, new Random());
            if(accu + P.longValue() * i > Long.MAX_VALUE){
                accu = accu % P.longValue();
            }
            accu += (P.longValue() * i);
        }
        return accu;
    }
}
