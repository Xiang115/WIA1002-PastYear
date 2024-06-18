public class BST <E extends Comparable <E>> {
    Node<E> root;
    int size;

    public boolean add(Node<E> node, E item) {
        Node<E> newNode = new Node<>(item);
        if (root == null) {
            root = node;
            size++;
        }

        Node<E> parent = root;
        int cmp = 0;
        for (Node<E> current = root; current != null;) {
            if ((cmp = item.compareTo(current.e)) == 0)
                return false;
            parent = current;
            current = cmp > 0 ? current.right : current.left;
        }

        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

        size++;
        return true;
    }

    public void printTreeInOrder() {
        inOrder(root);
    }
        
   
    private void inOrder(Node<E> root2) {
        if (root2 != null) {
            inOrder(root2.left);
            System.out.print(root2.e + " ");
            inOrder(root2.right);
        }
    }

    public boolean contains(E item) {
        for(Node<E> node = root; node != null; ) {
            int cmp = item.compareTo(node.e);
            if(cmp == 0) return true;
            else node = cmp > 0 ? node.right : node.left;
        }
        return false;
    }

}
