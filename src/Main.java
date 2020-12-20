public class Main {
    public static void main(String[] args) {
        //System.out.println("Algoritms");

        ChainHashMap<Integer, String> chm = new ChainHashMap<>();
        chm.put(1, "A");
        chm.put(3, "C");
        chm.put(2, "B");
        chm.put(5, "E");
        chm.put(4, "D");
        chm.put(3, "W");

        System.out.println(chm);

        //task
        chm.delete(5);
        System.out.println(chm);
    }
}
