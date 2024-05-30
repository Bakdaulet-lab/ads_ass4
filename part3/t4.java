package part3;
import java.util.LinkedList;
public class t4 {
        private LinkedList<Integer> data;

        public t4() {
            data = new LinkedList<>();
        }

        public void enqueue(int element) {
            data.addLast(element); // Add to the end (back of the queue)
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return data.removeFirst(); // Remove from the beginning (front)
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

}
