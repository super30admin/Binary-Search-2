// Time Complexity : O(log n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

public class FindMinInSortedArray {
	
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) 
            return -1;

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            //Completely sorted array
            if(nums[low] <= nums[high]) return nums[low];

            int mid = low + (high - low)/2;
            //mid is smaller tha it's neighbors'
            if((mid == 0 || (nums[mid] < nums[mid -1])) 
                    && (nums[mid] < nums[mid + 1])){
                return nums[mid]; 
            }
            //check left sorted -> min on the right
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            // right sorted -> min on the left
            else{
                high = mid - 1;
            }
        }
        return 5001;       
    }

	public static void main(String[] args) {
		
		FindMinInSortedArray obj = new FindMinInSortedArray();
		int[] nums = {2,1};
		
		int min = obj.findMin(nums);
		System.out.println("Min : " + min);

	}

}
