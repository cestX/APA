/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixeiro_viajante;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rhenan
 */

public class TravelingSalesman {
	
	private static int path[][]; //matriz de caminhos minimos
	private static int matrizCustos[][]; //matriz de custos
	private static int thisDistanceMatrix[][];	
        private static int maximo = Integer.MAX_VALUE;
	private static int verticeInicial = 0;	

        
        
        
	public static void main(String[] args) throws FileNotFoundException {
          
            int tamanho = 0;
            String line;	
            FileReader input = 
                    new FileReader("/home/rhenan/NetBeansProjects/caixeiro_viajante/src/caixeiro_viajante/teste.txt");
            BufferedReader fileReader =  new BufferedReader(input);
        
            

		
		try {	
                        tamanho = Integer.parseInt(fileReader.readLine());
			int matrizMapa[][]; 
			matrizMapa = new int[tamanho][tamanho];
			int linha = 0;
			String arr [] = new String [tamanho];
			
			while ((line = fileReader.readLine()) != null){   
			    arr = line.split(" ");           

			    for (int coluna = 0; coluna < arr.length; coluna++) 
			        matrizMapa[linha][coluna] = Integer.parseInt(arr[coluna]);
			    
			    linha++;              
			}     

			fileReader.close();
			tsp(matrizMapa);			
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
        
        
	private static int tsp(int[][] distancia){

		ArrayList<Integer> s = new ArrayList<Integer>();	//Conjunto S
		int n = distancia.length;
		thisDistanceMatrix = distancia;
		int combinacoes = (int) Math.pow(2, n) - 1; //base -> expoente (-1) = 15

		matrizCustos = new int[n][combinacoes]; //matriz de custo
		path = new int[n][combinacoes]; //matriz caminho

		for (int i = 0; i < n; i++)
			matrizCustos[i][verticeInicial] = distancia[i][verticeInicial];

		int countS = 1; // |S|
                
		/*Vai guarda os a permutação dos valores de S de cada iteracao*/
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();	

		while (countS < n - 1){
			
			for (int currentVertex = 1; currentVertex < n; currentVertex++) {

				for (int city = 1; city < n; city++)
					if(currentVertex != city)
						s.add(city);	//Preencher o S com todas as cidades menos a atual  				

				//retorna todos os subconjuntos possiveis com norma |S|, EXCETO O ATUAL E O PRIMEIRO
				permutations = permute(s, countS);

				for (int k = 0; k < permutations.size(); k++)
					minCost(currentVertex, permutations.get(k)); //atualiza matrizes matrizCustos e path				

				s.clear();
				permutations.clear();
			}			
			countS++;
		}

		/* Calculando custo minimo final */
		for (int city = 1; city < n; city++)//todas as cidades menos a primeira (current)
			s.add(city);
		
		minCost(verticeInicial, s);
		System.out.println("Custo: " + matrizCustos[verticeInicial][combinacoes-1]);
		/* Get min Path */
		System.out.println("Percurso: "+Arrays.toString(getMinPath(s)));

		/*showBiMatrix(thisDistanceMatrix);
		showBiMatrix(matrizCustos);
		showBiMatrix(path);	*/	

		return matrizCustos[verticeInicial][combinacoes-1];
	}

	/*helper*/

	private static void minCost(int val, ArrayList<Integer> s){
		
		int col = numArray2int(s);	//valor da coluna que sera guardado 2elevN		
		int min = maximo;
		int index = -1;
		
		for(int j: s){
			index++;
			//Calcular o g usando cada elemento de S, já aproveitando o valores da matriz de acumulação
			int cost = thisDistanceMatrix[val][j] + matrizCustos[ j ][ col - (int) (Math.pow(2, j)) ];
			if(cost < min) {
                min = cost;
                matrizCustos[val][col] = min;
                path[val][col] = s.get(index);
            }
		}	
	}

	private static int[] getMinPath(ArrayList<Integer> s){
		int[] minPath = new int[s.size() + 2]; // 0 -> {...} -> 0
		minPath[0] = 0;
		int col = 0;
		int row = 0;
		int min = 0;
		
		for (int i = 1; i < minPath.length; i++){
			col = numArray2int(s);		//Calcula o valor do conjunto S
			min = path[row][col];
			minPath[i] = min;
			row = min;		
			
			/* exclui do conjunto s a cidade escolhida */
			for (int j = 0; j < s.size(); j++){	
				if(s.get(j) == min){s.remove(j);break;}
			}
		}

		return minPath;
	}

	//Gera todos os possivei conjuntos de tamanho sizeS para os valores contidos em S
	private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> s, int sizeS){

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		int[] sub = new int[sizeS];

		if (sizeS <= s.size()){
			for (int i = 0; (sub[i] = i) < sizeS-1; i++);
			
			result.add(getSubset(s,sub));
			
			while (true){
				int i;
				
				for (i = sizeS-1; (i >= 0) && (sub[i] == s.size() - sizeS + i); i--);
				
				if (i < 0)
					break;
				else { 
					sub[i]++;
					
					for (++i ; i < sizeS; i++)
						sub[i] = sub[i - 1] + 1;					
					
					result.add(getSubset(s,sub));
				}
			}
		}
		return result;
	}
	
	private static ArrayList<Integer> getSubset(ArrayList<Integer> input, int[] subset){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for (int i = 0; i < subset.length; i++){
			res.add(input.get(subset[i]));
		}
		
		return res;
	}

	private static int numArray2int(ArrayList<Integer> ar){
		int res = 0;
		
		for (int i = 0; i < ar.size(); i++)
			res += Math.pow(2,ar.get(i));		
		
		return res;
	}


}

