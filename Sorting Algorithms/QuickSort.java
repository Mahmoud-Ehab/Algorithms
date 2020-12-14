import java.util.*;

public class QuickSort
{
	
	/*
	Author: Mahmoud Ehab
	Date: 30/11/2020
	*/
	//Declare unsorted list variable to be filled with user inputs
	static int[] unsortedList;
	
	public static void main(String[] args) {
		//Validate Usage
  		if (args.length == 0) {
			System.out.println("Valid Usage: (Filename).java (Elements of unsorted list)");
			System.out.println("example: SelectionSort.java 3 2 4 1");
			return;
		}
		
		//Initialize the unsortedList variable
		unsortedList = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			unsortedList[i] = Integer.parseInt(args[i]);
		}
		
		//Print the list before and after sort
		System.out.println("Unsorted: " + printList(unsortedList));
		sort(unsortedList, 0, unsortedList.length - 1);
		System.out.println("Sorted: " + printList(unsortedList));
	}
	
	
	/*QuickSort Recursive Function
	*p1: The list which needs to be sorted.
	*p2: The first index of the list.
	*p3: The last index of the list.
	*p2 and p3 helps us divide the list easly while recursion.
	*/
	public static void sort(int[] list, int start, int end) {
	
		//Return from the function if the start is the end
		if (start >= end)
			return;
		
		int pivot = list[end];
		
		int k = start - 1; //Index of the last smaller number we investigate
		
		for (int i = start; i < end; i++) {
			//Shift every value less than the pivot to the left of k
			if (list[i] <= pivot) {
				int temp = list[i];
				list[i] = list[k + 1];
				list[k + 1] = temp;
				k++;
			}
		}
		//Put the pivot in its correct place
		int temp = list[end];
		list[end] = list [k + 1];
		list[k + 1] = temp;
		
		sort(list, start, k); //Sort left division
		sort(list, k + 1, end); //Sort right division
		
	}
	
	//Abstract Function for printing lists items
	//Convert List into String
	private static String printList(int[] list) {
		String temp = "";

		for (int integer : list)
			temp += integer + " ";

		return temp;
	}
}
