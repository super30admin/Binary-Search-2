/*PROBLEM DESCRIPTION:
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.
Constraints:
1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
Example:Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.*/

/*Time Complexity :O(logn)
Space Complexity :O(1)
Approach:
Use binary search to find a peak element in O(log n) time. At each step, check if mid is greater than both neighbors → it's a peak. If not, move towards the side that has a larger neighbor (because a peak must exist there due to the problem constraints). The search continues until a peak is found.*/

class PeakElement {
    public int findPeakElement(int[] nums) {
        // handling empty array
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;// lower bound
        int high = nums.length - 1;// upper bound
        // Binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2;// Prevent Integer overflow
            // Check if mid is a peak:
            // mid is greater than both neighbors or at the boundary
            if ((mid == low || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1])) {
                return mid;// Found peak
            } else if (nums[mid + 1] > nums[mid]) { // If right neighbor is greater, move right
                low = mid + 1;
            } else {// Else move left
                high = mid - 1;
            }
        }
        return 877654;
    }
}
