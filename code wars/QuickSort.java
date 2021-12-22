// TODO: change this file to data structures

public class QuickSort {
    public static void sort(int arr[]) {
        int low = 0, high = arr.length - 1;

        int pi = partition(arr, low, high);

        sort(arr, low, pi - 1);
        sort(arr, pi + 1, high);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }

    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low, temp;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                temp = arr[i];
                arr[i++] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static void main(String[] args) {
        int arr[] = {9, 5, 4, 8, 6, 7, 2, 3, 1, 10};
        sort(arr);

        for (int e : arr)
            System.out.printf("%d ", e);
    }
}
