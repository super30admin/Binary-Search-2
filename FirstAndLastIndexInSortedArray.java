// Time Complexity : O(log n)+ O(log m) //there are two binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class FirstAndLastIndexInSortedArray {
	
	public static int binarySearchForFirstIndex(int[] nums, int target)
	{
		int low = 0, high = nums.length-1;
		if(nums == null || nums.length == 0) return -1;
	
		while(low <= high)
		{
		
			int mid = low + (high - low)/2;
			if(nums[mid] == target)
			{
				if(mid == low || nums[mid-1] != target)
				{
					return mid;
				}
				else
				{
					high = mid - 1;
				}
			}
			else if(nums[mid] > target)
			{
				high = mid -1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static int binarySearchForLastIndex(int[] nums, int target, int low, int high)
	{
		if(nums == null || nums.length == 0) return -1;
	
		while(low <= high)
		{
			int mid = low + (high - low)/2;
			if(nums[mid] == target)
			{
				if(mid == high || nums[mid+1] != target)
				{
					return mid;
				}
				else
				{
					low = mid + 1;
				}
			}
			else if(nums[mid] > target)
			{
				high = mid -1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static int[] searchRange(int[] nums, int target)
	{
		int[] result = {-1,-1};
		
		result[0] = binarySearchForFirstIndex(nums, target);
		if (result[0] == -1) return result;
		result[1] = binarySearchForLastIndex(nums, target, result[0], nums.length-1);
	
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int[] r = searchRange(arr,6);
		System.out.println(r[0]+"   : "+r[1]);

	}

}
