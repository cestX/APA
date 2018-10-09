/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rhenan
 */
public class Kruskal {

    public static void main(String[] args) {

        int V = 4; // numero de vertices
        int A = 6; // numero de arestas

        Grafo grafo = new Grafo(V, A);

        grafo.arestas[0].origem = 0;
        grafo.arestas[0].destino = 1;
        grafo.arestas[0].peso = 23;

        grafo.arestas[1].origem = 0;
        grafo.arestas[1].destino = 2;
        grafo.arestas[1].peso = 17;

        grafo.arestas[2].origem = 0;
        grafo.arestas[2].destino = 3;
        grafo.arestas[2].peso = 19;

        grafo.arestas[3].origem = 1;
        grafo.arestas[3].destino = 2;
        grafo.arestas[3].peso = 22;

        grafo.arestas[4].origem = 1;
        grafo.arestas[4].destino = 3;
        grafo.arestas[4].peso = 20;

        grafo.arestas[5].origem = 3;
        grafo.arestas[5].destino = 2;
        grafo.arestas[5].peso = 25;
        grafo.KrustalMST();
    }

}
