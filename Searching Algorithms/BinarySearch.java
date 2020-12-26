import java.util.Scanner;

class BinarySearch
{
	//Declare unsorted list variable
	static int[] list;
	
	public static void main(String[] args) {
		//Validate Usage
  		if (args.length == 0) {
			System.out.println("Valid Usage: (Filename).java (n.. whereas the list contains 0 - n) or (sorted numbers)");
			System.out.println("example: BinarySearch.java 100");
			System.out.println("example: BinarySearch.java 1 2 3 4 5");
			return;
		}
		else if (args.length == 1) {
			//Initialize the list
			list = new int[Integer.parseInt(args[0])];
			for (int i = 0; i < list.length; i++) {
				list[i] = i;
			}
		}
		else {
			//Initialize the list
			list = new int[args.length];
			for (int i = 0; i < list.length; i++) {
				list[i] = Integer.parseInt(args[i]);
			}
		}
		
		//Ask the user for the required element to be searched
		Scanner sc = new Scanner(System.in);
		System.out.println(); //Leave a space
		System.out.print("Search for num: ");
		int num = sc.nextInt();
		System.out.println(); //Leave a space
		
		//Test binarySearch Function
		double t1 = System.currentTimeMillis();
		int found = binarySearch(list, 0, list.length-1, num);
		double t2 = System.currentTimeMillis();
		
		if (found > -1)
			System.out.println("Found it with binarySearch at index " +
			found + " in " + String.format("%.3f", (t2 - t1)/1000) + " seconds");
		else
			System.out.println("Didn't find it with binarySearch");
	}
	
	/*Linear Search Function
	*arr: the array in which the num supposed to be
	*f: the first index of arr
	*l: the last index of arr
	*num: the number which we are looking for in arr
	*/
	public static int binarySearch(int[] arr, int f, int l, int num) {
		
		//Will be true, when we search for a num that's not in arr
		if (f > l)
			return -1;
		
		int m = (f + l) / 2; //The middle index, which is between f and l
		int mid = arr[m]; //A temporary variable to carry arr[m] value
		
		if (mid == num)
			return m;
		else if (mid < num)
			return binarySearch(arr, m+1, l, num); //Search in the right part
		else
			return binarySearch(arr, f, m-1, num); //Search in the left part
			
	}
}


