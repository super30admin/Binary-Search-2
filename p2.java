// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// Using binary search in here to find the element. If the array is sorted, I just return the first element. Everytime I check if the mid
// is the lowest or not. I reject the left half or the right half based on which side is sorted

class Solution {
    public int findMin(int[] nums) {
        int h = nums.length - 1;
        if (nums[0] <= nums[h])
            return nums[0];
        int l = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[l] < nums[h])
                return nums[l];

            if ((mid == nums.length - 1 || nums[mid] < nums[mid + 1]) &&
                    (nums[mid] < nums[mid - 1])) {
                return nums[mid];
            } else if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;

    }
}