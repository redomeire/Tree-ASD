public class Main {

    public static void main(String[] args) {
        // this is our tree
        Pohon<String> newTree = new Pohon<>("H");
        newTree.cantolin(newTree.root, new Node("D"));
        newTree.cantolin(newTree.root, new Node("K"));

        Node<String> nodeD = newTree.findNode(newTree.root, "D");

        if (nodeD != null) {
            newTree.cantolin(nodeD, new Node("F"));
            newTree.cantolin(nodeD, new Node("B"));
        }

        Node<String> nodeF = newTree.findNode(newTree.root, "F");

        if (nodeF != null) {
            newTree.cantolin(nodeF, new Node("G"));
            newTree.cantolin(nodeF, new Node("E"));
        }

        Node<String> nodeB = newTree.findNode(newTree.root, "B");

        if (nodeB != null) {
            newTree.cantolin(nodeB, new Node("A"));
            newTree.cantolin(nodeB, new Node("C"));
        }

        // node K
        Node<String> nodeK = newTree.findNode(newTree.root, "K");

        newTree.telusur(newTree.root);

        // mencari level dari suatu node, misalkan node B
        System.out.println("level of node b is "
                + newTree.calculateNodeLevel(newTree.root, nodeB));

//        System.out.println("height of node k is "
//                + newTree.calculateNodeHeight(newTree.root, nodeK));

        // mencari semua leaf node
        newTree.getAllLeafNode(newTree.root);

        // mencari semua non leaf node
        newTree.getAllNonLeafNode(newTree.root);

        // mencari semua node ancestor
//        newTree.findAllNodeAncestor(newTree.root, nodeF);

        newTree.findSiblingOfNode(newTree.root, "E");
    }
}
