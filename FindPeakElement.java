// Time Complexity : O(logn)
// Space Complexity : O(1)
// Method used : Binary Search

class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;

        if(n == 1 || nums[0] > nums[1]) return 0;

        if(nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 0, high = n - 1, mid;

        while(low <= high)
        {
            mid = low + (high - low) / 2;

            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;

            else if(nums[mid] < nums[mid + 1]) low = mid + 1;

            else high = mid;
        }

        return -1;
    }
}