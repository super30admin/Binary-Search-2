/*
  Time complexity: O(log n)
  Space complexity: O(1)

  Code ra successfully on leetcode: Yes

  Approach: The minimum element always exists in the unsorted half considering that in a rotated sorted array one half is always sorted.

*/


public class Solution {
    public int FindMin(int[] nums) {
        int low = 0, high = nums.Length-1;

        while(low<high)
        {
            if(nums[low]<nums[high]) return nums[low];

            int mid = low+(high-low)/2;
            
            if((mid == 0 || nums[mid] < nums[mid - 1]) &&  nums[mid] < nums[mid + 1])
            {
                return nums[mid];
            }
            else
            {
                if(nums[mid]<nums[high])
                {
                    high=mid-1;
                }
                else
                {
                    low = mid+1;
                }
            } 
        }
        return nums[low];
    }
}
