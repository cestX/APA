
/**
 *
 * @author rhenan
 */

public class MergeSort {

    
    public MergeSort (int[]lista, int iInicial, int iFinal) {

        //chama função para ordenar a lista
        this.ordena(lista, iInicial, iFinal);

        for (int i=0; i<lista.length-1; i++) {
        
            System.out.print(lista[i] +",");  
        }
       System.out.println(lista[lista.length-1]);
    

    }

    private int[] ordena (int[]lista, int iInicial, int iFinal) {

        //trata lista
        if (lista.length != 0 &&
            iFinal > iInicial &&
            lista.length > iFinal &&
            iInicial >=0) {


             int iMeio = (iFinal + iInicial)/2;

             //divide no meio e manda ordenar quem tá a esquerda
             ordena(lista, iInicial, iMeio); 
             //divide no meio e manda ordenar quem tá a direita
             ordena(lista, iMeio+1, iFinal);

            merge (lista, iInicial, iMeio, iFinal);

            }
        
            return lista; 

    }


    private void merge (int[] lista, int iInicial, int iMeio, int iFinal) {

        //cria lista auxiliar para manipulacao na hora de dar merge
        int [] listaAuxiliar = new int[lista.length];

        //copia o vetor para o auxiliar
        for (int i = iInicial; i <= iFinal; i++) {
        
            listaAuxiliar[i] = lista[i];

        }

        //Indices Auxiliares
        int a = iInicial; 
        int b = iMeio + 1; 

        //indice que percorre a nova lista que vai dar merge
        int c = iInicial;

        //enquanto a não chegar ao meio e b não chegar ao final
        while (a <= iMeio && b <= iFinal) {
            //se o indice 
            if (listaAuxiliar[a] < listaAuxiliar[b]) {
                lista[c] = listaAuxiliar[a];
                a++;
            } else {
                lista[c] = listaAuxiliar[b];
                b++;
            }
            c++;
        }
        //junta elementos da esquerda em uma lista so
         while (a <= iMeio) {
            lista[c] = listaAuxiliar[a];
            a++;
            c++;
        }
        
        //junta elementos da direita em uma list
         while (b <= iFinal) {
            lista[c] = listaAuxiliar[b];
                 b++;
                 c++;
                }
    }


}
