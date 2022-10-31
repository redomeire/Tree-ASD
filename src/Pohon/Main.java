package Pohon;// Muchammad Saifurrijaal - 215150701111006
// Redomeire - 215150701111032

public class Main {

    public static void main(String[] args) {
        // this is our tree
        Pohon<String> newTree = new Pohon<>("H");
        newTree.cantolin(newTree.root, new NodePohon("D"));
        newTree.cantolin(newTree.root, new NodePohon("K"));

        NodePohon<String> nodePohonD = newTree.findNode(newTree.root, "D");

        if (nodePohonD != null) {
            newTree.cantolin(nodePohonD, new NodePohon("F"));
            newTree.cantolin(nodePohonD, new NodePohon("B"));
        }

        NodePohon<String> nodePohonF = newTree.findNode(newTree.root, "F");

        if (nodePohonF != null) {
            newTree.cantolin(nodePohonF, new NodePohon("G"));
            newTree.cantolin(nodePohonF, new NodePohon("E"));
        }

        NodePohon<String> nodePohonB = newTree.findNode(newTree.root, "B");

        if (nodePohonB != null) {
            newTree.cantolin(nodePohonB, new NodePohon("A"));
            newTree.cantolin(nodePohonB, new NodePohon("C"));
        }

        // node K
        NodePohon<String> nodePohonK = newTree.findNode(newTree.root, "K");
        NodePohon<String> nodePohonC = newTree.findNode(newTree.root, "C");

        // menelusuri node mulai dari root
        System.out.println("========== MENELUSURI NODE ==========");
        newTree.telusur(newTree.root);

        // mencari level dari suatu node, misalkan node K
        System.out.println("\n\n===== MENCARI LEVEL SEBUAH NODE =====");
        System.out.println("Level of node K is "
                + newTree.calculateNodeLevel(newTree.root, "K", 1));

        // mencari semua leaf node
        System.out.println("\n============= LEAF NODE =============");
        newTree.getAllLeafNode(newTree.root);

        // mencari semua non leaf node
        System.out.println("\n============ NON LEAF NODE ===========");
        newTree.getAllNonLeafNode(newTree.root);

        // mencari sibling dari node
        System.out.println("\n===== SIBLING DARI SEBUAH NODE =====");
        newTree.findSiblingOfNode(newTree.root, "C");

        // menemukan ancestor dari node
        System.out.println("\n==== MENCARI ANCESTORE DARI NODE ====");
        System.out.println("Ancestor dari node " + nodePohonC.data);
        newTree.findAllNodeAncestors(newTree.root, nodePohonC.data);

        // menemukan parent dari node
        System.out.println("\n========== PARENT OF NODE ===========");
        System.out.print("Parent dari node " + nodePohonC.data + " : ");
        System.out.println(newTree.getParentNode(newTree.root, nodePohonC.data).data);

        // menemukan descendants dari node
        System.out.println("\n\n=== MENCARI DESCENDANTS DARI NODE ===");
        System.out.println("Descendants dari node " + nodePohonB.data);
        newTree.findAllDescendantOfNode(nodePohonB);
    }
}
