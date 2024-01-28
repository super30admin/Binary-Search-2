//## Problem 3: (https://leetcode.com/problems/find-peak-element/)

// Time Complexity : O(log n) 
// Space Complexity :   Constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Problem3 {
    public int findPeakElement(int[] nums) {
        // The peak always lies on the increasing side
        // We can use this fact to traverse the array and cut search space in half
        int l=0, r=nums.length-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            // check if peak
            if((mid==0||nums[mid]>nums[mid-1]) &&
                (mid==(nums.length-1)||nums[mid]>nums[mid+1]))  return mid;

            // Move towards the increasing side
            if(mid!=0 && nums[mid]<nums[mid-1])    r=mid-1;
            else    l=mid+1;
        }

        return -1;
    }
}
