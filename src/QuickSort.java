public class QuickSort {
        public static void quickSort(Integer[] arr, int begin, int end) {
            if (begin < end) {
                int partitionIndex = partition(arr, begin, end);
                quickSort(arr, begin, partitionIndex - 1);
                quickSort(arr, partitionIndex + 1, end);
            }
        }

        private static int partition(Integer[] arr, int begin, int end) {
            int pivot = arr[end];
            int i = (begin - 1);

            for (int j = begin; j < end; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    SwapElements.swap(arr, i, j);
                }
            }
            SwapElements.swap(arr, i + 1, end);
            return i + 1;
        }
}
