import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Algoritms");


        //task
        Graph graph = new Graph(10);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.addEdge(3,6);
        graph.addEdge(6,4);
        graph.addEdge(6,5);
        graph.addEdge(3,9);
        graph.addEdge(3,5);
        graph.addEdge(5,7);
        graph.addEdge(7,9);
        graph.addEdge(9,8);
        //System.out.println(graph.getAdjList(9));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начало пути:");
        int start = scanner.nextInt();
        System.out.println("Введжите конец пути:");
        int finish = scanner.nextInt();

        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, start);
        String str = "не существует";
        if (bfs.hasPathTo(finish)) {
            str = "существует";
        };
        System.out.printf("Путь между вершинами %d и %d - %s \n", start, finish, str);
        System.out.println("Путь: " + bfs.pathTo(finish));
        System.out.println("Длина пути: " + bfs.pathTo(finish).size());
    }
}
