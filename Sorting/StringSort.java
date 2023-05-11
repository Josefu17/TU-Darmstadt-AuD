class StringSort {
 private static StringNode start = null ;

    public static void insert(String str) {
        StringNode n = new StringNode(str, null);
        StringNode pred = null, succ = start;

        while (succ != null && (n.str.compareTo(succ.str) >
                0)) {
            pred = succ;
            succ = succ.next;
        }

        if (pred == null) start = n;
        else pred.next = n;

        n.next = succ;
    }
}