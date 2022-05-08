import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayList;
        Integer[] arrayList1;
        Integer[] arrayList2;
        Integer[] arrayList3;

        StringListImpl stringList = new StringListImpl();
        Random r = new Random();

        for (Integer i = 0; i < 100_000; i++) {
            stringList.add(r.nextInt(100_000) + 1);
        }

        arrayList = stringList.toArray();
        arrayList1 = stringList.toArray();
        arrayList2 = stringList.toArray();
        arrayList3 = stringList.toArray();

        System.out.println(" ");

        System.out.println("BubleSort");
        long start = System.currentTimeMillis();
        BubleSort.buble(arrayList);
        System.out.println("время " + (System.currentTimeMillis() - start));

        for (int i = 0; i < 20; i++) {
            System.out.print(arrayList[i] + " ");
        }
        System.out.println(" ");

        System.out.println("SelectionSort");
        long start1 = System.currentTimeMillis();
        SelectionSort.selection(arrayList1);
        System.out.println("время " + (System.currentTimeMillis() - start1));

        for (int i = 0; i < 20; i++) {
            System.out.print(arrayList1[i] + " ");
        }

        System.out.println(" ");

        System.out.println("InsertionSort");
        long start3 = System.currentTimeMillis();
        SelectionSort.selection(arrayList2);
        System.out.println("время " + (System.currentTimeMillis() - start3));

        for (int i = 0; i < 20; i++) {
            System.out.print(arrayList2[i] + " ");
        }

        System.out.println(" ");

        System.out.println("QuickSort");
        long start4 = System.currentTimeMillis();
        SelectionSort.selection(arrayList3);
        System.out.println("время " + (System.currentTimeMillis() - start4));

        for (int i = 0; i < 20; i++) {
            System.out.print(arrayList3[i] + " ");
        }

        System.out.println(" ");
        System.out.println(stringList.contains(arrayList3, 15));

    }
}
