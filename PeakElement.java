// Time Complexity : log n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Compute the mid using binary search for the entire array, go towards the side where the neighbour element of mid is higher in value and continue
// with binary search approach till the point where the high and low coincide. This is will return once of the peak in the array.

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low=0;
        int high = n-1;

        while(low<=high){
            int mid= low+(high-low)/2;

            if((mid==0|| nums[mid]>nums[mid-1])&&(mid==n-1||nums[mid]>nums[mid+1])){
                return mid;
            } else if(mid>0 && nums[mid-1]>nums[mid]){
                high = mid-1;
            } else{
                low=mid+1;
            }
        }

        return -1;
    }
}