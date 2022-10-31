package Pohon;

import java.util.LinkedList;
import java.util.List;

public class NodePohon<T> {
    T data;
    List<NodePohon> children;

    public NodePohon(T data){
        this.data = data;
        this.children = new LinkedList<NodePohon>();
    }
}