import java.io.*;
import java.util.*;

public class Lista {


    public static void main(String[] args) {
        
       double time; 
       String localArquivo = "/home/rhenan/Documentos/APA/APA/Entrada.txt";

        int [] lista = lerDados(localArquivo); 

        System.out.println("\n\n Counting Sort");
        time = System.currentTimeMillis();
        CountingSort ms = new CountingSort(lista.clone());
        System.out.println("Tempo em Milissegundos: " +(System.currentTimeMillis() - time));
        System.out.println("\n\n\n");


        //System.out.println("\n\n Heap Sort");
        time = System.currentTimeMillis();
        System.out.println("HeapSort:");
        HeapSort hs = new HeapSort(); 
        hs.heapSort(lista.clone());
        System.out.println("Tempo em Milissegundos: " +(System.currentTimeMillis() - time));

  
    }


    public static int[] lerDados(String localArquivo) {

        ArrayList<Integer> lista = null;

        try {
            Scanner input = new Scanner(new File(localArquivo));
            int auxiliar;
            lista = new ArrayList<>();

            while (input.hasNextLine()) {
                auxiliar = input.nextInt();
                lista.add(auxiliar);
            }

            input.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Erro:" +ex);
        }

        
        int[] listaFinal = new int[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            listaFinal[i] = lista.get(i);
        }

        return listaFinal;

    }
}

