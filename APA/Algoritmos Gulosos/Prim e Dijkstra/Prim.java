package main;

import java.util.ArrayList;
import java.util.List;
import static main.Arquivo.buildMinHeap;


public class Prim {

    List<Vertice> vertices;

    //Construtor Prim
    //Lista de adjacências, matriz de adjacencia
    public Prim(List<Vertice> adjacencia, int[][] representacaoMatriz) {
        this.vertices = adjacencia;
        //inicializa vertices com valor infinito 
        this.inicializaVertices();
        this.buildMSTPrim(this.vertices.toArray(new Vertice[0]), representacaoMatriz, 0);
    }

    private void inicializaVertices() {
        for (Vertice v : this.vertices) {
            v.valor = Integer.MAX_VALUE;
        }
    }

    private void buildMSTPrim(Vertice[] listaVertices, int[][] formatoMatriz, int inicial) {
        int numeroVertices = this.vertices.size();
        
        //Array final com os resultados
        Vertice[] resultado = new Vertice[numeroVertices];
        
        //Variavel vertice auxiliar, usado em cada remocao
        Vertice v = null;
        
        int minHeapTamanho = 0;

        //Atribui zero ao vertice escolhido como inicial
        listaVertices[inicial].valor = 0;

        //Controi a primeira arvore heap
        ArrayList<Vertice> minHeap = buildMinHeap(listaVertices.clone());		

        // enquanto tiver elementos na minHeap
        while ((minHeapTamanho = minHeap.size()) != 0) {
            v = minHeap.remove(0);		//Remove o primeiro vertice da lista

            // para cada vizinho de V
            for (int i = 0; i < v.adj.size(); i++) {
                //Confere se o vertice adjacente esta minHeap
                // e se o peso da aresta é menor que o valor atual do vertice
                if ((formatoMatriz[v.id][v.adj.get(i).id] < (v.adj.get(i).valor))) {
                    v.adj.get(i).pai = v; //Atribui o vertice retirado como o novo pai
                    v.adj.get(i).valor = formatoMatriz[v.id][v.adj.get(i).id]; //Modifica o valor do vertice pelo peso da aresta correspondente
                }
            }

            minHeap = buildMinHeap(minHeap.toArray(new Vertice[minHeap.size()]));

            resultado[numeroVertices - minHeapTamanho] = v; //Guarda os vertices ja acessados
        }

        int acumulado = 0;

        // exibir resultado
        for (int i = 0; i < resultado.length; i++) {
            if (resultado[i].pai != null) {
                System.out.println(resultado[i].pai.id + " <-- " + resultado[i].id + " Peso: " + resultado[i].valor);
            } else {
                System.out.println(resultado[i].pai + " <-- " + resultado[i].id + " Peso: " + resultado[i].valor);
            }

            acumulado += resultado[i].valor;
        }

        System.out.println("\nValor acumulado: " + acumulado);

    }

    
}
