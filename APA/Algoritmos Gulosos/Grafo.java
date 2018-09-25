/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;

/**
 *
 * @author rhenan
 */
public class Grafo {
    
    int vertice, aresta; 
    Arestas arestas[]; 
    
    
    Grafo (int vertice, int aresta) {
        
        this.vertice = vertice; 
        this.aresta = aresta; 
        arestas = new Arestas[aresta];
        for (int i=0; i<aresta; i++) {
            arestas[i] = new Arestas();
        }
    }
    
    int encontraConjunto(Subconjunto subconjunto[], int i) {
        //Encontra uma raiz torna ela faz pai de i
        if (subconjunto[i].pai != i)
            subconjunto[i].pai = encontraConjunto(subconjunto,subconjunto[i].pai);
            return subconjunto[i].pai;
    }
    
    
    void uniao (Subconjunto subconjunto[], int x, int y) {
    
        int raizx = encontraConjunto(subconjunto, x);
        int raizy = encontraConjunto(subconjunto,y);
    
        if(subconjunto[raizx].classificacao < subconjunto[raizy].classificacao)
            subconjunto[raizx].pai = raizy; 
        else if (subconjunto[raizx].classificacao>subconjunto[raizy].classificacao)
                subconjunto[raizy].pai = raizx; 
        else 
        {
            subconjunto[raizy].pai=raizx;
            subconjunto[raizx].classificacao++;
            
        }
    
    }
    
    void KrustalMST() 
   
    {
    
        //Guarta o resultado da MST
        Arestas resultado[] = new Arestas[vertice];
        int i = 0; //variável pra percorrer resultado;
        int j = 0; //variavel pra ordenar as arestas; 
        
        for (j=0; j<vertice; j++){
        
            resultado [j] = new Arestas();
            
        }
        
        //Primeiro passo: Ordenar os vértices em ordem crescente
        //se eles não mudaram o grafo original, então é só fazer uma cópia
        Arrays.sort(arestas);
        
        //aloca espaço pro subconjunto de vertices
        Subconjunto subconjunto[] = new Subconjunto[vertice]; 
        for (j=0; j<vertice; j++)
            subconjunto[j] = new Subconjunto();
        
        
        //cria subconjuntos dos vertices com elementos únicos
        for (int x = 0; x<vertice; x++) {
        
            subconjunto[x].pai = x; 
            subconjunto[x].classificacao = 0;
        
        }
        j=0;
        
        while(i < vertice-1) {
        
        Arestas proxima_aresta = new Arestas(); 
        proxima_aresta = arestas[j++];
        
        int x = encontraConjunto(subconjunto, proxima_aresta.origem);
        int y = encontraConjunto(subconjunto, proxima_aresta.destino);
           
        
        if (x != y) {
        
            resultado[i++] = proxima_aresta; 
            uniao(subconjunto, x, y);                    
            }

        }
        for (int z=0; z<i; z++)
            System.out.println(resultado[z].origem +"--"+resultado[z].destino +" = "+resultado[z].peso);
    } 
}
