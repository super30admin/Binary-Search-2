//Time Complexity - O(log n )
//Space Complexity - O(1)
//Ran in Leetcode - Yes

class Solution {
    public int findMin(int[] nums) {
        int middle = 0;
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			middle = low + (high - low) / 2;
            if(nums[middle] < nums[high]){
                high = middle - 1;
            }
			else 
				low = middle + 1;	
		}
		return nums[middle];
    }
}