class InsertionSort
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
		
		for (int i = 1; i < list.length; i++) {
			//Save the value of i index to be inserted in (k + 1) position later
			//cuz it will be overridden after shifting step
			int val = list[i];
			
			//Initialize k variable, and use it in for loop to check all prev elements
			int k = i - 1;
			for (; k >= 0; k--) {
				//if the current k value is smaller than {val}, so (k+1) is the insertion pos
				if (list[k] < val) 
					break;
					
				//Shift every element to the right
				list[k + 1] = list[k];
			}
			
			//Finally, insert list[i] in the investigated index (position)
			list[k + 1] = val;
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
