package part3;
import java.util.ArrayList;
public class t3 {

    private ArrayList<Integer> data;

    public t3() {
        data = new ArrayList<>();
    }

    public void push(int element) {
        data.add(element); // Add to the end (top of the stack)
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.remove(data.size() - 1); // Remove from the end (top)
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
