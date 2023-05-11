package h00;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

import static h00.Node.*;

public class Main <T> {
    public static void main(String[] args){
        Node wurzel = initializeTree();
        System.out.println("Version 1: ");
        for(Integer i : wurzel.traverseTree())
            System.out.print(i + " ");
        System.out.println("\n \nVersion 2: ");
        Node wurzel2 = initializeTree();
        for(Integer i : alternateTraverse(wurzel2))
            System.out.print(i + " ");
        /*   element with no kids


        p = findExact(wurzel, 11);
        System.out.println(p.left.value);
        Node.removeElement(7, wurzel);
        p = findExact(wurzel,11);
        System.out.println(p.left.value);

         */

        /* Element with 1 kid (11)
        p = findPredecessor(wurzel, 11);
        System.out.println(p.value);
        System.out.println(p.left.value);
        removeElement(wurzel, 11);
        System.out.println(wurzel.findElement(11));
        p = findExact(wurzel, 25);
        System.out.println(p.left.value);

         */

        /* Element with 1 kid test #2

        p = findPredecessor(wurzel, 54);
        System.out.println(p.value);
        System.out.println(p.left.value);
        System.out.println(p.right.value);
        removeElement(wurzel, 54);
        p = findExact(wurzel,69);
        System.out.println(p.left.value);
        System.out.println(p.right.value);
         */

        /* removal of the root. seems to be working : )

        System.out.println(wurzel.value);
        removeElement(wurzel, 43);
        System.out.println(wurzel.value);
        System.out.println(wurzel.left.value);
        System.out.println(wurzel.right.value);
         */

        /* Element with 2 kids

        p = findExact(wurzel, 76);
        System.out.println(p.value);
        System.out.println(p.left.value);
        System.out.println(p.right.value);
        removeElement(wurzel, 76);
        System.out.println(p.value);
        System.out.println(findPredecessor(wurzel, 71).value);
        System.out.println(p.right.value);

         */
        /* Element with 2 kids, also last element to be exchanged with the root has one kid

        p = findPredecessor(wurzel, 39);
        System.out.println(p.right.value);
        System.out.println(p.right.left.value);
        removeElement(wurzel, 43);
        p = findExact(wurzel, 39);
        System.out.println(p.value);
        System.out.println(p.left.value);
        System.out.println(p.left.right.value);
        System.out.println(p.left.right.left.value);
        System.out.println(p.left.right.right.value);

         */



    }
    public static Node initializeTree() {
        Node wurzel = new Node(43);
        wurzel.setLeft(25);
        Node p = wurzel.left;
        p.setLeft(11);
        p = p.left;
        p.setLeft(7);
        p = wurzel.left;
        p.setRight(31);
        p = p.right;
        p.setLeft(28);
        p.setRight(39);
        wurzel.setRight(69);
        p = wurzel.right;
        p.setLeft(54);
        p.setRight(76);
        p.left.setRight(66);
        p = p.right;
        p.setLeft(71);
        p.setRight(99);
        p = findExact(wurzel, 39);
        p.setLeft(36);
        return wurzel;
    }

}
