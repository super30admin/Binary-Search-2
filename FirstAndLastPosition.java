// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes , getting runtime error


// Your code here along with comments explaining your approach
//This is like a linear search just from two ends. First we start from left and see the first occurence of the targer.
//When we see the target we stop iterating and break the code
//Same thing done from right of the array when we see the element , we break the code
//And then we return the position we found in the first iteration and the position from the second iteration


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        
        int result[] = new int[]{-1,-1};
        int mid = (nums.length)/2;
        
        for (int i=0;i<=mid;i++)
        {
            if(nums[i]==target)
            {
                result[0]=i;
                break;
            }
        }
        
        for(int i = nums.length-1;i>mid;i--)
        {
            if(nums[i]==target)
            {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}