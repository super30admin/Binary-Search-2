// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/find-peak-element/submissions/1041615843/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/* 
 * Use Binary search to find the peak element
 * while traversing, always traverse to that side where the element is greater than the current element
 * if the current element is greater than both the left amd right elements then return the current element
*/

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0)
            return -1;
        int low =0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if((mid==0||nums[mid]>nums[mid-1]) && (mid==high||nums[mid]>nums[mid+1]))
                return mid;
            else if(mid==high || nums[mid]<nums[mid+1])
                low=mid+1;
            else
                high=mid-1;
        }
        return 1890;
    }
}