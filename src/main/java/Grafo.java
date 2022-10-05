import java.io.*;
import java.util.LinkedList;

public class Grafo {

    private int[][] matriz;
    private final LinkedList<Nodo> nodos;

    public Grafo(){
        nodos = new LinkedList<>();
        leerArchivo();
    }

    private void leerArchivo(){
        String ruta = "src/main/java/grafo.txt";
        File archivo = new File(ruta);

        try(BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            //Lectura de primera linea para conseguir la cantidad de nodos
            int cantidadNodos = Integer.parseInt(br.readLine());

            //Lectura de segunda linea para obtener identificadores
            String[] identificadores = br.readLine().split(" ");

            //Error si cantidad de nodos es diferente a la cantidad de identificadores encontrados
            if(identificadores.length-1 != cantidadNodos) throw new Exception("Cantidad de nodos e identificadores no concuerdan");

            //Creacion de nodos
            for(int i = 1; i < identificadores.length; i++){
                nodos.add(new Nodo(identificadores[i].charAt(0)));
            }

            matriz = new int[cantidadNodos][cantidadNodos];

            //Creacion de matriz y nodos adyacentes a cada nodo
            for(int i = 0; i < cantidadNodos; i++){

                String[] valores = br.readLine().split(" ");

                for(int j = 1; j < valores.length; j++){

                    if(valores[j].equals("1")){
                        matriz[i][j-1] = 1;
                        nodos.get(i).agregarNodoAdyacente(nodos.get(j-1));
                    }
                }
            }

        }catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Nodo getNodoRaiz(){
        return nodos.get(0);
    }

    public String toString(){
        StringBuilder resultado = new StringBuilder();
        for(Nodo n: nodos){
            resultado.append("Nodo ").append(n.getId()).append(":");
            for(Nodo nodoAdyacente: n.getNodosAdyacentes()){
                resultado.append(" ").append(nodoAdyacente.getId());
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

}
