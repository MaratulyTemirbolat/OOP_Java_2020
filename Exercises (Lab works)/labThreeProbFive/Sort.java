package labThreeProbFive;
import java.util.Arrays;
public class Sort {
	static <E> void swap(E [] array, int i, int j) {
		E temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	static <E extends Comparable<E>> void bubbleSort(E [] array) {
		for(int k=0;k<array.length-1;k++) {
			for(int j = k+1;j<array.length;j++) {
				if((array[k].compareTo(array[j]))>0)	//CHECK!
					swap(array,k,j);
			}
		}
	}
	static <E extends Comparable<E>> void quickSort(E [] array) {
		Arrays.sort(array); 					//CHECK
	}
	static <E extends Comparable<E>> void merge(E [] array, int left, int middle, int right ) {
		int n1 = middle - left + 1;	//Length of the left sub-array
		int n2 = right - middle;		//Lenght of the right sub-array
		E[] L = (E[])new Comparable[n1];	// Create an array with the size "n1"
		E[] R = (E[])new Comparable[n2];	// Create an array with the size "n2"
		for(int k=0;k<n1;k++){
		L[k] = array[left+k];		// Fill in the array with the left part
}
		for (int k = 0;k<n2;k++){
		R[k] = array[middle+1+k];	// Fill in the array with the right part
}
		int ukazatel1 =0;		// Pointer for the left part of the array
		int ukazatel2 = 0;		// Pointer for the right part of the array
		int position = left;
		while(ukazatel1<n1 && ukazatel2 < n2){
		if(L[ukazatel1].compareTo(R[ukazatel2]) <= 0){
		array[position] = L[ukazatel1];
		ukazatel1++;
}
		else{
		array[position] = R[ukazatel2];
		ukazatel2++;		
}
		position++;
}
		while(ukazatel1 < n1){
		array[position] = L[ukazatel1];
		ukazatel1++;
		position++;
}
		while(ukazatel2 < n2){
		array[position] = R[ukazatel2];
		ukazatel2++;
		position++;
}	
}
		static <E extends Comparable<E>> void mergeSort(E [] array, int left, int right ) {
		if(left < right){	// at least 2 elements
		int middle = (left+right)/2;
		mergeSort(array,left,middle);
		mergeSort(array,middle+1,right);
		merge(array,left,middle,right);		
}	
}
}
