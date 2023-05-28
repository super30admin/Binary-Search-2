// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding Edge cases


// Your code here along with comments explaining your approach
// I have performed Binary search as this is a sorted array we know one side is always sorted and the min element always lie in
// the unsorted side.
// we need to check if the mid is min element by comparing it with mid-1 and mid+1 
class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int n = nums.length;
        int high = n-1;
        if(nums == null || high ==-1) return 0;
        while(low<=high)
        {
            if(nums[low]<= nums[high]) return nums[low];
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid] < nums[mid-1])  && (mid== n-1 || nums[mid]< nums[mid+1])) return nums[mid];
            else if( nums[low]<= nums[mid])//left sorted
                low=mid+1; // the min element always lies in the unsorted side
            else 
                high=mid-1;
        }
        return Integer.MIN_VALUE;
    }
}