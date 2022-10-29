import java.util.LinkedList;

public class Pohon<T> {
    Node root;

    public Pohon(Node root){
        this.root = root;
    }

    public Pohon (T data){
        this.root = new Node<T>(data);
    }

    public void telusur(Node<T> node){
        Node<T> currentNode = node == null ? this.root : node;

        System.out.println(currentNode.data);

        // menampilkan node node di bawahnya
        for (Node<T> childNode : currentNode.children) {
            telusur(childNode);
        }
    }

    public Node<T> cantolin(Node<T> parent, Node<T> child) {
        parent.children.add(child);
        return child;
    }

    public Node<T> findNode(Node<T> parent,T data){
        if(parent.data == data) return parent;

        for(Node<T> childNode : parent.children) {
            Node<T> tempNode = findNode(childNode, data);

            if(tempNode != null) return tempNode;
        }

        return null;
    }

    public Node<T> getParentNode(Node<T> parent, T data){

        Node<T> selectedNode = findNode(this.root, data);

        if(parent.children.contains(selectedNode)) return parent;

        for(Node<T> currentNode : parent.children) {
            Node<T> parentNode = getParentNode(currentNode, data);

            if(parentNode != null) return parentNode;
        }

        return null;
    }

    public int calculateNodeLevel(Node<T> parent, T data, int startCount){
        Node<T> ancestorNode = null;

        if(!data.equals(this.root.data)) ancestorNode = getParentNode(parent, data);

        if(ancestorNode != null) return calculateNodeLevel(this.root, ancestorNode.data, ++startCount);

        return startCount;
    }

    public void getAllLeafNode(Node<T> parentNode){
        LinkedList<Node> newLinked = new LinkedList<>();

        for(Node<T> currentNode : parentNode.children){
            if(currentNode.children.size() == 0) newLinked.add(currentNode);
            else getAllLeafNode(currentNode);
        }

        for(Node<T> current : newLinked) {
            System.out.println("leaf nodes are : " + current.data);
        }
    }

    public void getAllNonLeafNode(Node<T> parentNode){
        LinkedList<Node> currentLinkedList = new LinkedList<>();

        if(parentNode == this.root && this.root.children.size() != 0) {
            currentLinkedList.add(parentNode);
        }

        for(Node<T> currentNode : parentNode.children) {
            if(currentNode.children.size() != 0) {
                currentLinkedList.add(currentNode);
            }

            getAllNonLeafNode(currentNode);
        }

        for(Node<T> currentNode : currentLinkedList) {
            System.out.println("Non leaf nodes are : " + currentNode.data);
        }
    }

    public void findAllNodeAncestors(Node<T> parent, T data){
        Node<T> ancestorNode = null;

        if(!data.equals(this.root.data))
            ancestorNode = getParentNode(parent, data);

        if(ancestorNode != null) {
            System.out.println("Ancestors are : " + ancestorNode.data);
            findAllNodeAncestors(this.root, ancestorNode.data);
        }
    }

    public void findAllDescendantOfNode(Node<T> parent){
        if(parent != null) {
            for (Node<T> currentNode : parent.children) {
                System.out.println("descendants are : " + currentNode.data);
                findAllDescendantOfNode(currentNode);
            }
        } else
            System.out.println("parent cannot be null");
    }

    public void findSiblingOfNode(Node <T> parentNode, T data){
        LinkedList<Node> siblings = new LinkedList<>();

        for(Node<T> currentNode : parentNode.children) {
            if(currentNode.data == data) {
                siblings.addAll(parentNode.children);
                break;
            }

            else findSiblingOfNode(currentNode, data);
        }

        //mencetak sibling saja
        if(siblings.size() != 0) {
            for (Node sibling : siblings) {
                if (sibling.data != data) {
                    System.out.println("The sibling of node " + data + " is " + sibling.data);
                }
            }
        }
    }
}
