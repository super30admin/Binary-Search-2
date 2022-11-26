//Time Complexity :O(logN)
//Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this : No 


public class FindMinimumInSortedArray {
	
	 public int findMin(int[] nums) {
	        
	        int low =0;
	        int high = nums.length-1;
	    
	        while(low<=high){

	         // check if array already sorted 
	         if(nums[low]<nums[high])
	            return nums[low];       
	        
	        // find minimum
	        int mid = low + (high-low)/2;

	        if((mid==nums.length-1||nums[mid]<nums[mid+1]) && (mid==0|| nums[mid]<nums[mid-1])){
	            return nums[mid];
	        }
	            
	            // find the unsorted side 
	            if(nums[low]<=nums[mid])
	                low = mid+1;
	            else
	                high = mid-1;
	        }

	        return -1;
	    }
}
