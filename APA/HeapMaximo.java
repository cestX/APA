
public class HeapMaximo {

    public void heapMaximo(int[] vetor, int tam) {
        
        //Variavel auxiliar 
        int aux;
        
        //pai é sempre o tamanho do vetor 
        int pai = (tam / 2) - 1;

        while (pai >= 0) {
            int filhoEsq = pai * 2 + 1;
            int filhoDir = pai * 2 + 2;

       
            if (filhoEsq < tam) {

                if (vetor[filhoEsq] > vetor[pai]) {

                    aux = vetor[pai];
                    vetor[pai] = vetor[filhoEsq];
                    vetor[filhoEsq] = aux;
                }

                if (filhoDir < tam) {
                    if (vetor[filhoDir] > vetor[pai]) {

                        aux = vetor[pai];
                        vetor[pai] = vetor[filhoDir];
                        vetor[filhoDir] = aux;
                    }
                }
            }

            pai--;
        }
    }
}
