package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > leftIndex && array != null) {

			int[] B = new int[rightIndex - leftIndex + 1];
			int[] maxMinValue = maxMinValue(array, leftIndex, rightIndex);
			int max = maxMinValue[1];
			int min = maxMinValue[0];
			int[] C = new int[max - min + 1];
			cumulativa(array, C, leftIndex, rightIndex, max, min);
			somaCumulativa(C, max, min);
			sortAuxiliar(array, C, B, leftIndex, rightIndex, min);
			ordenaArray(array, B, leftIndex, rightIndex);

		}
	}
	public int[] maxMinValue(Integer[] array, int leftIndex, int rightIndex){
		int min = array[leftIndex];
		int max = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] < min)
				min = array[i];
			if (array[i] > max)
				max = array[i];
		}
		int[] retorno = {min,max};
		return retorno;
	}
	public void cumulativa(Integer[] array,int[] C, int leftIndex, int rightIndex, int max, int min){
		for (int i = leftIndex; i <= rightIndex; i++)
			C[array[i] - min]++;
	}
	public void somaCumulativa(int[] C, int max, int min){
		for (int i = 1; i <= (max - min); i++)
			C[i] += C[i - 1];
	}

	public void sortAuxiliar(Integer[] array, int[] C, int[] B, int leftIndex, int rightIndex, int min){
		for (int i = rightIndex; i >= leftIndex; i--) {
			C[array[i] - min]--;
			B[C[array[i] - min]] = array[i];
		}
	}
	public void ordenaArray(Integer[] array, int[] B, int leftIndex, int rightIndex){
		for (int i = leftIndex; i <= rightIndex; i++)
			array[i] = B[i - leftIndex];
	}

}
