import java.util.LinkedList;
import java.util.Stack;

public class Algoritmos {

    public static void BFS(Grafo g, char nodoBuscado){
        LinkedList<Nodo> recorrido = new LinkedList<>();
        LinkedList<Nodo> cola = new LinkedList<>();

        cola.add(g.getNodoRaiz());

        while(!cola.isEmpty()){
            Nodo n = cola.removeFirst();
            recorrido.add(n);
            n.setVisitado(true);
            System.out.println(recorridoString(recorrido));

            //Si el nodo es encontrado, el ciclo termina
            if(n.getId() == nodoBuscado) {
                System.out.println("Nodo encontrado");
                break;
            }

            //Se agregan los nodos adyacentes no visitados a la cola
            for(Nodo nodoAdyacente: n.getNodosAdyacentes()){
                if(!nodoAdyacente.isVisitado()){
                    cola.add(nodoAdyacente);
                }
            }
        }
    }

    public static void DFS(Grafo g, char nodoBuscado){
        LinkedList<Nodo> recorrido = new LinkedList<>();
        Stack<Nodo> pila = new Stack<>();

        pila.push(g.getNodoRaiz());

        while(!pila.empty()){
            Nodo n = pila.pop();
            recorrido.add(n);
            n.setVisitado(true);
            System.out.println(recorridoString(recorrido));

            //Si el nodo es encontrado, el ciclo termina
            if(n.getId() == nodoBuscado) {
                System.out.println("Nodo encontrado");
                break;
            }

            //Se agregan los nodos adyacentes no visitados a la pila
            for(int i = n.getNodosAdyacentes().size()-1; i >=0; i--){
                Nodo nodoAdyacente = n.getNodoEnPos(i);
                if(!nodoAdyacente.isVisitado()){
                    pila.push(nodoAdyacente);
                }
            }
        }
    }

    private static String recorridoString(LinkedList<Nodo> recorrido){
        //Convertir recorrido en string para mostrarlo
        StringBuilder recorridoString = new StringBuilder();
        for(Nodo n: recorrido){
            recorridoString.append(n.getId()).append(" -> ");
        }

        for(int i = 0; i<4;  i++) recorridoString.deleteCharAt(recorridoString.length()-1);

        return "Recorrido: " + recorridoString;
    }

}
