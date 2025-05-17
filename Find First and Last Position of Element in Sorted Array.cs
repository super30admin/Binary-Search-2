/*
  Time complexity: O(log n)
  Space complexity: O(1)

  Code ran successfully on Leetcode: Yes

  Approach: A binary search is performed on the input array for finding the first and last indices of target. In the first index computation if the target is found and the element previous to it is lower than target, then we have found the first index. Similarly for last index, if the target is found and is less than the index after it, we have found the last index.

*/

public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        if(nums==null || nums.Length==0) return new int[]{-1,-1};

        int firstIndex = -1, lastIndex = -1;

        int low = 0, high = nums.Length-1;

        firstIndex = GetFirstIndex(nums,low,high,target);
        lastIndex = GetLastIndex(nums,low,high,target);

        return new int[]{firstIndex,lastIndex};
    }

    private int GetFirstIndex(int[] nums, int low, int high ,int target)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==low || nums[mid-1]<target) return mid;
                else high = mid-1;
            }
            else
            {
                if(nums[mid]>target)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    private int GetLastIndex(int[] nums, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==high || nums[mid+1]>target) return mid;
                else low=mid+1;
            }
            else
            {
                if(nums[mid]>target)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
