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


        //System.out.println("node parent yang dicari adalah : " + newTree.getParentNode(newTree.root, "C"));
//        newTree.getParentNode(newTree.root, "C");
//        newTree.getParentNode(newTree.root, "A");
//        newTree.getParentNode(newTree.root, "B");

//        System.out.println("level of node " + nodeB.data + " " + newTree.calculateNodeLevel(newTree.root, nodeB));
//        System.out.println("level of node " + nodeD.data + " " + newTree.calculateNodeHeight(newTree.root, nodeD));
//        newTree.calculateNodeHeight(newTree.root, nodeB);

        System.out.println("All leaf nodes are " + newTree.getAllLeafNode(newTree.root));
        System.out.println("All Non leaf nodes are " + newTree.getAllNonLeafNode(nodeK));

//        newTree.getParentNode(newTree.root, "C");
    }
}
