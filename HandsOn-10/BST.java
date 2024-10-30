
class BSTNode {
    int val;
    BSTNode left, right;

    public BSTNode(int item) {
        val = item;
        left = right = null;
    }
}

class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private BSTNode insertRec(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private BSTNode deleteRec(BSTNode root, int key) {
        if (root == null)
            return root;

        if (key < root.val)
            root.left = deleteRec(root.left, key);
        else if (key > root.val)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.val = minValue(root.right);
            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    private int minValue(BSTNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    public boolean search(int key) {
        return searchRec(root, key) != null;
    }

    private BSTNode searchRec(BSTNode root, int key) {
        if (root == null || root.val == key)
            return root;
        if (root.val < key)
            return searchRec(root.right, key);
        return searchRec(root.left, key);
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting example values
        int[] values = { 40, 20, 10, 30, 60, 50, 70 };
        for (int value : values) {
            bst.insert(value);
        }

        System.out.println("Inorder Traversal:");
        bst.inorder();

        // Delete a value
        bst.delete(40);
        System.out.println("Inorder Traversal after deleting 40:");
        bst.inorder();

        // Search for a value
        System.out.println("Search for 50: " + (bst.search(50) ? "Found" : "Not Found"));
        System.out.println("Search for 100: " + (bst.search(100) ? "Found" : "Not Found"));
    }
}


/*

Output :

Inorder Traversal:
10 20 30 40 50 60 70 
Inorder Traversal after deleting 40:
10 20 30 50 60 70 
Search for 50: Found
Search for 100: Not Found

*/