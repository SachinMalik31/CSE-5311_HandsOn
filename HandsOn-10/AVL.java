
class AVLNode {
    int val, height;
    AVLNode left, right;

    AVLNode(int d) {
        val = d;
        height = 1;
    }
}

class AVLTree {
    private int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public AVLNode insert(AVLNode node, int key) {
        if (node == null)
            return new AVLNode(key);

        if (key < node.val)
            node.left = insert(node.left, key);
        else if (key > node.val)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Left Left
        if (balance > 1 && key < node.left.val)
            return rightRotate(node);

        // Right Right
        if (balance < -1 && key > node.right.val)
            return leftRotate(node);

        // Left Right
        if (balance > 1 && key > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left
        if (balance < -1 && key < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public AVLNode delete(AVLNode root, int key) {
        if (root == null)
            return root;

        if (key < root.val)
            root.left = delete(root.left, key);
        else if (key > root.val)
            root.right = delete(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = (root.left != null) ? root.left : root.right;
                root = (temp != null) ? temp : null;
            } else {
                AVLNode temp = minValueNode(root.right);
                root.val = temp.val;
                root.right = delete(root.right, temp.val);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        // Left Left
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Right Right
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Left Right
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public void inorderTraversal(AVLNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        AVLNode root = null;

        // Inserting example values
        int[] values = { 15, 10, 20, 8, 12, 16, 25 };
        for (int value : values) {
            root = tree.insert(root, value);
        }

        System.out.println("Inorder traversal of the constructed AVL tree is:");
        tree.inorderTraversal(root);

        // Deleting a value
        root = tree.delete(root, 10);
        System.out.println("\nInorder traversal after deletion of 10:");
        tree.inorderTraversal(root);
    }
}


/* 
Output :

Inorder traversal of the constructed AVL tree is:
8 10 12 15 16 20 25 
Inorder traversal after deletion of 10:
8 12 15 16 20 25 

*/