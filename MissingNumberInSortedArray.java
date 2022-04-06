/**
Find the Missing Number in a sorted array

Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list.
Write an efficient code to find the missing integer. 
*/
public class Main {
	public static int findMissingNumber(int ar[], int n) {
		
        int low = 0, high = ar.length - 1;
        int mid = 0;
        
        // Missing first number
        if (ar[low] - low == 2) {
            System.out.println("First number is missing");
            return 1;
        }
        
        // Either no number is missing or the last number is missing
        if (ar[low] - low == 1 && high - low == ar[high] - ar[low]) {
            // No number is missing
            if (ar.length == n) {
                System.out.println("No number is missing");
                return -1;
            } else { // last number missing
                System.out.println("Last number is missing");
                return n;
            }
        }
        
        while (high > low + 1)
        {
            mid = low + (high - low) / 2;
            if ((ar[low] - low) != (ar[mid] - mid))
                high = mid;
            else
                low = mid;
        }
        return (ar[low] + 1);
	}

	public static void main(String args[]) {
		int arr[] = new int[] {1,2,3,4,5};
		System.out.println(findMissingNumber(arr, 6));
	}
}