// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only


class Solution {

    public int BinarySearchFirst(int[] nums , int target)
    {

        int low=0, high =nums.length-1;

        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(nums[mid] == target)
            {
                if(mid==0 || nums[mid] > nums[mid-1])
                 return mid;
                 else //keep on movingleft
                  high= mid-1;
            }
            else if(nums[mid]>target)
             high=mid-1;
            else
            low=mid+1;
        }
        return -1;
    }

   public int BinarySearchLast(int[] nums , int target, int low, int high)
   {
       while(low<=high)
       {
           int mid= low+(high-low)/2;
           if(nums[mid]==target)
           {
               if(mid==high|| nums[mid]<nums[mid+1])
               return mid;
               else //keep moving right
               low=mid+1;
           }
           else if(nums[mid]>target)
           high=mid-1;
           else
           low=mid+1;
       }
       return -1;
   }

    public int[] searchRange(int[] nums, int target) {

        if(nums==null||nums.length==0) return new int[] {-1,-1};
        int firstIndex= BinarySearchFirst(nums,target);
        if(firstIndex==-1) return new int[]{-1,-1};
        int secondIndex= BinarySearchLast(nums,target, firstIndex,nums.length-1);
        return new int[] {firstIndex, secondIndex};
        
    }
}