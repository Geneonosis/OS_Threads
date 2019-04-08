
public class BubbleSort implements Runnable{

	private double []_arr1 = null;
	
	public BubbleSort(double[] subArray1) {
		this._arr1 = subArray1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//Displaying the thread that is running
			//System.out.println("Thread " + Thread.currentThread().getId() + " is running");
			bubbleSort();
			//printSortedArray();
			//run a bubble sort!
		}
		catch(Exception e) {
			//throwing an exception
			System.out.println("Exception is caught");
		}
	}
	
	public void bubbleSort() {
		int i = 0;
		int j = 0;
		double temp = 0;
		for(i = 0; i < _arr1.length; i++) {
			for(j = i; j < _arr1.length; j++) {
				if(_arr1[i] > _arr1[j]) {
					//swap
					temp = _arr1[i];
					_arr1[i] = _arr1[j];
					_arr1[j] = temp;
				}
			}
		}
	}
	
	public double []getSortedArray(){
		return _arr1;
	}
	
	public void printSortedArray() {
		for(int i = 0; i < _arr1.length; i++) {
			System.out.println(_arr1[i]);
		}
	}
}
