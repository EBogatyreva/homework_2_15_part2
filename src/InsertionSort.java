public class InsertionSort {
    public static void insertion(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            // Вытаскиваем значение элемента
            int value = array[i];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int j = i - 1;
            for (; j >= 0; j--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[j + 1] = value;
        }
    }
}
