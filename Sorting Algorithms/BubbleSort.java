class BubbleSort
{

	//Declare unsorted list variable
	static int[] unsortedList;
	
	public static void main(String[] args) {
		//Validate Usage
		if (args.length == 0) {
			System.out.println("Valid Usage: (Filename).java (Elements of unsorted list)");
			System.out.println("example: BubbleSort.java 3 2 4 1");
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
	
	//BubbleSort Algorithm Function 
	private static void sort(int[] list) {

		/*
		*loop over the list (length - 1) times, 
		*as this's the maximum no.times for it to be sorted.
		*/
		for (int i = 0; i < list.length - 1; i++) {
			//Declare boolean variable to investigate if the list sorted or not yet
			boolean again = false;
			
			//For loop to shift the biggest number to the right by several swaps
			for (int k = 0; k < list.length - 1 - i; k++) {
				//Check swap condition
				if (list[k] > list[k + 1]) {

					int temp = list[k];
					list[k] = list[k + 1];
					list[k + 1] = temp;
					again = true;

				}
			}
			
			//Will be true if nothing swaped (all element are in the correct position)
			if (!again) break;
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

