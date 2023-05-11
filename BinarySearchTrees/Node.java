package h00;

import java.util.ArrayList;
import java.util.Stack;

public class Node {
    Integer value;
    Node right;
    Node left;


    public Node(Integer value){
        this.value = value;
        right = null;
        left = null;
    }


    public void setRight(Integer value) {
        this.right = new Node(value);
    }

    public void setLeft(Integer value){
        this.left = new Node(value);
    }

    public void setValue(Integer value){
        this.value = value;
    }

    public static ArrayList<Integer> alternateTraverse(Node node){
        ArrayList<Integer> stack = new ArrayList<>();
        return recursiveBranching(node, stack);
    }

    private static ArrayList<Integer> recursiveBranching(Node node, ArrayList<Integer> stack){
        if(node.left != null)
            stack = recursiveBranching(node.left, stack);
        stack.add(node.value);
        if(node.right != null)
            stack = recursiveBranching(node.right, stack);
        return stack;
    }


    public ArrayList<Integer> traverseTree(){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{this.value, 0});
        Node p = this;
        while(!stack.empty()){
            if(stack.peek()[1] == 0){
                if(p.left != null){
                    stack.push(new Integer[]{p.left.value, 0});
                    p = p.left;
                }else{
                    stack.peek()[1]++;
                }
            }else if(stack.peek()[1] == 1){
                result.add(stack.peek()[0]);
                if(p.right != null){
                    stack.push(new Integer[]{p.right.value, 0});
                    p = p.right;
                }else{
                    stack.peek()[1]++;
                }
            }else if(stack.peek()[1] == 2){
                stack.pop();
                if(!stack.empty()){
                    p = findPredecessor(this, p.value);
                    stack.peek()[1]++;
                }
            }
        }
        return result;
    }

    private static Integer[] arrayCreator(Node node) {
        return new Integer[]{node.value, 0};
    }

    public boolean findElement(Integer value){
        if(value.equals(this.value))
            return true;
        Node p = this;
        while(!value.equals(p.value)){
            if(value <= p.value){
                if(p.left == null){
                    return false;
                }
                p = p.left;
            }else{
                if(p.right == null){
                    return false;
                }
                p = p.right;
            }
        }
        return true;
    }

    /**
     *
     * @param value value to be added to the tree to the appropriate position
     * @return added value, namely the parameter
     */
    public Integer insert(Integer value){
        Node p = this;
        while(true){
            if(value <= p.value && p.left == null){
                p.setLeft(value);
                break;
            }else if(value > p.value && p.right == null){
                p.setRight(value);
                break;
            }

            if(value <= p.value){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        return value;
    }

    public static Node findExact(Node node, Integer value){
        if(!node.findElement(value)){
            return null;
        }
        Node p = node;
        while(!p.value.equals(value)){
            if(value <= p.value){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        return p;
    }

    public static Node findPredecessor(Node node, Integer value){
        if(!node.findElement(value)){
            return null;
        }
        Node p = node;
        while(!((p.left != null && p.left.value.equals(value)) || (p.right != null && p.right.value.equals(value))) ){
            if(value <= p.value){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        return p;
    }

    /**
     *
     * @param value value to be removed
     * @return true if an element was removed, false if not
     */
    public static boolean removeElement(Node node, Integer value){
        if(!node.findElement(value)){
            return false;
        }
        // wurzel is to be removed
        if(node.value.equals(value)){
            if(node.numberOfKids() == 0){
                node = null;
                return true;
            }else if(node.numberOfKids() == 1){
                if(node.left != null){
                    node = node.left;
                }else{
                    node = node.right;
                }
                return true;
            }else if (node.numberOfKids() == 2){
                removeMethod(node, value, 2);
            }
            return true;
        }
        if(findExact(node, value).numberOfKids() != 2){
            Node p = findPredecessor(node, value);
            removeMethod(p, value, findExact(node, value).numberOfKids());
        }else{
            Node p = findExact(node, value);
            removeMethod(p, value, p.numberOfKids());
        }
        return true;

    }

    /**
     *
     * @param p either value's node or its predecessor in the cases of number of kids being 0 or 1
     * @param value to be removed
     * @param numberOfKids element to be removed has
     * @return removed value
     */
    private static Integer removeMethod(Node p,Integer value, int numberOfKids){
        if(numberOfKids == 0){
            if(p.left.value.equals(value)){
                p.left = null;
            }else{
                p.right = null;
            }
        }else if(numberOfKids == 1){
            if(p.left.value.equals(value)){
                if(p.left.left != null){
                    p.left = p.left.left;
                }else{
                    p.left = p.left.right;
                }
            }else{
                if(p.right.left != null){
                    p.right = p.right.left;
                }else{
                    p.right = p.right.right;
                }
            }
        }else if(numberOfKids == 2){
            Node p2 = p;
            if(p2.left != null && p2.left.right != null){
                p2 = p2.left;
                while(p2.right.right != null){
                    p2 = p2.right;
                }
                p.setValue(p2.right.value);
                if(p2.right.numberOfKids() == 1){
                    p2.right = p2.right.left;
                }else{
                    p2.right = null;
                }
            }else if(p2.left != null){
                p.setValue(p.left.value);
                if(p2.left.numberOfKids() == 1){
                    p.left = p.left.left;
                }else{
                    p.left = null;
                }
            }else if(p.right != null && p.right.left != null){
                p2 = p.right;
                while(p2.left.left != null){
                    p2 = p2.left;
                }p.setValue(p2.left.value);
                if(p2.left.numberOfKids() == 1){
                    p2.left = p2.left.right;
                }else{
                    p2.left = null;
                }
            }else if(p.right != null){
                p.setValue(p.right.value);
                p.right = p.right.right;
            }
        }
        return value;
    }



    public int numberOfKids(){
        if(this.left == null && this.right == null){
            return 0;
        }else if(this.left == null || this.right == null){
            return 1;
        }else{
            return 2;
        }
    }
}
