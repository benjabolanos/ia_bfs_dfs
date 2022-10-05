import java.util.LinkedList;

public class Nodo {
    private final LinkedList<Nodo> nodosAdyacentes;
    private final char id;
    private boolean visitado;

    public Nodo(char id){
        nodosAdyacentes = new LinkedList<>();
        this.id = id;
        visitado = false;
    }

    public void agregarNodoAdyacente(Nodo nodoAdyacente){
        nodosAdyacentes.add(nodoAdyacente);
    }

    public char getId() {
        return id;
    }

    public Nodo getNodoEnPos(int i){
        return nodosAdyacentes.get(i);
    }

    public LinkedList<Nodo> getNodosAdyacentes(){
        return nodosAdyacentes;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}
