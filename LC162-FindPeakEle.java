// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only

/*
 Move left to mid+1, if nums[mid+1] > nums[mid]
 Move right to mid-1, if nums[mid-1] > nums[mid]
 else mid is our peak
 */

class Solution {
    public int findPeakElement(int[] nums) {

        int l = 0;
        int r = nums.length -1;
        
        // edge case
        if (r>0 && nums[l+1]<nums[l]) return l;
        else if (r>0 && nums[r-1]<nums[r]) return r;

        while (l<r) {
            int mid = l + (r-l)/2;

            if (nums[mid+1] > nums[mid]) l = mid+1;
            else if (nums[mid-1] > nums[mid] ) r = mid-1;
            else return mid; // this is our peak
        }

        return r;
        
    }
}