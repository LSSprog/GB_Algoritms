import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
       // System.out.println("Algoritms");

        /*MyArrayList<Integer> myList= new MyArrayList<>();
        myList.add(2);
        myList.add(3);
        myList.add(5);

        System.out.println(myList);
        myList.swap(2, 0);
        System.out.println(myList);

        MySortedArrayList<Integer> msal = new MySortedArrayList<>();
        msal.add(5);
        msal.add(2);
        msal.add(1);
        msal.add(3);
        msal.add(4);
        System.out.println(msal);
        System.out.println(msal.binaryFind(3));*/

        Random rdm = new Random();
        MyArrayList<Integer> myList2 = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList2.add(rdm.nextInt(10));
        }
        System.out.println(myList2);
        myList2.selectionSort();
        //myList2.insertionSort();
        //myList2.bubbleSort();
        System.out.println(myList2);

        //task1
        MyArrayList<Integer> myList3 = new MyArrayList<>(1000000);
        //task2
        for (int i = 0; i < 1000000; i++) {
            myList3.add(rdm.nextInt(100));
        }

        task3();

        task4();

        task5();

    }

    public static MyArrayList<Integer> arr(int size) {
        Random rnd = new Random();
        MyArrayList<Integer> myL = new MyArrayList<>(size);
        for (int i = 0; i < size; i++) {
            myL.add(rnd.nextInt(100));
        }
        return myL;
    }

    public static void task3() {
        MyArrayList<Integer> testTimeSelSort = arr(10000);
        MyArrayList<Integer> testTimeInsSort = arr(10000);
        MyArrayList<Integer> testTimeBublSort = arr(10000);

        long start1 = System.currentTimeMillis();
        testTimeSelSort.selectionSort();
        long finish1 = System.currentTimeMillis();
        long time1 = finish1 - start1;
        System.out.println("на сортировку методом выбора понадобилось времени, мс : " + time1);

        long start2 = System.currentTimeMillis();
        testTimeInsSort.insertionSort();
        long finish2 = System.currentTimeMillis();
        long time2 = finish2 - start2;
        System.out.println("на сортировку методом вставки понадобилось времени, мс : " + time2);

        long start3 = System.currentTimeMillis();
        testTimeBublSort.bubbleSort();
        long finish3 = System.currentTimeMillis();
        long time3 = finish3 - start3;
        System.out.println("на сортировку пузырьковым методом понадобилось времени, мс : " + time3);
    }

    private static void task4() {
        MyArrayList<Integer> myList4 = arr(5);
        System.out.println(myList4);
        System.out.println(myList4.capacity());
        myList4.add(50);
        System.out.println(myList4);
        System.out.println(myList4.capacity());

    }

    private static void task5() {
        MyArrayList<Integer> myList5 = new MyArrayList<>();
        myList5 = arr(10);
        System.out.println(myList5);
        myList5.insertionSort(Comparator.reverseOrder());
        System.out.println(myList5);
        myList5.bubbleSort(Comparator.naturalOrder());
        System.out.println(myList5);
    }


}
