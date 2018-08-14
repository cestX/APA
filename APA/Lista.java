import java.io.*;
import java.util.*;

public class Lista {


    public static void main(String[] args) {
        
       String localArquivo = "/home/rhenan/NetBeansProjects/APA1/src/APA/APA/Entrada.txt";

        int [] lista = lerDados(localArquivo); 

        //System.out.println("\n\nInsertion Sort");
        //manda lista desordenada
        //InsertionSort is = new InsertionSort(lista.clone()); 
        //System.out.println("\n\nSelection Sort");
         // Manda lista desordenada
        long time;
         //SelectionSort ss = new SelectionSort(lista.clone());
         //System.out.println("Tempo em Milissegundos: " +(System.currentTimeMillis() - time));

        System.out.println("\n\n Merge Sort");
        time = System.currentTimeMillis();
        MergeSort ms = new MergeSort(lista.clone(), 0, lista.length-1);
        System.out.println("Tempo em Milissegundos: " +(System.currentTimeMillis() - time));


        System.out.println("\n\n Quick Sort");
        time = System.currentTimeMillis();
        QuickSort qs = new QuickSort(); 
        qs.sort(lista.clone());
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

