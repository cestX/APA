
public class HeapSort {

    private HeapMaximo heapMaximo;

    public HeapSort() {
        heapMaximo = new HeapMaximo();
    }

    public int[] heapSort(int[] vetor) {

        int tamanho = vetor.length; 
        int auxiliar;
        while (tamanho > 1) {

            // chama o heapMaximo e passa o indice de até onde a arvore vai
            heapMaximo.heapMaximo(vetor, tamanho);

            // troca o primeiro termo, que é o maior, com o último e diminuirmos o tamanho do array          
            auxiliar = vetor[0];
            vetor[0] = vetor[tamanho - 1];
            vetor[tamanho - 1] = auxiliar;

            tamanho--;

            // encerra o loop, quando o tamanho for menor que 1 porque o 1 é o topo;
        }

        for (int i=0; i<vetor.length-1; i++) {
        
            System.out.print(vetor[i] +",");  
        }
       System.out.println(vetor[vetor.length-1]);


        return vetor;
    }
}
