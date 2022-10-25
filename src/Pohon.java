import java.util.LinkedList;

public class Pohon<T> {
    Node root;
    int level;
    int height = this.level;

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

    public void getParentNode(Node<T> parent, T data){
        Node<T> current = parent.children == null ? this.root : parent;

        for(Node<T> currentNode : current.children) {
            if(currentNode.data == data) {
                System.out.println("parent : " + parent.data);
                break;
            }

            else getParentNode(currentNode, data);
        }
    }

//    public int calculateNodeHeight(Node<T> parent, Node<T> currentNode){
//        int counter = this.level;
//
//        for(Node<T> current : parent.children) {
//            counter--;
//
//            if(currentNode.data == current.data) {
//                this.height = counter;
//                break;
//            }
//
//            else calculateNodeHeight(current, currentNode);
//        }
//
//        return this.height;
//    }

    public int calculateNodeLevel(Node<T> parent, Node<T> currentNode){
        int counter = 1;

        for(Node<T> current : parent.children) {
            counter++;

            if(currentNode.data == current.data) {
                this.level = counter;
                break;
            }

            calculateNodeLevel(current, currentNode);
        }

        return counter;
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

//    public void findAllNodeAncestor(Node<T> parentNode, Node<T> searchedNode){
//        LinkedList<Node> path = new LinkedList<>();
//        path.add(this.root);
//
//        for(Node<T> currentNode : parentNode.children) {
//            path.add(currentNode);
//            if(currentNode.children.contains(searchedNode)) {
//                path.add(searchedNode);
//                break;
//            }
//
//        }
//
//        if(!path.contains(searchedNode))
//            System.out.println("Tree does not contain searched data!");
//
//        for (Node node : path) {
//            System.out.println("path node adalah : " + node.data);
//        }
//    }

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
        for (Node sibling : siblings) {
            if (sibling.data != data) {
                System.out.println("The sibling of node " + data + " is " + sibling.data);
            }
        }
    }
}
