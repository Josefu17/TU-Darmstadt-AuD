public class Main {
    public static void main(String[] args){
        //generateHeap();
        testInsert();
        testExtractMin();
        testDecreaseKey();
        ultimateTest();
        extractMin();


    }

    static Heap<Integer> generateHeap(){
        Heap<Integer> myHeap = new Heap<>(7, new MyComparator());
        System.out.println("Added ID: " + myHeap.add(11));
        myHeap.add(31);
        myHeap.add(28);
        myHeap.add(39);
        myHeap.add(54);
        myHeap.add(76);
        myHeap.add(43);
        myHeap.add(32);
        myHeap.add(40);
        return myHeap;
    }

    static void testInsert(){
        Heap<Integer> myHeap = generateHeap();
        myHeap.add(6);
    }

    static void testExtractMin(){
        Heap<Integer> myHeap = generateHeap();
        myHeap.extractMin();
    }

    static void testDecreaseKey(){
        Heap<Integer> myHeap = generateHeap();
        myHeap.modifyKey(8, 12);
    }

    static void ultimateTest(){
        Heap<Integer> myHeap = generateHeap();
        myHeap.add(13);
        myHeap.add(24);
        myHeap.extractMin();
        myHeap.add(1);
        myHeap.extractMin();
        myHeap.modifyKey(6, 12);
        myHeap.add((int)'b');
        myHeap.extractMin();
        myHeap.add(45);
        myHeap.add(45);
        myHeap.add(39);
        myHeap.add(45);
        myHeap.modifyKey(4, 100);
        while(myHeap.hasAnyElements()){
            myHeap.extractMin();
        }
    }

    static void extractMin(){
        Heap<Integer> myHeap = generateHeap();
        for(int i = 0; i < 9; i++){
            System.out.println("Extracted: " + myHeap.extractMin());
        }
    }
}
