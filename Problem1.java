// Find first and last position of element in sorted array
// Find Minimum in rotated sorted array
// Time Complexity : O(log n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this: Missed the edge cases
// Your code here along with comments explaining your approach: We will have two different functions implementing binary search. One to find the Starting index and another to find the ending. 
//In the function to find the starting index, we will move from mid to the left until we find a mid greater than mid-1. 
//In the function to find the ending index, we will move the mid to the right until we find a mid lesser than mid+1.

class Solution {
    public int[] searchRange(int[] nums, int target) {
int low=0,high=nums.length-1;

if(nums== null || nums.length == 0) return new int[] {-1, -1};

if(nums[0]>target || nums[nums.length-1]<target) return new int[] {-1,-1};


 int firstIndex=binarySearchFirst(nums,target);
int lastIndex=binarySearchLast(nums,firstIndex,target);


return new int[] {firstIndex,lastIndex};
        
    }

public int binarySearchFirst(int[] nums,int target)
{
    int low=0,high=nums.length-1;

    while(low<=high){
        int mid=low+(high-low)/2;
        if(nums[mid]==target)
        {
  //keep moving left until the element previous to the mid is less than it
      
            if((mid==0) || (nums[mid-1]<nums[mid]))
            {
                return mid;
                
            }
            else
            {
                high=mid-1;
            }

        }

        else if(nums[mid]<target)
        {
            low=mid+1;
        }
        else
        {
            high=mid-1;
        }

    }
    return -1;

}

public int binarySearchLast(int[] nums,int firstIndex, int target){
    int low=firstIndex,high=nums.length-1;

    while(low<=high){
        int mid=low+(high-low)/2;
        if(nums[mid]==target)
        {
  //keep moving right until the element next to the mid is greater than it
       
            if(mid==(nums.length-1) || (nums[mid]<nums[mid+1]))
            {
                return mid;
                 
            }
            else
            {
                low=mid+1;
            }

        }

        else if(nums[mid]<=target)
        {
            low=mid+1;
        }
        else
        {
            high=mid-1;
        }

    }
    return -1;

}


}