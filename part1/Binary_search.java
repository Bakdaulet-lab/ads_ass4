package part1;

public class Binary_search {

    public static int search(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            /* low + (high - low)/2; */
            mid = (low + high) >>> 1;

            // If x is greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

                // If x is smaller, ignore right half
            else if (arr[mid] > x)
                high = mid - 1;

                // If x is found at mid
            else
                return mid;
        }

        // If we reach here, then the element was not present
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int x = 10;

        // Function call
        int result = search(arr, x);

        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }
}
