package part3;
import java.util.LinkedList;
    public class t5 {

        private static final int SIZE = 10; // Example size
        private LinkedList<Integer>[] data; // Array of linked lists to handle collisions

        public t5() {
            data = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                data[i] = new LinkedList<>(); // Initialize linked lists
            }
        }

        public int hashFunction(int key) {
            return key % SIZE; // Simple mod function for this example
        }

        public void put(int key, int value) {
            int index = hashFunction(key);
            data[index].add(value); // Add key-value pair to the linked list at the index
        }

        public Integer get(int key) {
            int index = hashFunction(key);
            for (Integer element : data[index]) {
                if (element.intValue() == key) { // Check if key matches
                    return element;
                }
            }
            return null; // Key not found
        }
    }

