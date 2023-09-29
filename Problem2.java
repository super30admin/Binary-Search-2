//Time Complexity : O(logn)
//Space Complexity : O(1)
//Did it run on Leetcode : Yes
//Any difficulties while working on the code: No


class Solution {
    public int findMin(int[] nums) {
        int low =0; int high = nums.length -1;
        int minimum = nums[low];

        while (low <= high){
            int mid = low + (high-low)/2;
            if (nums[low] <= nums[mid])
            {
                minimum = Math.min(minimum, nums[low]);
                low = mid + 1;
            }
            else if (nums[mid] <= nums[high])
            {
                minimum = Math.min(minimum, nums[mid]);
                high = mid - 1;
            }
        } return minimum; 
    }
}
