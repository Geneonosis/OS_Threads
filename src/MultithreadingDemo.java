
public class MultithreadingDemo implements Runnable{

	private double []_arr1 = null;
	public MultithreadingDemo(double[] subArray1) {
		// TODO Auto-generated constructor stub
		this._arr1 = subArray1;
		System.out.println("test" + _arr1[0]);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//Displaying the thread that is running
			System.out.println("Thread " +
				Thread.currentThread().getId() + " is running");
		}
		catch(Exception e) {
			//throwing an exception
			System.out.println("Exception is caught");
		}
	}
}
