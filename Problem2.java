// Find Minimum in rotated sorted array
// Time Complexity : O(log n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this: No
// Your code here along with comments explaining your approach: If the array is not rotated, then the first element is the smallest. 
//If the array is rotated, then the largest element is the left neighboring element of the smallest element. 
//So we have to find such a mid that mid-1 is greater that mid. 

class Solution {
    public int findMin(int[] nums) {

int start=0, end=nums.length-1;


if (nums==null)
{
    return 0;
}

if (nums.length==1)
{
    return nums[0];
}

while (start<end)
{
    int mid=(start+end)/2;

if (mid>0 && nums[mid] < nums[mid-1])
    {
        return nums[mid];
    }

     if(nums[start]<=nums[mid] && nums[mid]>nums[end])
    {
       start=mid+1;
    }
    else
    {
        end=mid-1;
    }
}
return nums[start];
}
}
