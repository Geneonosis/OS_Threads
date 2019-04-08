import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Random rand = new Random();
		int max = 100;
		int min = 0;
		int n = Integer.parseInt(args[0]);
		
		System.out.println("N = " + n);
		
		double darray[] = new double[n];
		double darray2[] = new double[n];

		fillArray(rand, max, min, darray);
		fillArray(rand, max, min, darray2);
		
		ArraySeparation bs = new ArraySeparation(darray);
		ArraySeparation bs2 = new ArraySeparation(darray2);
		//bs.print_array();
		
		//get a time report:
		Date date = new Date();
		long timeMilli = date.getTime();
		
		//sort the first array using bubble sort
		Thread object = new Thread(new BubbleSort(bs.getSubArray1()));
		object.start();
		
		//sort the second array using bubble sort
		Thread object2 = new Thread(new BubbleSort(bs.getSubArray2()));
		object2.start();
		
		try {
			object.join();
			object2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//merge them together with a third thread
		Thread object3 = new Thread(new InsertionSort(bs.getSubArray1(),bs.getSubArray2(),n));
		object3.start();
		
		try {
			object3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Get the time in milliseconds after the fact
		Calendar calendar = Calendar.getInstance();
		long timeMilli2 = calendar.getTimeInMillis();
		long timeMilli3 = timeMilli2 - timeMilli;
		System.out.println("Time in milliseconds using 3 threads: " + timeMilli3 + " ms");
		
		Date date2 = new Date();
		long timeMilli4 = date2.getTime();
		
		noThreads(n, bs2);
		
		Calendar calendar2 = Calendar.getInstance();
		long timeMilli5 = calendar2.getTimeInMillis();
		long timeMilli6 = timeMilli5 - timeMilli4;
		System.out.println("Time in milliseconds using 1 threads: " + timeMilli6 + " ms");
	
	}

	/**
	 * @param n
	 * @param bs2
	 */
	private static void noThreads(int n, ArraySeparation bs2) {
		BubbleSort bubbleSort2 = new BubbleSort(bs2.getSubArray1());
		BubbleSort bubbleSort3 = new BubbleSort(bs2.getSubArray2());
		bubbleSort2.bubbleSort();
		bubbleSort3.bubbleSort();
		InsertionSort insertSort1 = new InsertionSort(bs2.getSubArray1(), bs2.getSubArray2(), n);
		insertSort1.insertionSort();

	}

	/**
	 * 
	 * @param rand
	 * @param max
	 * @param min
	 * @param darray
	 */
	private static void fillArray(Random rand, int max, int min, double[] darray) {
		for (int i = 0; i < darray.length; i++) {
			darray[i] = rand.nextInt((max - min) + 1) + min;
		}
	}
}
