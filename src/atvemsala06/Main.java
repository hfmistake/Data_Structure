package atvemsala06;

public class Main {
    public static void main(String[] args) {
        // Optei por implementar uma árvore binária de busca
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(4));
        tree.insert(new Node(2));
        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(7));

        System.out.print("Em-ordem: ");
        tree.displayInOrder();
        System.out.println();
        System.out.print("Pós-ordem: ");
        tree.displayPostOrder();
        System.out.println();
        System.out.print("Pré-ordem: ");
        tree.displayPreOrder();
    }
}
