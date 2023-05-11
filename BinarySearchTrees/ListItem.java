package h00;


public class ListItem <T> {
    T key;
    ListItem<T> next;



    public static ListItem<Integer> makeAscending(ListItem<Integer> list){
        if ( list == null )
            return null;
        ListItem<Integer> head = new ListItem<>();
        head.key = list.key;
        ListItem<Integer> tail = head;
        Integer delta = 0;
        for ( ListItem<Integer> p = list; p != null; p = p.next ) {
            tail.key = p.key + delta;
            if (p.next != null && p.next.key < p.key) {
                delta += p.key - p.next.key;
            }
            if(p.next != null){
                tail.next = new ListItem<>();
                tail = tail.next;
            }
        }
        return head;
    }


    public ListItem<Integer> initialize(){
        ListItem<Integer> head = new ListItem<>();
        head.key = 5;
        head.next = new ListItem<>();
        head.next.key = 2;
        head.next.next = new ListItem<>();
        head.next.next.key = 8;
        head.next.next.next = new ListItem<>();
        head.next.next.next.key = 6;
        return head;
    }
}