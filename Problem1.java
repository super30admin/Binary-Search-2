//## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Time Complexity : O(log n), run binary search two times
// Space Complexity : Constant space utilized
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No


// Your code here along with comments explaining your approach in three sentences only

class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        int first=-1, last=-1;

        //Find first index by doing the following binary search
        int l=0, r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            // If number found we check if it is the first index
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]!=target){
                    first=mid;
                    break;
                }
                // If not, then the first index must lie on left side
                else    r=mid-1;
            }
            // Target not found, check in left
            else if(target<nums[mid]){
                r=mid-1;
            }
            // Target not found, check in right
            else l=mid+1;   
        }

        // Element not found
        if(first==-1)   return new int[] {first, last};

        //Element found, find last index by doing the following binary search
        // We can start the search from the first index
        l=first; r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                // If number found we check if it is the last index of targer
                if((mid==nums.length-1)||nums[mid+1]!=target){
                    last=mid;
                    break;
                }
                // if not then it must lie on right side
                else    l=mid+1;
            }
            else r=mid-1;   
        }

        return new int[] {first, last};
    }
}
