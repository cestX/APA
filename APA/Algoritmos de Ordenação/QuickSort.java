/**
 *
 * @author Rhenan
 */
public class QuickSort {

    private int[] lista;
    private int tamanho;

    public int[] sort(int[] lista) {

        long tempoInicial, tempoFinal;
        tempoInicial = System.currentTimeMillis();

        this.lista = lista;
        tamanho = lista.length;
        quicksort(0, tamanho - 1);
        
        for (int i=0; i<lista.length-1; i++) {
        
            System.out.print(lista[i] +",");  
        }
       System.out.println(lista[lista.length-1]);
    
        return lista;
    }

    private void quicksort(int iInicial, int iFinal) {
        int pivo;
        int a = iInicial;
        int b = iFinal;


        //pivo = lista[iFinal]; 
        
        //Escolher pivo no meio tentanto evitar situação do pior caso
        pivo = lista[iInicial + (iFinal - iInicial) / 2];

        // Dividindo o vetor em dois
        while (a <= b) {

            //percorre da esquerda pra direita
            while (lista[a] < pivo) {
                a++;
            }
            //percorre da direita para esquerda
            while (lista[b] > pivo) {
                b--;
            }

            //swap
            if (a <= b) {
                int temp = lista[a];
                lista[a] = lista[b];
                lista[b] = temp;
                a++;
                b--;
            }
        }
        //vetor da esquerda
        if (iInicial < b) {
            quicksort(iInicial, b);
        }

      //vetor da direita
        if (a < iFinal) {
            quicksort(a, iFinal);
        }
    }

}
