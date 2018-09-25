import java.io.*;
import java.util.*;

public class CountingSort {

    int[] lista, lista2;

    CountingSort(int[] lista) {

        ordena(lista);

        for (int i = 0; i < lista2.length - 1; i++) {

            System.out.print(lista2[i] + ",");
        }
        System.out.println(lista2[lista2.length - 1]);

    }

    public int[] ordena(int[] lista) {

        this.lista = lista;

        lista2 = new int[lista.length];
        ordenar();

        return lista2;
    }

    private int[] ordenar() {
        int tamanhoLista3 = maiorValor();
        int[] lista3 = new int[tamanhoLista3];
        int tamanhoLista2 = lista.length;
        int pos;

        // inicializando com 0 a tabela de valores 3
        for (int i = 0; i < tamanhoLista3; i++) {
            lista3[i] = 0;
        }

        // atribuindo a frequência dos elementos do lista
        for (int i = 0; i < tamanhoLista2; i++) {
            lista3[lista[i]]++;
        }

        // soma valor do indice atual (n) com o valor do indice anterior (n-1)
        for (int i = 1; i < tamanhoLista3; i++) {
            lista3[i] += lista3[i - 1];
        }

        // fazendo a atribuição ao lista2 dos valores do lista
        // conforme a sua frequencia acumulada;
        for (int i = tamanhoLista2 - 1; i >= 0; i--) {
            pos = lista3[lista[i]] - 1;
            lista2[pos] = lista[i];
            lista3[lista[i]]--;
        }
        return lista2;
    }

    // Percorre a lista procurando o maior valor
    private int maiorValor() {
        int maiorValor = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > maiorValor) {
                maiorValor = lista[i];
            }
        }
        return maiorValor + 1;
    }
}
