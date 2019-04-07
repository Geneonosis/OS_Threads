import java.util.ArrayList;
import java.util.Arrays;
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
		double darray[] = new double[n];

		for (int i = 0; i < darray.length; i++) {
			darray[i] = rand.nextInt((max - min) + 1) + min;
		}
		
		bubbleSort bs = new bubbleSort(darray);
		bs.print_array();
		
		System.out.println(n);
		for (int i = 0; i < 2; i++) {
			Thread object = new Thread(new MultithreadingDemo(bs.getSubArray1(),bs.getSubArray2()));
			object.start();
		}
	}
	
	public static String example() {
		String str = null;
		str = "hello world";
		return str;
	}
}
