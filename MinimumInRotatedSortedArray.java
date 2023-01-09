// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: We know that in a rotated sorted array atleast 1 part is sorted. 
// We perform binary search to find the mid and check the left and right of mid to see if the elements are sorted 
// If not, based on the high and low pointer value we adjust our high and low pointers and find the minimum


class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int n=nums.length;
        int high=n-1;
        
        while(low<=high){
            
            // if the array is already sorted
            if(nums[low]<=nums[high]) return nums[low];
            
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid] < nums[mid-1]) && nums[mid] < nums[mid+1]){ 
                // we dont do mid==n-1 because we already 
                //handled that on line 10
                return mid;
            } else if (nums[low] <= nums[mid]){
                // if we have not reached the middle, we check
                // if the left side is sorted we reject the left side
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return -1;
    }
}