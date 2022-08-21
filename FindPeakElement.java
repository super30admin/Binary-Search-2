// Time complexity - O(logn)
// Space complexity - O(1)

// Approach - basically we calculate the mid, then we check if the mid is greater the previous and next element (make sure to check for bound or we will get index out of bounds exception), then this is a peak and we return it.
// If not, we go to the side that has the greater value (slope). So basically if the next element to the mid has a greater value
// We search on the right side as it is guaranteed to find the peak there. If the previous element is greater, then we go to left side

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0; int h = nums.length-1;
        while (l <= h) {
            int mid = l + (h-l)/2;
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            else if (nums[mid] < nums[mid+1]) {
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        return -1;
    }
}