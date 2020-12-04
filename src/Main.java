import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Algoritms");

        /*MyOneSidedLinkedList<String> myOneLL = new MyOneSidedLinkedList<>();
        myOneLL.insertFirst("мама");
        myOneLL.insert(1,"папа");
        myOneLL.insert(2,"брат");
        System.out.println(myOneLL.isEmpty());
        System.out.println(myOneLL.getFist());

        System.out.println(myOneLL);

        myOneLL.removeFirst();
        System.out.println(myOneLL);
        myOneLL.insertFirst("мама");
        System.out.println(myOneLL);
        System.out.println(myOneLL.indexOf("папа"));
        System.out.println(myOneLL.contains("дядя"));
        System.out.println(myOneLL.remove("мама"));
        System.out.println(myOneLL.remove(0));
        System.out.println(myOneLL);*/

        /*MyTwoSidedLinkedList<String> myTwoLL = new MyTwoSidedLinkedList<>();
        myTwoLL.insertFirst("мама");
        myTwoLL.insertLast("папа");
        myTwoLL.insert(1, "брат");
        System.out.println(myTwoLL);
        System.out.println(myTwoLL.getFirst());
        System.out.println(myTwoLL.getLast());
        //System.out.println(myTwoLL.removeFirst());
        //System.out.println(myTwoLL.removeLast());
        System.out.println(myTwoLL.remove(1));
        System.out.println(myTwoLL);
        System.out.println(myTwoLL.remove("мама"));
        System.out.println(myTwoLL);*/

        task1();
        task2();
        task3();
    }

    private static void task1() {
        System.out.println("Задание 1.");
        MyTwoSidedLinkedList<String> myTwoLL = new MyTwoSidedLinkedList<>();
        myTwoLL.insertFirst("мама");
        myTwoLL.insertLast("папа");
        myTwoLL.insert(1, "брат");
        System.out.println(myTwoLL);
        /*for (String my: myTwoLL) {
            //System.out.println(my);
            if (my.equals("брат")) {
                my.remove();
            }
        }*/
        Iterator it = myTwoLL.iterator();
        while (it.hasNext()) {
            if (it.next().equals("брат")) {
                it.remove();
            }
        }
        System.out.println(myTwoLL);
    }

    private static void task2() {
        System.out.println("Задание 2.");
        MyTwoSidedLinkedList<String> myTwoLL = new MyTwoSidedLinkedList<>();
        myTwoLL.insertFirst("мама");
        myTwoLL.insertLast("папа");
        myTwoLL.insert(1, "брат");
        System.out.println(myTwoLL);

        ListIterator lit = myTwoLL.listIterator();
        System.out.println(lit.hasNext());
        System.out.println(lit.hasPrevious());
        System.out.println(lit.next());
        System.out.println(lit.next());

        System.out.println(lit.nextIndex());
        System.out.println(lit.previousIndex());
        System.out.println(lit.previous());
        System.out.println(lit.nextIndex());
        System.out.println(lit.previousIndex());
        lit.add("сестра");
        System.out.println(myTwoLL);

        System.out.println(lit.nextIndex());
        System.out.println(lit.previousIndex());

        System.out.println(lit.next());
        lit.set("сестрёнка");
        System.out.println(myTwoLL);
        lit.remove();
        System.out.println(myTwoLL);
        System.out.println(lit.nextIndex());
        System.out.println(lit.previousIndex());

    }

    private static void task3() {
        System.out.println("Задание 3.");
        MyStack<String> myStack = new MyStack<>();
        myStack.push("Вася");
        myStack.push("Петя");
        myStack.push("Аня");
        System.out.println(myStack.toString());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.toString());

    }
}
