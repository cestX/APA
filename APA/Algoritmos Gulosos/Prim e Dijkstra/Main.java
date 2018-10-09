package main;

import java.util.List;
import static main.Arquivo.constroiMatriz;
import static main.Arquivo.construirRepresentacaoMatriz;



public class Main {

    public static void main(String[] args) {
       
        // arquivo de entrada
        String entrada = "intanciasTest/dij10.txt";

        // ler arquivo de entrada e retornar o grafo
        int[][] matriz = construirRepresentacaoMatriz(entrada);

        // representacao em lista de adjacencia
        List<Vertice> adjacencia = constroiMatriz(matriz);
        
        // MSTPrim
        System.out.println("PRIM\n");
        Prim prim = new Prim(adjacencia, matriz);
        
        
        // Dijkstra
        System.out.println("DIJKSTRA\n");
        Dijkstra dijkstra = new Dijkstra(adjacencia, matriz);
        
        
       
    }
}
