// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
	
public class MinimumInRotatedSortedArray {
	
	public static int findMin(int[] nums) {
		
		if(nums == null || nums.length == 0) return -1;
		int low = 0, high = nums.length - 1;
		while(low <= high)
		{
			if(nums[low] <= nums[high] ) return nums[low];
			int mid = low + (high - low)/2;
			if((mid == 0 || nums[mid-1] > nums[mid]) 
					&& (mid == high || nums[mid+1] > nums[mid] ))
				return nums[mid];
			else if(nums[mid] >= nums[low])
				low = mid + 1;
			else
				high = mid - 1;
		}
	        
	return -1;   
	}

	public static void main(String[] args) {
		
		int[] arr = {4,5,6,7,0,1,2};
		System.out.println(findMin(arr));

	}

}
