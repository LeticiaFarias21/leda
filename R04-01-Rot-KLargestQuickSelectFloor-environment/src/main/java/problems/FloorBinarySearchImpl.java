package problems;

import java.util.Arrays;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (inputCheck(array) == false){
			return null;
		}
		sort(array, 0 , array.length - 1);
		if ( integerCheck(array, x) == true) {
			return buscaBinariaFloor(array, x, 0, array.length - 1);
		}

		return null;
	}
	private Integer buscaBinariaFloor(Integer[] array, int key, int from, int to) {

		int middle = (from + to) / 2;

		if(from > to)
			return array[to];
		if (key < array[middle])
			return buscaBinariaFloor(array, key, from, middle - 1);
		else if (key > array[middle])
			return buscaBinariaFloor(array, key, middle + 1, to);
		else
			return array[middle];
	}

	private boolean inputCheck(Integer[] array) {
		if (array == null){
			return false;
		}
		if (array.length == 0 ){
			return false;
		}
		return true;
	}

	private boolean integerCheck(Integer[] array, Integer x){
		if(array[0] > x){
			return false;
		}
		return true;
	}
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
