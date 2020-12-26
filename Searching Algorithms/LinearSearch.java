import java.util.Scanner;

class LinearSearch
{
	//Declare unsorted list variable
	static int[] list;
	
	public static void main(String[] args) {
		//Validate Usage
  		if (args.length == 0) {
			System.out.println("Valid Usage: (Filename).java (n.. whereas the list contains 0 - n)");
			System.out.println("example: LinearSearch.java 100");
			System.out.println("example: LinearSearch.java 12342");
			return;
		}
		
		//Initialize the list
		list = new int[Integer.parseInt(args[0])];
		for (int i = 0; i < list.length; i++) {
			list[i] = i;
		}
		
		//Ask the user for the required element to be searched
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Search for num: ");
		int num = sc.nextInt();
		System.out.println();
		
		//Test linearSearch Function
		double t1 = System.currentTimeMillis();
		boolean found = linearSearch(list, 0, num);
		double t2 = System.currentTimeMillis();
		
		if (found)
			System.out.println("Found it with linearSearch in " + 
			String.format("%.3f", (t2 - t1)/1000) + " seconds");
		else
			System.out.println("Didn't find it with linearSearch");
		
		//Test modified_linearSearch Function
		t1 = System.currentTimeMillis();
		found = modifiedLinearSearch(list, 0, list.length-1, num);
		t2 = System.currentTimeMillis();
		
		if (found)
			System.out.println("Found it modified_linearSearch in " + 
			String.format("%.3f", (t2 - t1)/1000) + " seconds");
		else
			System.out.println("Didn't find it with modifiedLinearSearch");
	}
	
	/*Linear Search Function
	*arr: the array in which the num supposed to be
	*i: the first index of the list
	*num: the number which we are looking for in arr
	*/
	public static boolean linearSearch(int[] arr, int i, int num) {
	
		if (i >= arr.length)
			return false;
		else if (arr[i] == num)
			return true;
		else
			return linearSearch(arr, i + 1, num);
		
	}
	
	/*Modified Linear Search
	*arr: the array in where the num supposed to be
	*l: the first index of the list
	*r: the last index of the list
	*num: the number which we are looking for in arr
	*/
	public static boolean modifiedLinearSearch(int[] arr, int l, int r, int num) {
		
		if (l > r)
			return false;
		else if (arr[l] == num || arr[r] == num)
			return true;
		else
			return modifiedLinearSearch(arr, l+1, r-1, num);
		
	}
}


