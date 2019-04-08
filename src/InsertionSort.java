
public class InsertionSort implements Runnable {

	private double [] _arr1;
	private double [] _arr2;
	private double [] _InsertedSortedArr;
	private int _size;
	
	public InsertionSort(double[] subArray1, double[] subArray2, int size) {
		this._arr1 = subArray1;
		this._arr2 = subArray2;
		this._size = size;
		_InsertedSortedArr = new double[size];
	}

	@Override
	public void run() {
		try {
			//Displaying the thread that is running
			//System.out.println("Thread " + Thread.currentThread().getId() + " is running");
			insertionSort();
			//printArr();
			//run a bubble sort!
		}
		catch(Exception e) {
			//throwing an exception
			System.out.println("Exception is caught");
		}
	}
	
	
	public void printArr() {
		for(int i = 0; i < _InsertedSortedArr.length; i++) {
			System.out.println("index: " + i + " : " + _InsertedSortedArr[i]);
		}
	}
	/***
	 * 
	 */
	public void insertionSort() {
		int i,j,k;
		i = j = k = 0;
		for(i = 0; i < _size; i++) {
			if(j < _arr1.length && k < _arr1.length) {
				if(_arr1[j] < _arr2[k]) {
					_InsertedSortedArr[i] = _arr1[j];
					j++;
				}else if(_arr1[j] > _arr2[k]) {
					_InsertedSortedArr[i] = _arr2[k];
					k++;
				}else if(_arr1[j] == _arr2[k]) {
					_InsertedSortedArr[i] = _arr1[j];
					j++;
					i++;
					_InsertedSortedArr[i] = _arr2[k];
					k++;
				}
			}else if(j == _arr1.length) {
				//Parse the rest of the way
				_InsertedSortedArr[i] = _arr2[k];
				k++;
			}else {
				_InsertedSortedArr[i] = _arr1[j];
				j++;
			}
		}
		return;
	}

}
