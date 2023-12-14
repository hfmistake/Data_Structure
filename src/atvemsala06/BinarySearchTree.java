package atvemsala06;


class Node {
    int data;

    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class BinarySearchTree {
    Node root;


    public void insert(Node newNode) {
        root = insertHelper(root, newNode);
    }

    private Node insertHelper(Node root, Node newNode) {
        int data = newNode.data;
        if (root == null) {
            root = newNode;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, newNode);
        } else {
            root.right = insertHelper(root.right, newNode);
        }
        return root;
    }

    // printer method to display the traversal in same line
    public void displayInOrder() {
        displayHelperInOrder(root);
    }

    private void displayHelperInOrder(Node root) {
        if (root != null) {
            displayHelperInOrder(root.left);
            System.out.print(root.data+" ");
            displayHelperInOrder(root.right);
        }
    }

    public void displayPostOrder() {
        displayHelperPostOrder(root);
    }

    private void displayHelperPostOrder(Node root) {
        if (root != null) {
            displayHelperPostOrder(root.left);
            displayHelperPostOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void displayPreOrder() {
        displayHelperPreOrder(root);
    }

    private void displayHelperPreOrder(Node root) {
        if (root != null) {
            System.out.print(root.data+" ");
            displayHelperPreOrder(root.left);
            displayHelperPreOrder(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (data < root.data) {
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }
    }

    public void remove(int data) {
        if (search(data)) {
            root = removeHelper(root, data);
        } else {
            System.out.println("Elemento não encontrado");
        }
    }

    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return null;
        } else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right == null) {
                root.data = sucessor(root);
                root.right = removeHelper(root.right, root.data);
            } else {
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int sucessor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
