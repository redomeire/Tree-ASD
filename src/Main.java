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
        Node<String> nodeC = newTree.findNode(newTree.root, "C");

        // menelusuri node mulai dari root
        newTree.telusur(newTree.root);

        // mencari level dari suatu node, misalkan node K
        System.out.println("level of node K is "
                + newTree.calculateNodeLevel(newTree.root, "K", 1));

        // mencari height dari suatu node, misalkan node B
        System.out.println("height of node B is "
                + newTree.calculateNodeHeight(newTree.root, "B", 1));

        // mencari semua leaf node
        newTree.getAllLeafNode(newTree.root);

        // mencari semua non leaf node
        newTree.getAllNonLeafNode(newTree.root);

        // mencari sibling dari node
        System.out.println("\n======Sibling dari node=====\n");
        newTree.findSiblingOfNode(newTree.root, "C");

        // menemukan parent dari node
        newTree.getParentNode(newTree.root, "C");

        // menemukan ancestor dari node
        newTree.findAllNodeAncestors(newTree.root, "E");

    }
}
