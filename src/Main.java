import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Algoritms");
        
        /*MyStack<Integer> myStack = new MyStack<>();
        myStack.push(4);
        myStack.push(7);
        myStack.push(1);
        myStack.push(5);

        System.out.println(myStack.peek());

        System.out.println(myStack);

        int size = myStack.size();

        for (int i = 0; i < size; i++) {
            System.out.println(myStack.pop());
        }*/

          //Expression expression = new Expression("[ d + ( 9-0 ) + {g + ( 2+8 )} + 5]");
          //System.out.println(expression.checkBracket());

        /*MyQueue<Integer> queue = new MyQueue<>(5);
        System.out.println(queue);
        queue.insert(5);
        queue.insert(3);
        queue.insert(2);
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        queue.insert(7);
        queue.insert(9);
        queue.insert(6);
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);*/


        task1();
        task2();

    }

    private static void task1() {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        System.out.println ("Введите текст");

        String text = sc.nextLine();
        char[] temp = text.toCharArray();
        MyStack<String> textToStack = new MyStack<>(temp.length);
        for (int i = 0; i < temp.length; i++) {
            textToStack.push(String.valueOf(temp[i]));
        }
        //pw.println(textToStack);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            sb.append(textToStack.pop());
        }
        pw.println(sb);
        pw.close();
    }

    private static void task2() {
        MyDeka<Integer> myDeka = new MyDeka<>(10);
        myDeka.insertRight(2);
        System.out.println(myDeka);
        myDeka.insertRight(3);
        System.out.println(myDeka);
        myDeka.insertLeft(5);
        System.out.println(myDeka);
        myDeka.insertLeft(7);
        System.out.println(myDeka);
        myDeka.insertLeft(1);
        System.out.println(myDeka);
        myDeka.insertRight(4);
        System.out.println(myDeka);
        System.out.println("последний в очереди: " + myDeka.peekBehind());
        System.out.println("первый в очереди: " + myDeka.peekFront());
        System.out.println(myDeka.removeRight());
        System.out.println(myDeka);
        System.out.println(myDeka.removeLeft());
        System.out.println(myDeka);
    }

}
