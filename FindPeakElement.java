// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We do a binary search on the array
// We check the neighbors of the middle element, and only search the side where the neighbor is greater than mid, because that side will definetely have a peak
// At any point if we find that middle is a peak, we return that value

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0; int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid==0||nums[mid-1]<nums[mid])&&
                (mid==nums.length-1||nums[mid+1]<nums[mid]))
                return mid;
            else if(nums[mid+1]>nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}