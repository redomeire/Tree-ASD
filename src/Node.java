import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    T data;
    List<Node> children;

    public Node(T data){
        this.data = data;
        this.children = new LinkedList<Node>();
    }
}