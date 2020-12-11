import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Algoritms");

       /* MyTreeMap<Integer, Integer> map = new MyTreeMap<>();

        map.put(5, 50);
        System.out.println(map.size());
        map.put(1, 10);
        map.put(2, 20);
        map.put(9, 90);
        map.put(4, 40);
        map.put(6, 60);

        System.out.println(map);
        //map.deleteMin();
        map.delete(5);
        System.out.println(map);
        System.out.println(map.high());*/

        Random rnd = new Random();
        int num = 0;

        MyTreeMap<Integer, Integer>[] trees = new MyTreeMap[20];
        for (int i = 0; i < 20; i++) {
            trees[i] = new MyTreeMap<>();
            do {
                num = rnd.nextInt(200) - 100; // диапозон от -100 до 99 получился
                trees[i].put(num, num * 10);
            } while (trees[i].high() < 6);
        }

        int count = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println(trees[i]);
            System.out.println(trees[i].isBalance());
            if (trees[i].isBalance()) {
                count++;
            }
        }
        double proc = count / (20 - count);
        System.out.println(proc + " % деревьев сбалансированно");

    }
}
