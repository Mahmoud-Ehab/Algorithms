class SelectionSort
{
	//Declare unsorted list variable
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
		sort(unsortedList);
		System.out.println("Sorted: " + printList(unsortedList));
	}
	
	//Sort Algorithm Function 
	private static void sort(int[] list) {
	
		//loop over all elements (indexes) to sort it by selection
		for (int i = 0; i < list.length; i++) {
			int min = i; //The index of the minimum value we got
			
			//Update min variable, if there is value smaller than list[min]
			for (int k = i+1; k < list.length; k++) {
				if (list[k] < list[min]) min = k;
			}
			
			//Spaw the values between the i index and the selected index min
			int temp = list[i];
			list[i] = list[min];
			list[min] = temp;
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
