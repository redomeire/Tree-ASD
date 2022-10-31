package PohonBiner;

import java.util.LinkedList;
import java.util.Queue;

public class PohonBiner<T> {
    Node<T> root;

    public PohonBiner(T data){
        this.root = new Node<T>(data);
    }

    public void preOrder(Node<T> node){
        if(node == null) return;

        if(node.data != null)System.out.printf("%3s", node.data);

        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node<T> node){
        if(node == null) return;

        if(node.left != null) inOrder(node.left);
        System.out.printf("%3s", node.data);
        if(node.right != null) inOrder(node.right);
    }

    public void postOrder(Node<T> node){
        if(node == null) return;

        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);

        System.out.printf("%3s", node.data);
    }

    public void levelOrder(Node<T> node){
        Queue<Node<T>> q = new LinkedList<>();
        q.add(node);

        while(q.peek() != null) {
            Node<T> n = q.poll();
            System.out.printf("%3s", n.data);
            if(n.left != null) q.add(n.left);
            if(n.right != null) q.add(n.right);
        }

    }
}
