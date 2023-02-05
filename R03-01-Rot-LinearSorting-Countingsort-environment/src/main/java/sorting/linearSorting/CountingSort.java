package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length > leftIndex && array != null) {

			int[] B = new int[rightIndex - leftIndex + 1];
			int max = maxValue(array, leftIndex, rightIndex);
			int[] C = new int[max + 1];

			cumulativa(array, C, leftIndex, rightIndex, max);
			somaCumulativa(C, max);
			sortAuxiliar(array, C, B, leftIndex, rightIndex);
			ordenaArray(array, B, leftIndex, rightIndex);

		}
	}

	public int maxValue(Integer[] array, int leftIndex, int rightIndex){
		int max = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > max)
				max = array[i];
		}
		return max;
	}

	public void cumulativa(Integer[] array,int[] C, int leftIndex, int rightIndex, int max){
		for(int i=leftIndex; i<=rightIndex; i++){
			C[array[i]]++;
		}
	}

	public void somaCumulativa(int[] C, int max){
		for(int i=1; i<=max; i++){
			C[i] += C[i-1];
		}
	}

	public void sortAuxiliar(Integer[] array, int[] C, int[] B, int leftIndex, int rightIndex){
		for(int i=rightIndex; i>=leftIndex; i--){
			C[array[i]]--;
			B[C[array[i]]] = array[i];
		}
	}
	public void ordenaArray(Integer[] array, int[] B, int leftIndex, int rightIndex){
		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = B[i - leftIndex];
		}
	}
}