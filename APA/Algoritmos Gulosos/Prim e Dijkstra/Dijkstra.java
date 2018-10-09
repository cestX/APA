package main;

import java.util.ArrayList;
import java.util.List;
import static main.Arquivo.buildMinHeap;

public class Dijkstra {

    List<Vertice> vertices;


    public Dijkstra(List<Vertice> adjacencia, int[][] representacaoMatriz) {
        this.vertices = adjacencia;

        this.iniciaVertices();

        this.melhoresCaminhos(this.vertices.toArray(new Vertice[0]), representacaoMatriz, 0, (this.vertices.size() - 1));

    }


    public void iniciaVertices() {
        for (Vertice v : this.vertices) {
            v.valor = Integer.MAX_VALUE;
        }
    }

    private void melhoresCaminhos(Vertice[] vertices, int[][] representacaoMatriz, int inicio, int fim) {
        //Atribui zero ao vertice inicial
        vertices[inicio].valor = 0;

        //Controi a primeira arvore heap
        ArrayList<Vertice> minHeap = buildMinHeap(vertices.clone());

        Vertice verticeAuxiliar = null;

        /**
         * saida final
         */
        Vertice[] res = new Vertice[vertices.length];

        while (minHeap.size() != 0) { //executa até não ter mais elementos
            verticeAuxiliar = minHeap.remove(0); //tira o menor elemento e armazena em verticeAuxiliar

            //percorre os demais 
            for (Vertice v : verticeAuxiliar.adj) {
                /*relaxamento*/

                if (minHeap.contains(v)
                        && v.valor > verticeAuxiliar.valor + representacaoMatriz[verticeAuxiliar.getId()][v.getId()]) {

                    v.valor = (verticeAuxiliar.valor + representacaoMatriz[verticeAuxiliar.getId()][v.getId()]);
                    v.pai = verticeAuxiliar;
                }
            }

            minHeap = buildMinHeap(minHeap.toArray(new Vertice[minHeap.size()]));

            res[representacaoMatriz.length - (minHeap.size() + 1)] = verticeAuxiliar;
        }

        System.out.println("Menor caminho de " + inicio + " para " + fim + " é: ");
        String resposta = "";
        int caminhoTotal = 0;


        for (Vertice v : res) {
            if (v.getId() == fim) {
                verticeAuxiliar = v;
                break;
            }
        }

        resposta = verticeAuxiliar.getId() + "";
        while (verticeAuxiliar.pai != null) {
            resposta = verticeAuxiliar.pai.getId() + " - " + resposta;
            // somar o caminho percorrido
            // TODO: testar essa instrucao
            caminhoTotal+=representacaoMatriz[verticeAuxiliar.pai.id][verticeAuxiliar.id];
            verticeAuxiliar = verticeAuxiliar.pai;
        }
        System.out.println(resposta+
                "\n soma dos caminhos = "+caminhoTotal);
        
    }

}
