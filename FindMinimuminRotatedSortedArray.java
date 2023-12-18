// Time Complexity : O(logn)
// Space Complexity : O(1)
// Method used : Binary Search

class Solution {
    public int findMin(int[] nums) {
        
        int left = 0, right = nums.length - 1, mid;

        if(nums[left] < nums[right]) return nums[left];

        while(left < right)
        {
            mid = left + (right - left) / 2;

            if(nums[mid] <= nums[right]) right = mid;

            else left = mid + 1;
        }

        return nums[left];
    }
}