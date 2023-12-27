// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Modified binary search approach. It sets the starting and ending indices for the target range
// and employs binary search logic while updating these indices to determine the leftmost and
// rightmost occurrences of the target value.

class problem1 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if(nums.length == 0) return ans;
        while(start <= end)
        {
            int mid = start + ((end - start)/2);
            if(nums[mid] == target)
            {
                if(nums[mid - 1] < target)
                {
                    ans[0] = mid;
                    start = mid + 1;
                }
                else if(nums[mid + 1] > target)
                {
                    ans[1] = mid;
                    end = mid - 1;
                }
            }
            else if(nums[mid - 1] < target) start = mid + 1;
            else end = mid - 1;
        }
        return ans;
    }
}