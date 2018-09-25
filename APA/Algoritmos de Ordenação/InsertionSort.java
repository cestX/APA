
class InsertionSort {

    InsertionSort(int[] list) {
        

        for (int i = 1; i < list.length; i++) {

            int aux = list[i];
            int j = i;

            while ((j > 0) && (list[j - 1] > aux)) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = aux;
        }
        
        for (int i=0; i<list.length-1; i++) {
        
            System.out.print(list[i]+",");
        
        }
       System.out.println(list[list.length-1]);
    }
}