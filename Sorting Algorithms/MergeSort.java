import java.util.*;

public class MergeSort
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
	
	
	/*MergeSort Recursive Function
	*p1: The list which needs to be sorted.
	*p2: The index of the first element.
	*p3: The index of the last element.
	*/
	public static void sort(int[] list, int start, int end) {
	
		if (start < end) {
			int mid = (start + end) / 2;
			sort(list, start, mid);
			sort(list, mid+1, end);
			merge(list, start, mid, end);
		}
		
	}
	
	/*Merge function, used for merge sort
	*p1: The list which needs to be sorted.
	*p2: The initial index of the first part
	*p3: The initial index of the second part OR The last index of the first part.
	*p4: The last index of the second part.
	*/
	public static void merge(int[] list, int start, int mid, int end) {
		
		//Initialize a temporally array to sort the list in it
		int[] temp = new int[end - start + 1];
		
		/*
		*s: the start of the list
		*m: the middle field of the list
		*k: the positon in temp array in which the value will be written 
		*/
		int s = start, m = mid+1, k = 0;
		
		//Move values from list to temp, sorted
		while (s <= mid && m <= end) {
			//Check which value should be put first list[s] or list[m]
			//and repeat the condition untill s or m be out of bounds
			if(list[s] <= list[m]) {
				temp[k] = list[s];
				k++; s++;
			}
			else {
				temp[k] = list[m];
				k++; m++;
			}
		}
		
		//If m became out of bounds before s
		while (s <= mid) {
			temp[k] = list[s];
			k++; s++;
		}
		
		//If s became out of bounds before m
		while (m <= end) {
			temp[k] = list[m];
			k++; m++;
		}
		
		//Override the list with temp array values
		for(int i = start; i <= end; i++) {
			list[i] = temp[i - start];
		}
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
