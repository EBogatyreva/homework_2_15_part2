public class SelectionSort {
    public static void selection(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            SwapElements.swap(arr, i, min);
        }
    }

}
