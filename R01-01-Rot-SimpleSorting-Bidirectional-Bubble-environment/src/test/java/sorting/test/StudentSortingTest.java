package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.Sorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	private Integer[] vetorAluno;
	private AbstractSorting<Integer> implementationBubbleSort;
	private AbstractSorting<Integer> implementationInsertionSort;
	private AbstractSorting<Integer> implementationSelectionSort;
	private AbstractSorting<Integer> implementationBidirectionalBubbleSort;
	private AbstractSorting<Integer> implementationRecursiveBubbleSort;
	private AbstractSorting<Integer> implementationRecursiveSelectionSort;


	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorAluno(new Integer[] { 8, 6, 66, 98, 85, 4, 78, 4 });
		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementationBubbleSort = new BubbleSort<Integer>();
		this.implementationInsertionSort = new InsertionSort<Integer>();
		this.implementationSelectionSort = new SelectionSort<Integer>();
		this.implementationBidirectionalBubbleSort = new BidirectionalBubbleSort<Integer>();
		this.implementationRecursiveBubbleSort = new RecursiveBubbleSort<Integer>();
		this.implementationRecursiveSelectionSort = new RecursiveBubbleSort<Integer>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorAluno(Integer[] arrayPadrao) {
		this.vetorAluno = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		Arrays.sort(copy1);
		implementationBubbleSort.sort(array);
		Assert.assertArrayEquals(copy1, array);
		implementationInsertionSort.sort(array);
		Assert.assertArrayEquals(copy1, array);
		implementationSelectionSort.sort(array);
		Assert.assertArrayEquals(copy1, array);
		implementationBidirectionalBubbleSort.sort(array);
		Assert.assertArrayEquals(copy1, array);
		implementationRecursiveBubbleSort.sort(array);
		Assert.assertArrayEquals(copy1, array);
		implementationRecursiveSelectionSort.sort(array);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	public void testSort06() {
		genericTest(vetorAluno);
	}

		// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}