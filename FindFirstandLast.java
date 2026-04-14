
// Time Complexity :O(2 LogN)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Yes

// Your code here along with comments explaining your approach in three sentences only
// I made use of the solution discussed in class.
// We make use of 2 seperate binary search
// First we find the first element if it occurs and then we find the position of the first element in the array using binary search
// If we dont find the first element we return -1,-1 no need to find second element
// If we find the first element, we can decrease the serach space by making first elemenet index as low
// Once we find the second element we return the index of first and second element in an array
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int firstelement=FindFirstElement(nums,target,0,nums.length-1);

        if(firstelement==-1)
        {
            return new int[]{-1,-1};
        }

        int secondelement = FindSecondElement(nums,target,firstelement, nums.length-1);

        return new int[] {firstelement,secondelement};
        
    }

    public static int FindFirstElement(int[] nums, int target , int low, int high)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==0 || nums[mid-1]!=target)
                {
                    return mid;
                }
                else
                {
                    high=mid-1;
                }
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
    
        }   
             return -1;
    }
public static int FindSecondElement(int[] nums, int target , int low, int high)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==nums.length-1 || nums[mid+1]!=target)
                {
                    return mid;
                }
                else
                {
                    low=mid+1;
                }
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
     
        }
               return -1;
    }
}
