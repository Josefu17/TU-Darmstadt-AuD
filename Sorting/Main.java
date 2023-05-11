import java.util.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        int[] input = {3,45,1,9,8,12,5,1};
        int[] output = input.clone();
        for(int i=0; i < input.length; i++){
            System.out.println(input[i]);
            System.out.println(output[i]);
        }
        System.out.println("Array ended here.");
        selectionSortArrayInPlace(input);
        int[] outputClone = selectionSortArrayCopy(output);
        for(int i=0; i < input.length; i++){
            System.out.println(input[i]);
            System.out.println(outputClone[i]);
        }
        System.out.println("\n Original Array: ");
        for(int i=0; i < input.length; i++){
            System.out.println(output[i]);
        }

        System.out.println("Test Bubble Sort Copy: ");
        for(int i=0; i < input.length; i++){
            System.out.println(output[i]);
        }
        int[] bubbleOutput = bubbleSortArrayCopy(output);
        for(int i=0; i < input.length; i++){
            System.out.println(bubbleOutput[i]);
        }

        System.out.println("Test Bubble Sort In-Place: ");
        bubbleSortArrayInPlace(output);
        for(int i=0; i < input.length; i++){
            System.out.println(output[i]);
        }
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(3);
        list1.add(9);
        list1.add(21);
        list1.add(4);
        list1.add(12);
        list1.add(5);
        list1.add(31);
        list1.add(21);
        list1.add(2);
        Iterator<Integer> it1 = list1.iterator();
        System.out.println("Selection Sort List Original: ");
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        selectionSortListInPlace(list1);
        Iterator<Integer> it2 = list1.iterator();
        System.out.println("Selection Sort List Edited: ");
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        int[] quickSort = new int[10];
        System.out.println("Recursion With Copy Method Test: ");
        quickSort[0] = 3;
        quickSort[1] = 45;
        quickSort[2] = 1;
        quickSort[3] = 9;
        quickSort[4] = 8;
        quickSort[5] = 12;
        quickSort[6] = 5;
        quickSort[7] = 5;
        quickSort[8] = 5;
        quickSort[9] = 456;
        System.out.println("Before: ");
        for (int j : quickSort) {
            System.out.println(j);
        }
        int[] recursionOutput = mergeSortRecursivelyCopy(quickSort);
        System.out.println("After: ");
        for(int i=0; i < quickSort.length; i++){
            System.out.println(recursionOutput[i]);
        }
        mergeSortRecursivelyInPlace(quickSort);
        System.out.println("Merge Recursive In-Place Test:");
        System.out.println("After: ");
        for(int j : quickSort){
            System.out.println(j);
        }

        int[] quickSortR = new int[10];
        System.out.println("Quick Sort Method Test: ");
        quickSortR[0] = 3;
        quickSortR[1] = 45;
        quickSortR[2] = 1;
        quickSortR[3] = 9;
        quickSortR[4] = 8;
        quickSortR[5] = 12;
        quickSortR[6] = 5;
        quickSortR[7] = 5;
        quickSortR[8] = 5;
        quickSortR[9] = 456;
        int[] result = quickSortRecursivelyCopy(quickSortR);
        for(int i : result){
            System.out.println(i);
        }


        ArrayList<ArrayList<String>> arr1 = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            arr1.add(new ArrayList<>());
        }
        ArrayList<String> AL1 = arr1.get(2);
        AL1.add("rot");
        AL1.add("oft");
        AL1.add("das");
        AL1.add("ein");
        ArrayList<String> AL2 = arr1.get(3);
        AL2.add("ball");
        AL2.add("ofen");
        ArrayList<String> AL3 = arr1.get(4);
        AL3.add("chrom");
        ArrayList<String> resultAL = bucketSort(arr1, 26);
        for(ArrayList<String> ALX : arr1){
            for(String str : ALX){
                System.out.println(str);
            }
        }
        System.out.println("Ende");
        for( String str : resultAL ){
            System.out.println(str);
        }

        System.out.println("Ende 2");
        ArrayList<String> AL92 = new ArrayList<>();
        AL92.add("rot");
        AL92.add("oft");
        AL92.add("das");
        AL92.add("ein");
        AL92.add("ball");
        AL92.add("ofen");
        AL92.add("chrom");

        for(String str : AL92){
            System.out.println(str);
        }

        System.out.println("\nend of list\n");
        AL92 = bucketSort(AL92, 26, 0);
        for(String str : AL92 ){
            System.out.println(str);
        }
        int[] inputArr = new int[]{98, 95, 78, 82, 75, 40, 26, 15, 28};
        for(int i : inputArr){
            System.out.println(i);
        }
        System.out.println("End of Array");
        int frequency78 = bubbleSortArrayInPlace(inputArr);
        for(int i : inputArr)
            System.out.println(i);

        System.out.println("Frequency of 78: " + frequency78);

        int[] selectionSortArr = new int[]{37, 45, 66, 91, 79, 75, 42, 8, 4, 96};
        for(int i : selectionSortArr)
            System.out.println(i);
        System.out.println("The End");
        selectionSortArrayInPlace(selectionSortArr);
        for(int i : selectionSortArr)
            System.out.println(i);
        StringSort list = new StringSort();
        list.insert("Hallo Welt");
        list.insert("Ryan");
        list.insert("tamping");
        list.insert("shopper");
        list.insert("Prague");
        list.insert("newsflash");
        list.insert("cursed");
        BSTSort bst = new BSTSort();
        bst.insert(5);
        bst.insert(44);
        bst.insert(35);
        bst.insert(16);
        bst.insert(11);
        bst.insert(42);
        bst.insert(30);
        bst.insert(12);
        bst.insert(20);
        bst.insert(36);
        bst.insert(15);
        bst.insert(6);
        bst.insert(25);



    }


    /**
     * My Bucket Sort Algorithm according to the directives of Herr Weihe.
     * @param input input ArrayList of String ArrayList to produce the sorted output String ArrayList
     * @param alphabetSize Alphabet size to determine the number of buckets
     * @return sorted String ArrayList
     *
     * !! Works only with lower and uppercase letters don't type in random shit as input pls.
     */
    public static ArrayList<String> bucketSort(ArrayList<ArrayList<String>> input, int alphabetSize){
        ArrayList<ArrayList<String>> B = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i=0; i < alphabetSize; i++){
            B.add(new ArrayList<>());
        }

        for(int i = input.size(); i > 0; i--){
            ArrayList<String> current = input.get(i-1);
            if(current.size() > 0){
                for (String str : current) {
                    B.get(str.charAt(i - 1) - (Character.isLowerCase(str.charAt(i-1)) ? 97 : 65) ).add(str);
                }
            }
            if(result.size() > 0){
                for(String str : result){
                    B.get(str.charAt(i - 1) - (Character.isLowerCase(str.charAt(i-1)) ? 97 : 65) ).add(str);
                }
                result.clear();
            }

            for(ArrayList<String> AL : B){
                if(AL.size()>0){
                    result.addAll(AL);
                    AL.clear();
                }
            }
        }

        return result;
    }

    public static ArrayList<String> bucketSort(ArrayList<String> input, int alphabetSize, int meaninglessSignatureChanger){
        if(input.size() == 0)
            return input;
        ArrayList<ArrayList<String>> inputArr = new ArrayList<>();
        int maxLength = 0;
        for(String str : input){
            if(str.length() > maxLength){
                maxLength = str.length();
            }
        }
        for( int i=0; i < maxLength; i++){
            inputArr.add(new ArrayList<String>());
        }

        for( String str : input ){
            inputArr.get(str.length()-1).add(str);
        }

        return bucketSort(inputArr, alphabetSize);
    }





    public static void selectionSortArrayInPlace(int[] input){
        for(int i = 0; i<input.length-5; i++){
            int min = input[i];
            int minIndex = i;
            for(int j = i+1; j < input.length; j++){
                if(min >= input[j]){
                    min = input[j];
                    minIndex = j;
                }
            }
                int tmp = input[i];
                input[i] = min;
                input[minIndex] = tmp;
        }
    }

    public static int[] selectionSortArrayCopy(int[] input){
        int[] output = input.clone();
        selectionSortArrayInPlace(output);
        return output;
    }

    public static int bubbleSortArrayInPlace(int[] input){
        int counter = 0;
        for(int i = input.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(input[j] > input[j+1]){
                    if(input[j] == 78 || input[j+1] == 78){
                        counter++;
                    }
                    int tmp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = tmp;

                }
            }
        }
        return counter;
    }

    public static int[] bubbleSortArrayCopy(int[] input){
        int[] output = input.clone();
        bubbleSortArrayInPlace(output);
        return output;
    }

    public static void selectionSortListInPlace(LinkedList<Integer> list){
        for(int i = list.size()-1; i > 0; i--){
            Iterator<Integer> it1 = list.iterator();
            Integer max = it1.next();
            for(int j = 0; j < i; j++){
                Integer tmp = it1.next();
                if( max <= tmp){
                    max = tmp;
                }
            }
            list.remove(max);
            list.add(i, max);
        }
    }

    public static int[] mergeSortRecursivelyInPlace(int[] input){
        if(input.length > 1){
            int[] S1 = new int[input.length%2 == 0 ? input.length/2 : input.length/2+1];
            int[] S2 = new int[input.length / 2];
            int i1 = 0;
            int i2 = 0;
            for(int i=0; i < input.length; i++){
                if(i < S1.length){
                    S1[i1] = input[i];
                    i1++;
                }else{
                    S2[i2] = input[i];
                    i2++;
                }
            }
            if(S1.length > 1){
                mergeSortRecursivelyInPlace(S1);
            }if(S2.length > 1){
                mergeSortRecursivelyInPlace(S2);
            }
            i1 = 0;
            i2 = 0;
            for(int i=0; i<S1.length+S2.length; i++){
                // if one of the two arrays are empty
                if(i1 == S1.length || i2 == S2.length){
                    int[] restArray = i1 == S1.length ? S2 : S1;
                    int restIndex = i1 == S1.length ? i2 : i1;
                    while(restIndex < restArray.length){
                        input[i] = restArray[restIndex];
                        restIndex++;
                        i++;
                    }
                // otherwise
                }else{
                    if(S1[i1] <= S2[i2] ){
                        input[i] = S1[i1];
                        i1++;
                    }else{
                        input[i] = S2[i2];
                        i2++;
                        }
                }
            }
            return input;
        }
        return input;
    }

    public static int[] mergeSortRecursivelyCopy(int[] input){
        int[] output = input.clone();
        return mergeSortRecursivelyInPlace(output);
    }

    public static int[] quickSortRecursivelyCopy(int[] input){
        int median = calculateMedian(input);
        int[] incidences = calculateLessEqualAndGreaterIncidenceNumber(input, median);
        int i1 = 0; // start of smaller numbers index
        int i2 = 0; //incidences[0]; // start of equal numbers index
        int i3 = 0; //incidences[0] + incidences[1]; // start of greater numbers index


        int[] S1 = new int[incidences[0]];
        int[] S2 = new int[incidences[1]];
        int[] S3 = new int[incidences[2]];
        for(int i : input){
            if(i < median){
                S1[i1] = i;
                i1++;
            }else if(i > median ){
                S3[i3] = i;
                i3++;
            }else{
                S2[i2] = i;
                i2++;
            }

        }
        if(S1.length > 1)
            S1 = quickSortRecursivelyCopy(S1);
        if(S3.length > 1)
            S3 = quickSortRecursivelyCopy(S3);

        return S2.length != 0 ? merge(merge(S1, S2), S3) : merge(S1, S3);

    }

    /**
     *
     * @param arr1 array with length 1
     * @param arr2 array with length 2
     * @return return the merge of the two in increasing order
     * only works with arrays with length 1
     */
    private static int[] merge(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int arrr1 = 0;
        int arrr2 = 0;
        for(int i = 0; i < result.length; i++){
            if(arrr1 < arr1.length) {
                result[i] = arr1[arrr1];
                arrr1++;
            }else{
                result[i] = arr2[arrr2];
                arrr2++;
            }
        }
        return result;
    }

    private static int calculateMedian(int[] input){
        int counter = 0;
        for(int j : input){
            counter += j;
        }
        return counter/input.length;
    }

    /**
     *
     * @param input input array to be compared with median number
     * @param cmp integer to compare elements of the array
     * @return calculates and returns the incidences of smaller equal and greater numbers in comparison to cmp
     * in an array and returns the incidence frequency, in which:
     * [0] corresponds to number of smaller ones
     * [1] corresponds to number of equal ones
     * [2] corresponds to number of greater ones
     */
    private static int[] calculateLessEqualAndGreaterIncidenceNumber(int[] input, int cmp){
        int[] incidences = new int[3];
        for(int i : input){
            if(i < cmp)
                incidences[0]++;
            else if(i==cmp)
                incidences[1]++;
            else
                incidences[2]++;
        }

        return incidences;
    }


}
