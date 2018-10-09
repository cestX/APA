package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {

    public static void saveToFile(String caminho, String txt) throws FileNotFoundException {

        FileOutputStream arq = new FileOutputStream(caminho);
        PrintWriter pr = new PrintWriter(arq);

        try {

            pr.println(txt);
            pr.close();
            arq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String leArquivo(String caminho) {
        String txt = "";
        FileInputStream arquivo;
        try {
            arquivo = new FileInputStream(caminho);
            InputStreamReader input = new InputStreamReader(arquivo, "UTF-8");
            BufferedReader br = new BufferedReader(input);
            String linha;
            do {
                linha = br.readLine();
                if (linha != null) {
                    txt += linha + "\n";
                }
            } while (linha != null);
            br.close();
            input.close();
            arquivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return txt;
    }
    
    
    public static List<Vertice> constroiMatriz(int[][] matriz) {

        // construir lista de vertices
        List<Vertice> vertices = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) { // linha
            vertices.add(new Vertice());
        }

        // para cada vertice, ver na matriz quem eh seu vizinho
        for (int i = 0; i < vertices.size(); i++) { // linha
            for (int j = 0; j < matriz[i].length; j++) { // coluna
                if (matriz[i][j] != 0 && matriz[i][j] != Integer.MAX_VALUE) {
                    vertices.get(i).add(vertices.get(j));
                }
            }
        }

        return vertices;

    }

    public static int[][] construirRepresentacaoMatriz(String entrada) {
        // ler arquivo
        String arquivoBruto = main.Arquivo.leArquivo(entrada);

        String[] linhas = arquivoBruto.split("\n");

        int n = Integer.parseInt(linhas[0]);
        int matriz[][] = new int[n][n];

        // construir matriz
        // i eh linha no arquivo 
        // j eh a coluna.
        for (int i = 1; i < linhas.length; i++) {
            String[] pesos_ij = linhas[i].split(" ");
            for (int j = pesos_ij.length - 1; j >= 0; j--) {
                /*i-1 na matriz ja que a primeira linha == 'n'
                Como so precisa do teiangulo superior, a matriz comeca do elemento (i)(j+i)*/
                int peso;
                try {
                    peso = Integer.parseInt(pesos_ij[j]);
                } catch (NumberFormatException e) {
                    peso = Integer.MAX_VALUE;
                }
                matriz[i - 1][j + i] = peso;
            }
        }

        return matriz;
    }

    public static ArrayList<Vertice> buildMinHeap(Vertice[] vet) {

        for (int i = (vet.length / 2) - 1; i >= 0; i--) {
            minHeapfy(vet, vet.length, i);
        }

        ArrayList<Vertice> ret = new ArrayList<Vertice>();

        for (int i = 0; i < vet.length; i++) {
            ret.add(vet[i]);
        }

        return ret;
    }

    public static Vertice[] minHeapfy(Vertice[] vet, int tam, int index) {
        int menor = index, esquerda = 2 * index, direita = 2 * index + 1;

        if ((esquerda <= tam - 1) && (vet[esquerda].valor < vet[menor].valor)) {
            menor = esquerda;
        }

        if ((direita <= tam - 1) && (vet[direita].valor < vet[menor].valor)) {
            menor = direita;
        }

        if (menor != index) {
            Vertice aux = vet[index];
            vet[index] = vet[menor];
            vet[menor] = aux;

            return minHeapfy(vet, tam, menor);
        }

        return vet;
    }

}
