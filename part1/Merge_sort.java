package part1;

public class Merge_sort {
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the middle point
            int mid = low + (high - low) / 2;

            // Sort first and second halves
            sort(arr, low, mid);
            sort(arr, mid + 1, high);

            // Merge the sorted halves
            merge(arr, low, mid, high);
        }
    }
    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Create temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];


        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            left[i] = arr[low + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[mid + 1 + j];

        /* Merge the temp arrays back into arr[low..high] */
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        /* Copy the remaining elements of left[], if there are any */
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        /* Copy the remaining elements of right[], if there are any */
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int n = arr.length;

        Merge_sort.sort(arr, 0, n - 1);

        System.out.println("Sorted array in ascending order: ");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

