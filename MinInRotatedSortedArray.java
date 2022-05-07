/**
Input: nums = [3,4,5,1,2]
Output: 1
			   0,1,2,  3,  4,5,6	
Input: nums = [4,5,6,  7,  0,1,2]
Output: 0


low = 0; // 4
high = nums.length -1; // 6

// the minimum will always lie in the unsorted part
while(low <= high)
{
	int mid = low + (high-low)/2; 3
	
	leftPartSorted = nums[low] <= nums[mid];
	rightPartSorted = nums[high] >= nums[mid];

	if(leftPartSorted && rightPartSorted)
		return low;

	if(leftPartSorted)
		low = mid + 1;
	else
		high = mid -1;
	
}
**/
class Solution {
	public int findMin(int[] nums) 
	{
		int low = 0;
		int high = nums.length-1;

		while(low <= high)
		{
            if(nums[low] <= nums[high])
                return nums[low];
            
			int mid = low + (high - low)/2;
			boolean leftPartSorted = nums[low] <= nums[mid];  

            
            if((mid ==0 || nums[mid] < nums[mid-1]) 
               && (mid == nums.length -1 || nums[mid] < nums[mid+1]))
            {
                return nums[mid];
            }
            else if(leftPartSorted)
            {
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }

		}

		return Integer.MAX_VALUE;
        
    }
}