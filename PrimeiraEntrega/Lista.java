public class Lista {

    
    public static void main(String[] args) { 
        
        int list[] = new int[args.length];

        //converte entradas em inteiros
        for (int i=0; i<args.length; i++) {

            list[i] =Integer.parseInt(args[i]);        
            
        }
        
        
        
        System.out.println("\n\nInsertion Sort");
        //manda lista desordenada
        InsertionSort is = new InsertionSort(list.clone());
        System.out.println("\n\nSelection Sort");
        //Manda lista desordenada
        SelectionSort ss = new SelectionSort(list.clone());
        
        
    }

}

