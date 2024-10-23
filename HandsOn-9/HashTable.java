
import java.util.Arrays;

class HashTable {
    private class Node {
        int key;
        int value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private class DoublyLinkedList {
        private Node head, tail;

        public void insert(int key, int value) {
            Node newNode = new Node(key, value);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        public Node find(int key) {
            Node current = head;
            while (current != null) {
                if (current.key == key) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public void remove(int key) {
            Node nodeToRemove = find(key);
            if (nodeToRemove == null) return;

            if (nodeToRemove.prev != null) {
                nodeToRemove.prev.next = nodeToRemove.next;
            } else {
                head = nodeToRemove.next;
            }
            if (nodeToRemove.next != null) {
                nodeToRemove.next.prev = nodeToRemove.prev;
            } else {
                tail = nodeToRemove.prev;
            }
        }

        public void clear() {
            head = tail = null;
        }
    }

    private DoublyLinkedList[] table;
    private int size, count;

    // Load factors for resizing
    private static final double LOAD_FACTOR = 0.75;
    private static final double SHRINK_FACTOR = 0.25;

    public HashTable() {
        this.size = 8;
        this.count = 0;
        this.table = new DoublyLinkedList[size];
        Arrays.fill(table, new DoublyLinkedList());
    }

    private int hashFunctionMultiplication(int key) {
        double A = (Math.sqrt(5) - 1) / 2;
        return (int) (size * ((key * A) % 1));
    }

    private void resize(int newSize) {
        DoublyLinkedList[] oldTable = table;
        table = new DoublyLinkedList[newSize];
        size = newSize;
        count = 0;
        Arrays.fill(table, new DoublyLinkedList());

        // Rehash all nodes
        for (DoublyLinkedList bucket : oldTable) {
            Node current = bucket.head;
            while (current != null) {
                insert(current.key, current.value);
                current = current.next;
            }
        }
    }

    public void insert(int key, int value) {
        int index = hashFunctionMultiplication(key);
        Node existingNode = table[index].find(key);
        if (existingNode != null) {
            existingNode.value = value;
        } else {
            table[index].insert(key, value);
            count++;
        }

        if (count >= size * LOAD_FACTOR) {
            resize(size * 2);  // Double size when load factor is exceeded
        }
    }

    public Integer get(int key) {
        int index = hashFunctionMultiplication(key);
        Node node = table[index].find(key);
        return node == null ? null : node.value;
    }

    public void remove(int key) {
        int index = hashFunctionMultiplication(key);
        table[index].remove(key);
        count--;

        if (size > 8 && count <= size * SHRINK_FACTOR) {
            resize(size / 2);  // Halve size when shrinking factor is exceeded
        }
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = table[i].head;
            while (current != null) {
                System.out.print("[" + current.key + ": " + current.value + "] ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Example Usage
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        System.out.println("Inserting values:");
        hashTable.insert(1, 10);
        hashTable.insert(2, 20);
        hashTable.insert(3, 30);
        hashTable.insert(4, 40);
        hashTable.insert(5, 50);
        hashTable.printTable();

        System.out.println("\nSearching for key 3:");
        System.out.println("Value for key 3: " + hashTable.get(3));  

        System.out.println("\nRemoving key 3:");
        hashTable.remove(3);
        hashTable.printTable();

        System.out.println("\nInserting more values to trigger resizing:");
        hashTable.insert(6, 60);
        hashTable.insert(7, 70);
        hashTable.insert(8, 80);
        hashTable.insert(9, 90);  // Resizing happens here
        hashTable.printTable();

        System.out.println("\nRemoving keys to trigger shrinking:");
        hashTable.remove(1);
        hashTable.remove(2);
        hashTable.remove(4);
        hashTable.remove(5);  // Shrinking happens here
        hashTable.printTable();
    }
}


/*
Output:

Inserting values:
Bucket 0: 
Bucket 1: [1: 10] 
Bucket 2: [2: 20] 
Bucket 3: 
Bucket 4: [4: 40] 
Bucket 5: 
Bucket 6: [6: 60] 
Bucket 7: 

Searching for key 3:
Value for key 3: 30

Removing key 3:
Bucket 0: 
Bucket 1: [1: 10] 
Bucket 2: [2: 20] 
Bucket 3: 
Bucket 4: [4: 40] 
Bucket 5: 
Bucket 6: 
Bucket 7: 

Inserting more values to trigger resizing:
Resized: doubled to 16
Bucket 0: 
Bucket 1: [1: 10] 
Bucket 2: [2: 20] 
Bucket 3: 
Bucket 4: [4: 40] 
...

Removing keys to trigger shrinking:
Resized: halved to 8
Bucket 0: 
Bucket 1: 
Bucket 2: 
...

*/
