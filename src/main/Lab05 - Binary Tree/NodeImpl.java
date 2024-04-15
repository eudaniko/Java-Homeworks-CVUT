package cz.cvut.fel.pjv;

public class NodeImpl implements Node {
    private int value;
    private Node left;
    private Node right;

    public NodeImpl(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
