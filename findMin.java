// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 Divide the array into two halves and individually check if the minimum is present there. 
 The minimum is present when it is greater than the element on its left and on its right. 
 If the array is sorted, then the lowest element is returned as minimum. 
 */

class findMin {
    public int findMin(int[] nums) {
        int low=0; 
        int high= nums.length-1;
        int n = nums.length;
        if(nums==null || nums.length==0)
        return -1;
        while(low <= high){
            if(nums[low] <= nums[high])
            return nums[low];
            int mid = low+high-low/2;
            if(mid==0 || nums[mid]< nums[mid-1]&& (mid==n-1||nums[mid] <nums[mid+1])){
                return nums[mid];
            }
            else if(nums[mid] <= nums[high])
                high = mid-1;
                else 
                low = mid+1;
            }
        return -1;
    }
}