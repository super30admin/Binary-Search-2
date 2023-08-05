// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==-1) return -1;
        int len= nums.length-1;
        int low=0, high=len;

        while(low<=high)
        {
            int mid= low+(high-low)/2;
            System.out.println(mid);
            if((mid==0 || nums[mid]>nums[mid-1])&&(mid==len||nums[mid]>nums[mid+1])) // CHeck if mid element is greater than both neighbours
            return mid;
            else if(mid>0 && (nums[mid-1]>nums[mid])) // check if left element is greater than mid as there is a chance peak element can be on left side
            high=mid-1;
            else
            low=mid+1; // check right
        } 
       return -1; 
    }
}