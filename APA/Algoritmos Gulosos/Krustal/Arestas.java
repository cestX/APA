/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rhenan
 */
public class Arestas implements Comparable<Arestas>{

    int origem, destino, peso; 
    
    Arestas(){}; 
    

    //ordena as arestas por tamanho 
    @Override
    public int compareTo(Arestas arestas) {
        return this.peso-arestas.peso; 
    }
    

}
