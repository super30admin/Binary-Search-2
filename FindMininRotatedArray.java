// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int findMin(int[] nums) {
        if(nums==null|| nums.length==0) return -1;
       
        int low=0,high = nums.length-1;
        while(low<=high)
        {
           
            if(nums[low]<=nums[high])
             {
                 return nums[low];
                }
             int mid= low+(high-low)/2;
             if((mid==0||nums[mid]<nums[mid-1]) && (nums[mid]< nums[mid+1]) ) // if first element or it is less than its both neighbours return it;
             {
                 return nums[mid];
             }
             else if(nums[low]<=nums[mid]){    //left sorted array, so check right unsorted array
                 low=mid+1;
             }
             else
                high= mid-1;  // right sorted array , so check left unsorted array
        }
      return -1;  
    }
}