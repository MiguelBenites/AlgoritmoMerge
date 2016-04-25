/**
 * Exercicio MergeSort
 * 
 * @author See more at:http:// www.java2novice.com/java-sorting-algorithms/merge-sort/#sthash.BnHKO4ZO.dpuf
 *
 */
public class MergeSort {

	private int[] array;
	private int[] tempMergArr;
	private int length;

	/**
	 * App, Chama o MergeSort para ordenar o array passado como parâmetro
	 * @param a
	 */
	public static void main(String a[]) {
		int[] inputArr = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43, 35 };
		MergeSort mms = new MergeSort();
		mms.sort(inputArr);
		for (int i : inputArr) {
			System.out.print(i);
			System.out.print(" ");
		}
		// final do array deve ser: 4 11 23 28 35 43 45 65 77 89 98
	}

	/**
	 *  
	 * @param inputArr
	 */
	public void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}
	
	/**
	 * Algoritmo para o MergeSort...
	 * 
	 * @param lowerIndex
	 * @param higherIndex
	 */
	private void doMergeSort(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			
			
			
			System.out.print("Lower: "+lowerIndex+"Higher: "+higherIndex+"\n");
			// flag para o meio do array...
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			System.out.print("Middle: "+middle+"\n");
			
			// Recursão....
			
			// Ordenar do inicio até o meio...
			doMergeSort(lowerIndex, middle);
			
			// Ordenar do meio + 1, até o fim...
			doMergeSort(middle + 1, higherIndex);
			
			// Junta os lados...
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}
	
	/**
	 * MergeParts
	 * 
	 * 
	 * 
	 * @param lowerIndex
	 * @param middle
	 * @param higherIndex
	 */
	private void mergeParts(int lowerIndex, int middle, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}
	}
}
