// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// I have created two functions - binarySearchFirst and binarySearchLast which gives the indices of the first and last occurrence of an element respectively. If first occurrence is -1, I return the int array {-1,-1} because it means that the element doesn't exist.
class Solution1 {

    private int binarySearchFirst(int []nums,int target)
    {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                ans = mid;
                high=mid-1;
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
        return ans;

    }

    private int binarySearchLast(int []nums,int first,int target)
    {
        int low = first;
        int high = nums.length-1;
        int ans = low;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                ans =  mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }

        }
        return ans;
    }


    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
        {
            return new int[] {-1,-1};
        }
        int first = binarySearchFirst(nums,target);
        if(first==-1)
        {
            return new int[] {-1,-1};
        }
        int last = binarySearchLast(nums,first,target);
        return new int[] {first,last};
    }
}