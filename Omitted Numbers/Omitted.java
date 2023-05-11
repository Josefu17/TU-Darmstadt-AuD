import java.util.ArrayList;


/** Problem:
 * To apply the Sieve of Eratosthenes, start with the natural numbers (skipping 1), keep the first number (i.e., 2), and
 * delete all multiples (4, 6, 8, 10, etc.). Then repeat: keep the first remaining number (3) and delete all multiples
 * (9, 15, 21, etc.). The remaining numbers are the primes. To apply the Sieve of Flavius Josephus, start with the
 * natural numbers. On the th step, remove every st term remaining after the st step. So, on the first step, remove
 * every second number (2, 4, 6, 8, etc.) to leave 1, 3, 5, 7, 9, 11, 13, 15, 17…On the second step, remove every
 * third number (5, 11, 17, etc.) to leave 1, 3, 7, 9, 13, 15, 19,…
 */


public class Omitted {
    public static void main(String[] args){
        ArrayList<Integer> list = createList(1000);
        ArrayList<Integer> result = findOmitted(list);
        for(Integer i : result){
            System.out.println(i);
        }

    }

    /**
     * Method to create an ArrayList consisting of numbers starting from 1 in ascending order
     * @param length parameter to decide the length of the ArrayList
     * @return generated ArrayList
     */
    public static ArrayList<Integer> createList(int length){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<length; i++){
            result.add(i+1);
        }
        return result;
    }

    /**
     * Method to calculate the Omitted Numbers in ascending order
     * @param input input parameter to calculate the omitted numbers from
     * firstly a copy of the input array is generated. The reason for that is that we need to modify the total list
     * in order to keep track of what numbers are still available to choose from but if we modify the parameter
     * list to find this out, there might be some unintended outcomes, if the caller of this method wanted to use the
     * input parameter later on.
     * @return an ArrayList of the Omitted Numbers in ascending order
     */
    public static ArrayList<Integer> findOmitted(ArrayList<Integer> input){
        ArrayList<Integer> inputCopy = (ArrayList<Integer>) input.clone();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> notToOmit = new ArrayList<>();
        for(int i = 2; i<inputCopy.size(); i++){
            result.add(inputCopy.get(i-2));
            for(int j=i-1; j<inputCopy.size(); j+=i){
                notToOmit.add(inputCopy.get(j));
            }
            inputCopy.removeAll(notToOmit);
            notToOmit.clear();
        }
        return result;
    }


}
