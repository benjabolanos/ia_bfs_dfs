public class Main {

    public static void main(String[] args){
        System.out.println("Algoritmo DFS");
        Grafo g = new Grafo();
        Algoritmos.DFS(g, 'D');

        System.out.println("\nAlgoritmo BFS");
        Grafo g2 = new Grafo();
        Algoritmos.BFS(g2, 'a');
    }
}
