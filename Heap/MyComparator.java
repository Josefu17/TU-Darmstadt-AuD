import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {
    public int compare(Integer int1, Integer int2){
        if(int1 < int2)
            return -1;
        else if(int1 > int2)
            return 1;
        return 0;
    }
}
