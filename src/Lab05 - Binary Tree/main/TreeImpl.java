package cz.cvut.fel.pjv;

public class TreeImpl implements Tree {
    private Node root;

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public void setTree(int[] values) {
        root = BuildTree(values, 0, values.length) ;
    }

    private Node BuildTree(int[] values, int first, int last) {
        if (first >= last) return null;

        int middleIndex = first + (last - first) / 2;
        NodeImpl node = new NodeImpl(values[middleIndex]);
        node.setLeft(BuildTree(values, first, middleIndex));
        node.setRight(BuildTree(values, middleIndex + 1, last));

        return node;
    }

    @Override
    public String toString() {
        return recursiveString(root, 0);
    }

    private String recursiveString(Node node, int level) {
        if (node == null) return "";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < level; i++) res.append(" ");

        res.append("- ").append(node.getValue()).append("\n");
        res.append(recursiveString(node.getLeft(), level + 1));
        res.append(recursiveString(node.getRight(), level + 1));
        return res.toString();
    }
}

