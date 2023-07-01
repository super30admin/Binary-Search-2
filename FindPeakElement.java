// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class FindPeakElement {
	
	public static int findPeakElement(int[] nums) {
		
		if(nums == null || nums.length == 0) return -1;
		
		int low = 0, high = nums.length - 1;
		while(low <= high)
		{
			int mid = low + (high - low)/2;
			if((mid == 0 || nums[mid] > nums[mid - 1]) && 
					(mid == high || nums[mid] > nums[mid + 1])) return mid;
			else if(nums[mid + 1] > nums[mid])
			{
				low = mid + 1;
			}
			else
				high = mid - 1;
		}
		return -1;
	}
	 

	public static void main(String[] args) {
		int[] arr = {1,2,3,1};
		System.out.println(findPeakElement(arr));
	}

}
