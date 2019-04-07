public class bubbleSort {
	private double []_array = null;
	private double []_subArray_1 = null;
	private double []_subArray_2 = null;
	
	bubbleSort(double []array){
		set_array(array);
		//determine the size of the sub arrays
		determineLength();
		set_sub_array();
	}

	private void determineLength() {
		if(_array.length % 2 == 0) {
			//even
			_subArray_1 = new double[_array.length/2];
			_subArray_2 = new double[_array.length/2];
		}else {
			//odd
			_subArray_1 = new double[_array.length/2];
			_subArray_2 = new double[_array.length/2 + 1];
		}
	}

	public double[] get_array() {
		return _array;
	}

	private void set_array(double[] array) {
		this._array = array;
	}
	
	public void print_array() {
		for(int i = 0; i < _array.length; i++) {
			System.out.println("_array[" + i + "] = " + _array[i]);
		}
		for(int i = 0; i < _subArray_1.length; i++) {
			System.out.println("_subArray_1[" + i + "] = " + _subArray_1[i]);
		}
		for(int i = 0; i < _subArray_2.length; i++) {
			System.out.println("_subArray_2[" + i + "] = " + _subArray_2[i]);
		}
	}
	
	/***
	 * function: set_sub_array
	 * usage: set_sub_array()
	 * ======================
	 * purpose: sets up the sub arrays to be ordered
	 */
	private void set_sub_array() {
		int k = 0;
		for(int i = 0; i < _array.length; i++) {
			if(i < _subArray_1.length) {
				_subArray_1[i] = _array[i]; 
			}else{
				_subArray_2[k] = _array[i];
				k++;
			}
		}
	}
	
	public void ActualSort() {
		
	}
}
