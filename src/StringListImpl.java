import java.util.Arrays;
import java.util.List;

public class StringListImpl implements StringListInterface {
    private final int INIT_SIZE = 16;//изначальная max емкость
    private final int CUT_RATE = 4;
    private Integer[] array = new Integer[INIT_SIZE];
    private int pointer = 0;

    @Override
    public Integer add(int item) {
        if (pointer == array.length - 1)
            grow((int) (array.length * 1.5));
        array[pointer++] = item;
        return item;
    }

    @Override
    public Integer add(int index, int item) {
        if (pointer > array.length-1)
            throw new IndexOutOfBoundsException();
        array[index] = item;
        return item;
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Override
    public Integer set(int index, int item) {
        if (index < 0 || index > array.length - 1)
            throw new IndexOutOfBoundsException();
        array[index] = item;
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public Integer remove(int item) {
        int a1=0;
        for (int i = 0; i < pointer; i++) {
            if (array[i] == item) {
                array[i] = array[i + 1];//смещение
            } else if (array[i] != item)
                a1 = 1;
        }

        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            grow(array.length / 2);
        return item;
    }

    @Override
    public Integer removeByIndex(int index) {
        int a = 0;
        for (int i = index; i < pointer; i++) {
            if (array[index] == null) a = 1;
            else array[i] = array[i + 1];
        }
        if (a == 1) throw new IndexOutOfBoundsException();
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            grow(array.length / 2);
        return index;
    }

    @Override
    public boolean contains(int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) return true;
        }
        return false;
    }

    @Override
    public boolean contains(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if (array[index] == null) throw new IndexOutOfBoundsException();
        if (index > array.length - 1) throw new IndexOutOfBoundsException();
        return array[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof List)) {
            return false;
        }
        return false;


    }

    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        return pointer;
    }

    /*add method for scaling*/
    @Override
    public void grow(int newLength) {
        Integer[] newArray = new Integer[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);//old massive copy to new
        array = newArray;
    }

    //для себя
    public void printAll() {
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1)
                System.out.print(array[i] + ", ");
            else
                System.out.println(array[i]);
        }
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(int item) {
        if (item == 0) {
            for (int i = 0; i < pointer; i++)
                if (array[i] == 0)
                    return i;
        } else {
            for (int i = 0; i < pointer; i++)
                if (item == array[i])
                    return i;
        }
        return -1;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(int item) {
        return lastIndexOfRange(item, 0, pointer);
    }

    private int lastIndexOfRange(Object o, int start, int end) {
        Object[] es = array;
        if (o == null) {
            for (int i = end - 1; i >= start; i--) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = end - 1; i >= start; i--) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        int modCount = 0;
        modCount++;
        final Object[] es = array;
        for (int to = pointer, i = pointer = 0; i < to; i++)
            es[i] = null;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, pointer);
    }


}
