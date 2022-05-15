public class SwapElements {
    public static void swap(Integer[] arr, int indexA, int indexB) {
        int temp = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = temp;
    }
}
