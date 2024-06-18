public class Q3{
    public static void main(String[] args) {
        BST<Integer> binaryTree = new BST<>();

        Node<Integer> root = new Node<>(50);
        binaryTree.add(root, 32);
        binaryTree.add(root, 87);
        binaryTree.add(root, 45);
        binaryTree.add(root, 63);
        binaryTree.add(root, 64);
        binaryTree.add(root, 109);
        binaryTree.add(root, 98);
        binaryTree.add(root, 51);

        System.out.println("Da tree in order(ed by the Peaky Blinders):");
        binaryTree.printTreeInOrder();
        // binaryTree.inOrder(root);
        System.out.println();

        System.out.println("\nTree contains 50: " + binaryTree.contains(50));
        System.out.println("Tree contains 109: " + binaryTree.contains(109));
        System.out.println("Tree contains 69: " + binaryTree.contains(69));
    }
}