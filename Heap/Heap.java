import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<K> {
    public int[] IDs = new int[10];
    public K[] keys = (K[]) new Object[10];
    public int[] positions = new int[10];
    private final Comparator<K> cmp;
    int numberOfOccupied = 0;
    int currentID = 0;

    public Heap(K key, Comparator<K> cmp){
        IDs[0] = currentID;
        keys[0] = key;
        positions[0] = currentID;
        this.cmp = cmp;
        numberOfOccupied++;
        currentID++;
    }

    public void expandIfPositionsFull(){
        if(currentID == positions.length -1){
            positions = Arrays.copyOf(positions, positions.length * 2);
        }
    }
    public void expandIfFull(){
        if(this.numberOfOccupied == IDs.length-1){
            IDs = Arrays.copyOf(IDs, IDs.length * 2);
            keys = Arrays.copyOf(keys, keys.length * 2);
        }
    }


    public boolean hasParent(int i){
        return (i < numberOfOccupied) && (i > 0);
    }

    public boolean hasLeftChild(int i){
        return i >= 0 && (i < numberOfOccupied && getLeftChildIndex(i) < numberOfOccupied);
    }

    public boolean hasRightChild(int i){
        return i >= 0 && ( i < numberOfOccupied && getRightChildIndex(i) < numberOfOccupied);
    }




    public int getParentIndex(int index){
        return index > 0 ? (index-1) / 2 : -1;
    }

    public int getLeftChildIndex(int index){
        return index * 2 +1;
    }

    public int getRightChildIndex(int index){
        return index * 2 + 2;
    }



    public K getParent(int i){
        return hasParent(i) ? keys[getParentIndex(i)] : null;
    }

    public K getLeftChild(int i){
        return hasLeftChild(i) ? keys[getLeftChildIndex(i)] : null;
    }

    public K getRightChild(int i){
        return hasRightChild(i) ? keys[getRightChildIndex(i)] : null;
    }

    public int add(K key){
        if(key == null)
            return Integer.MAX_VALUE;
        expandIfPositionsFull();
        expandIfFull();
        keys[numberOfOccupied] = key;
        IDs[numberOfOccupied] = currentID;
        positions[currentID] = numberOfOccupied;
        currentID++;
        heapifyUp(numberOfOccupied++);
        return currentID-1;
    }

    public void heapifyDown(int i){
        while(true){
            if(!hasLeftChild(i))
                return;
            int smallerChildIndex = hasRightChild(i) && cmp.compare(getRightChild(i), getLeftChild(i)) < 0 ? getRightChildIndex(i)
                    : getLeftChildIndex(i);
            if(cmp.compare(keys[i], keys[smallerChildIndex]) < 0)
                return;
            swap(i, smallerChildIndex);
            i = smallerChildIndex;
        }

    }

    public void heapifyUp(int i){
        K current = keys[i];
        while(hasParent(i)){
            if(cmp.compare(current, getParent(i)) >= 0)
                break;
            swap(i, getParentIndex(i));
            i = getParentIndex(i);
            current = keys[i];
        }
    }

    public void swap(int i, int j){
        if(i < 0 || j < 0 || i >= numberOfOccupied || j >= numberOfOccupied)
            return;
        K tmp1 = keys[i];
        int tmp2 = positions[IDs[i]];
        int tmp3 = IDs[i];
        keys[i] = keys[j];
        keys[j] = tmp1;
        positions[IDs[i]] = positions[IDs[j]];
        positions[IDs[j]] = tmp2;
        IDs[i] = IDs[j];
        IDs[j] = tmp3;
    }


    public K extractMin(){
        if(numberOfOccupied <= 0){
            throw new NoSuchElementException("they are all gone bro whaddaya doin");
        }
        K tmpK = keys[0];
        swap(numberOfOccupied-1, 0);
        keys[--numberOfOccupied] = null;
        positions[IDs[numberOfOccupied]] = -1;
        IDs[numberOfOccupied] = -1;
        heapifyDown(0);
        return tmpK;
    }

    public void modifyKey(int ID, K desired){
        this.keys[positions[ID]] = desired;
        heapifyUp(positions[ID]);
        heapifyDown(positions[ID]);
    }

    public boolean hasAnyElements(){
        return numberOfOccupied > 0;
    }

}
