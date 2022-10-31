package Pohon;

import java.util.LinkedList;

public class Pohon<T> {
    NodePohon root;

    public Pohon(NodePohon root){
        this.root = root;
    }

    public Pohon (T data){
        this.root = new NodePohon<T>(data);
    }

    public void telusur(NodePohon<T> nodePohon){
        NodePohon<T> currentNodePohon = nodePohon == null ? this.root : nodePohon;

        System.out.println(currentNodePohon.data);

        // menampilkan node node di bawahnya
        for (NodePohon<T> childNodePohon : currentNodePohon.children) {
            telusur(childNodePohon);
        }
    }

    public NodePohon<T> cantolin(NodePohon<T> parent, NodePohon<T> child) {
        parent.children.add(child);
        return child;
    }

    public NodePohon<T> findNode(NodePohon<T> parent, T data){
        if(parent.data == data) return parent;

        for(NodePohon<T> childNodePohon : parent.children) {
            NodePohon<T> tempNodePohon = findNode(childNodePohon, data);

            if(tempNodePohon != null) return tempNodePohon;
        }

        return null;
    }

    public NodePohon<T> getParentNode(NodePohon<T> parent, T data){

        NodePohon<T> selectedNodePohon = findNode(this.root, data);

        if(parent.children.contains(selectedNodePohon)) return parent;

        for(NodePohon<T> currentNodePohon : parent.children) {
            NodePohon<T> parentNodePohon = getParentNode(currentNodePohon, data);

            if(parentNodePohon != null) return parentNodePohon;
        }

        return null;
    }

    public int calculateNodeLevel(NodePohon<T> parent, T data, int startCount){
        NodePohon<T> ancestorNodePohon = null;

        if(!data.equals(this.root.data)) ancestorNodePohon = getParentNode(parent, data);

        if(ancestorNodePohon != null) return calculateNodeLevel(this.root, ancestorNodePohon.data, ++startCount);

        return startCount;
    }

    public void getAllLeafNode(NodePohon<T> parentNodePohon){
        LinkedList<NodePohon> newLinked = new LinkedList<>();

        for(NodePohon<T> currentNodePohon : parentNodePohon.children){
            if(currentNodePohon.children.size() == 0) newLinked.add(currentNodePohon);
            else getAllLeafNode(currentNodePohon);
        }

        for(NodePohon<T> current : newLinked) {
            System.out.println("leaf nodes are : " + current.data);
        }
    }

    public void getAllNonLeafNode(NodePohon<T> parentNodePohon){
        LinkedList<NodePohon> currentLinkedList = new LinkedList<>();

        if(parentNodePohon == this.root && this.root.children.size() != 0) {
            currentLinkedList.add(parentNodePohon);
        }

        for(NodePohon<T> currentNodePohon : parentNodePohon.children) {
            if(currentNodePohon.children.size() != 0) {
                currentLinkedList.add(currentNodePohon);
            }

            getAllNonLeafNode(currentNodePohon);
        }

        for(NodePohon<T> currentNodePohon : currentLinkedList) {
            System.out.println("Non leaf nodes are : " + currentNodePohon.data);
        }
    }

    public void findAllNodeAncestors(NodePohon<T> parent, T data){
        NodePohon<T> ancestorNodePohon = null;

        if(!data.equals(this.root.data))
            ancestorNodePohon = getParentNode(parent, data);

        if(ancestorNodePohon != null) {
            System.out.println("Ancestors are : " + ancestorNodePohon.data);
            findAllNodeAncestors(this.root, ancestorNodePohon.data);
        }
    }

    public void findAllDescendantOfNode(NodePohon<T> parent){
        if(parent != null) {
            for (NodePohon<T> currentNodePohon : parent.children) {
                System.out.println("descendants are : " + currentNodePohon.data);
                findAllDescendantOfNode(currentNodePohon);
            }
        } else
            System.out.println("parent cannot be null");
    }

    public void findSiblingOfNode(NodePohon<T> parentNodePohon, T data){
        LinkedList<NodePohon> siblings = new LinkedList<>();

        for(NodePohon<T> currentNodePohon : parentNodePohon.children) {
            if(currentNodePohon.data == data) {
                siblings.addAll(parentNodePohon.children);
                break;
            }

            else findSiblingOfNode(currentNodePohon, data);
        }

        //mencetak sibling saja
        if(siblings.size() != 0) {
            for (NodePohon sibling : siblings) {
                if (sibling.data != data) {
                    System.out.println("The sibling of node " + data + " is " + sibling.data);
                }
            }
        }
    }
}
