package h00;

public class Adder <T> {
    public Integer add(Integer a, Integer b) {
        if(a == null){
            return b;
        }else if(b == null){
            return a;
        }
        return a + b;
    }
}
