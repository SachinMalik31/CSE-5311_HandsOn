class Node {
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Search for a node by key
    public Node listSearch(int key) {
        Node current = head;
        while (current != null && current.key != key) {
            current = current.next;
        }
        return current;
    }

    // Insert a new node at the beginning
    public void listInsert(int key) {
        Node newNode = new Node(key);
        newNode.next = head;
        head = newNode;
    }

    // Delete a node by key
    public void listDelete(int key) {
        Node current = head;
        Node previous = null;

        // If the head node itself holds the key to be deleted
        if (current != null && current.key == key) {
            head = current.next;
            return;
        }

        // Search for the key to be deleted, keep track of the previous node
        while (current != null && current.key != key) {
            previous = current;
            current = current.next;
        }

        // If the key was not present in the list
        if (current == null) return;

        // Unlink the node from the linked list
        previous.next = current.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.listInsert(70);
        list.listInsert(80);
        list.listInsert(90);

        Node found = list.listSearch(80);
        if (found != null) {
            System.out.println("Found element: " + found.key);
        } else {
            System.out.println("Element not found");
        }

        list.listDelete(80);
        found = list.listSearch(80);
        if (found == null) {
            System.out.println("Element 80 successfully deleted");
        } else {
            System.out.println("Element 80 still present");
        }
    }
}


/*
Output : 
Found element: 80
Element 80 successfully deleted
*/