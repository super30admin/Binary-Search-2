/**
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1] if the element is not present in the input

Time Complexity : O(logN)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : The boundary Conditions, 
the code kept on breaking at boundary condition for few submissions


Brute Force: Single pass to find the occurence

find any occurence using plain binary search

**/
class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int output[] = new int[]{-1,-1};
        
        if(nums.length == 0)
            return output;
        
        if(nums.length ==1)
        {
            if(nums[0]==target)
            {
                return new int[]{0,0};
            }
            
            return output;
        }
        
        
            
        int firstPosition = findFirstOccurence(nums, target);
        
        if(firstPosition == nums.length || nums[firstPosition] != target)
        {
            return output;
        }
        
        int lastPosition = findFirstOccurence(nums, target+1) -1;
        
        return new int[]{firstPosition,lastPosition};
    }
    
    private int findFirstOccurence(int nums[], int target)
    {
        int firstPosition = nums.length;
        
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high)
        {
            
            int mid = low + (high-low)/2;
            int midVal = nums[mid];
            
            if(midVal >= target)
            {
                high = mid -1;
                firstPosition = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return firstPosition;
    }
}