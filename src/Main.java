import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Algoritms");

        task1();
        task2();

    }

    private static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число:");
        int num = in.nextInt();
        System.out.println("Введите степень числа");
        int pow = in.nextInt();
        long numInPow = power(num, pow);
        System.out.printf("Число %d в степени %d равно: %d", num, pow, numInPow);
    }

    private static long power(int num, int pow) {
        if (pow == 1) {
            return num;
        }
        return (num * power(num, pow - 1));
    }

    private static void task2() {
        Goods[] goods = { new Goods(20, 40),
                         new Goods(30, 90),
                         new Goods(50, 110)};
        int maxWeight = 80;

        System.out.println("Cтоимость рюкзака: " + bestResult((goods.length - 1), maxWeight, goods));
    }

    private static int bestResult(int i, int weight, Goods[] goods) {
        if (i < 0) {
            return 0;
        }
        if (goods[i].getWeight() > weight) {
            return bestResult((i-1), weight, goods);
        } else {
            return Math.max(bestResult((i-1), weight, goods),
                    bestResult((i-1), weight - goods[i].getWeight(), goods) + goods[i].getCost());
        }
    }

}
