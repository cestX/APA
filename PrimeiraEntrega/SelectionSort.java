public class SelectionSort {
    

    SelectionSort(int[] list) {
       
        
        for (int i = 0; i < list.length - 1; i++) {

            //Recebe o índice a ser avaliado
            int aux = i;

            //percorre array até o final
            for (int j = aux + 1; j < list.length; j++) {
                //se o valor do array for  
                if (list[j] < list[aux]) {
                    aux = j;
                }
            }
            if (aux != i) {
                int t = list[i];
                list[i] = list[aux];
                list[aux] = t;

            }
        }
        
         for (int i=0; i<list.length-1; i++) {
        
            System.out.print(list[i]+",");
        
        }
       System.out.println(list[list.length-1]);
    }
}
