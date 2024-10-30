
class Node {
    int data;
    Node parent;
    Node left;
    Node right;
    int color;  // 1 -> Red, 0 -> Black

    public Node(int data) {
        this.data = data;
        this.color = 1; // New nodes are red by default
    }
}

class RedBlackTree {
    private final Node NIL = new Node(0); // NIL nodes are black
    private Node root;

    public RedBlackTree() {
        NIL.color = 0;
        NIL.left = null;
        NIL.right = null;
        root = NIL;
    }

    public void insert(int key) {
        Node node = new Node(key);
        node.parent = null;
        node.data = key;
        node.left = NIL;
        node.right = NIL;
        node.color = 1;

        Node parent = null;
        Node current = root;

        while (current != NIL) {
            parent = current;
            if (node.data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        node.parent = parent;
        if (parent == null) {
            root = node;
        } else if (node.data < parent.data) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        if (node.parent == null) {
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    private void fixInsert(Node node) {
        while (node.parent != null && node.parent.color == 1) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;

                if (uncle.color == 1) {
                    uncle.color = 0;
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    rightRotate(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (uncle.color == 1) {
                    uncle.color = 0;
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    leftRotate(node.parent.parent);
                }
            }
            if (node == root) {
                break;
            }
        }
        root.color = 0;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != NIL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void inorder() {
        inorderHelper(this.root);
        System.out.println();
    }

    private void inorderHelper(Node node) {
        if (node != NIL) {
            inorderHelper(node.left);
            System.out.print(node.data + " ");
            inorderHelper(node.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();

        // Example values for insertion
        int[] values = { 30, 20, 40, 50, 10, 25, 35 };
        for (int value : values) {
            rbt.insert(value);
        }

        System.out.println("Inorder Traversal of Created Tree:");
        rbt.inorder();
    }
}


/*
Output :

Inorder Traversal of Created Tree:
10 20 25 30 35 40 50 


*/