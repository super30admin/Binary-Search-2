class Solution {
    public int findMin(int[] nums) {
        // Check if the input array is null or empty
        if(nums==null || nums.length==0)
            return -1; // Return -1 if the array is empty or null
        
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            // Check if the current subarray is already sorted, in that case, return the minimum element
            if(nums[low]<=nums[high])
                return nums[low];
            
            int mid = low+(high-low)/2; // Calculate the middle index to prevent integer overflow
            
            // Check if the middle element is the minimum element
            if((mid==low || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1]))
                return nums[mid];
            
            // If the array is not sorted, update the low or high pointers accordingly
            if(nums[low]<=nums[mid])
                low=mid+1; // Search in the right half of the array
            else
                high=mid-1; // Search in the left half of the array
        }
        return -1; // Return -1 if the minimum element is not found
    }
}

//Time Complexity: O(logn) for Binary Search
//Space Complexity: O(1)
