/*PROBLEM DESCRIPTION:- 153. Find Minimum in Rotated Sorted Array
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.*/

/*Time Complexity :O(logn)
Space Complexity :O(1)
Approach:
We apply a modified binary search to find the minimum element in a rotated sorted array.If the current subarray [low..high] is already sorted, the minimum is nums[low].Otherwise, we check if mid is the minimum by comparing it with its neighbors.
Based on whether the left half is sorted or not, we decide which half to continue searching in.*/
class MinimumElement {
    public int findMin(int[] nums) {
        if (nums.length == 1) {// If array has only one element, return that as minimum
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        // If subarray is already sorted, the leftmost element is the minimum
        if (nums[low] <= nums[high]) {
            return nums[low];
        }
        // Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;// Prevent overflow
            // Check if nums[mid] is the minimum element.It should be smaller than both
            // neighbors (handle edges safely) and if mid is at the low boundary (mid ==
            // low) or at high boundary (mid == high), we skip checking nums[mid - 1] and
            // nums[mid+1] respectively to avoid out-of-bounds.
            if ((mid == low || nums[mid] < nums[mid - 1]) && (mid == high || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            // left array is sorted , minimum cannot be in this one, so searching right
            // half.
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {// If left half is not sorted, then right half must be sorted and the minimum
                    // lies in the left half (since rotation happened there).
                high = mid - 1;
            }
        }
        // Return -1 if minimum is not found.
        return -1;
    }
}