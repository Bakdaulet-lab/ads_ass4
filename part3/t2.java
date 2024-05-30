package part3;
import java.util.ArrayList;
import java.util.LinkedList;
public class t2 {

        public static void main(String[] args) {
            // ArrayList
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                arrayList.add(i); // Adding elements (fast)
            }

            // Accessing element at index 5000 (fast)
            int element = arrayList.get(5000);

            // Removing element at index 5000 (slow, requires shifting)
            arrayList.remove(5000);

            // LinkedList
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < 10000; i++) {
                linkedList.add(i); // Adding elements (fast)
            }

            // Accessing element at index 5000 (slow, needs to traverse)
            element = linkedList.get(5000);

            // Removing element at index 5000 (fast)
            linkedList.remove(5000);
        }

}
