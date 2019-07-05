//reference https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/

class searchInSortedArray{
	static int findMin(int[] nums, int low, int high) {
		int mid = low+(high-low)/2;
		// If there is only one element left 
		if(low== high) return nums[low];
		
		// This condition is needed to handle the case when array 
        // is not rotated at all
		if(low>high) return nums[0];
		
		 // Check if element (mid+1) is minimum element. Consider 
        // the cases like {3, 4, 5, 1, 2} 
		if(mid<high && nums[mid+1]<nums[mid]) return nums[mid+1];
		
		 // Check if mid itself is minimum element 
		if(mid>low && nums[mid]< nums[mid-1]) return nums[mid];
		
		if(nums[mid]<high) return findMin(nums,low,mid-1);
		else return findMin(nums,mid+1,high);
	}
	
}


public class FindMin
{
	public static void main(String[] args) {
		int[] input = {4,5,6,7,0,1,2};
		
		for (int i =0 ; i<input.length;i++) {
			System.out.println("input array  is ="+input[i]);
		}
	
		int min = searchInSortedArray.findMin(input,0,input.length);
		
		System.out.println("minimum element is="+min);
	}

}
