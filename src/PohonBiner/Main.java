package PohonBiner;

public class Main {
    public static void main(String[] args) {
        PohonBiner<String> p = new PohonBiner("/");

        p.root.left = new Node<String>("*");
        p.root.left.left = new Node<String>("+");
        p.root.left.right = new Node<String>("-");

        p.root.left.left.left = new Node<String>("a");
        p.root.left.left.right = new Node<String>("b");

        p.root.left.right.left = new Node<String>("c");
        p.root.left.right.right = new Node<String>("d");

        p.root.right = new Node<String>("+");
        p.root.right.left = new Node<String>("e");
        p.root.right.right = new Node<String>("f");

        p.preOrder(p.root); System.out.println();
        p.inOrder(p.root); System.out.println();
        p.postOrder(p.root); System.out.println();

        p.levelOrder(p.root);
    }
}
