// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 Divide the array into two halves and individually check for the peak element.
Return -1 if no input is present.
Peak element is greater than number on its left and its right which is used as a checking condition.  
 */
public class findPeak{
    public int findPeakElement(int[] nums) {
        int low=0; 
        int n = nums.length;
        int high = n-1;
        if(nums==null|| nums.length==0)
        return -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if((mid==0 || nums[mid]> nums[mid-1])&&(mid==n-1 ||nums[mid]>nums[mid+1]))
            return mid;
            else if(nums[mid+1]>nums[mid])
            low = mid+1;
            else 
            high = mid-1;
        }
        return -1;
    }
    }