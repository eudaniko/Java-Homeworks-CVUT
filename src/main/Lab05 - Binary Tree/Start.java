package cz.cvut.fel.pjv;

public class Start {
    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl();
        int[] array = {1, 2, 3, 4, 5};
        tree.setTree(array);
        System.out.println(tree.toString());
    }
}

