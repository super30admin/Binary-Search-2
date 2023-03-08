// Binary search; if the element at mid is greater than the element at the end, the min value lies in the
// second half, update start index, else min element lies in the first half; at the end, return the low/start index
// Time complexity: O(log n)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




public class MinimumInASortedRotatedArray {
	
	    public int findMin(int[] nums) {
	        int mid = 0;
	        int len = nums.length-1;
	        int low = 0;
	        int high = len;
	        while(low < high){
	            mid = (low+high)/2;
	            if(nums[mid] > nums[high]){
	                low = mid+1;
	            }
	            else
	                high = mid;
	        }
	        return nums[low];
	    
	}

}
