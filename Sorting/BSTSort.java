class BSTSort {
 private static BNode root = null ;

    public static void insert(int key) {
        BNode node = new BNode(key, null, null);
        BNode parent = root;
        if (parent == null) {
            root = node;
            return;
        }

        while (parent.leftChild != null || parent.rightChild
                != null) {
            if (node.key == parent.key) {
                throw new IllegalArgumentException("BST already contains element with key" +
                        node.key);
            } else if (node.key < parent.key && parent.
                    leftChild != null) {
                parent = parent.leftChild;
            } else if (node.key > parent.key && parent.
                    rightChild != null) {
                parent = parent.rightChild;
            } else {
                break;
            }
        }

        if (node.key < parent.key) parent.leftChild = node;
        else parent.rightChild = node;
    }
 }