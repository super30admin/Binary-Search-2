//## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

// Time Complexity : O(log n), a modified binary search
// Space Complexity :   Constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No


// Your code here along with comments explaining your approach in three sentences only

class Problem2 {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;

        // Fact: Atleast one portion, left or right will be sorted
        // Fact: Pivot/ min element always lies in the unsorted side 
        // We will use this to build up our solution
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[l]<=nums[r])   return nums[l];

            // Check if min element
            if((mid==0||nums[mid]<nums[mid-1]) &&
                ((mid==nums.length-1)||nums[mid]<nums[mid+1]))   return nums[mid];

            // Check if left sorted array: arr[l]<=arr[mid]
            if(nums[l]<=nums[mid]){
                // We search in right
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        // If not found
        return -1;
    }
}
