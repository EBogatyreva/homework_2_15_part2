public class BubleSort {
    public static void buble(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1])
                    SwapElements.swap(arr, j, j+1);
            }
        }
    }
}
